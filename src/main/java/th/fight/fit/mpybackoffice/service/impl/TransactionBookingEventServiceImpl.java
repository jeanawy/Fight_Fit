/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.dao.PckUserEventDao;
import th.fight.fit.mpybackoffice.dao.PckUserSessionDao;
import th.fight.fit.mpybackoffice.dao.TranEventDao;
import th.fight.fit.mpybackoffice.dao.TranUserDao;
import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.domain.MasEventLocation;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.domain.PckUserEvent;
import th.fight.fit.mpybackoffice.domain.PckUserSession;
import th.fight.fit.mpybackoffice.domain.TranEvent;
import th.fight.fit.mpybackoffice.domain.TranUser;
import th.fight.fit.mpybackoffice.exception.DatabaseException;
import th.fight.fit.mpybackoffice.exception.ServiceValidation;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement.TransactionBookingEvent;
import th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement.VerifyTransactionBookingEvent;
import th.fight.fit.mpybackoffice.service.DB2SequencerService;
import th.fight.fit.mpybackoffice.service.TransactionBookingEventService;
import th.fight.fit.mpybackoffice.util.DateUtil;
import static th.fight.fit.mpybackoffice.util.DateUtil.DATE_PATTERN;
import th.fight.fit.mpybackoffice.util.MasterUtils;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Service
public class TransactionBookingEventServiceImpl implements TransactionBookingEventService {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    @Autowired
    private PckUserSessionDao pckUserSessionDao;
    @Autowired
    private PckUserEventDao pckUserEventDao;
    @Autowired
    private DB2SequencerService db2SequencerService;
    @Autowired
    private PckProfileDao pckProfileDao;
    @Autowired
    private TranUserDao tranUserDao;
    @Autowired
    private TranEventDao tranEventDao;

    public VerifyTransactionBookingEvent verifyTransactionBookingEvent(String sid, String language, String eventId, String timeBookingFrom, String timeBookingTo, String uidOfJoin) throws Exception {
        VerifyTransactionBookingEvent result = new VerifyTransactionBookingEvent();
        Boolean successTime = true;
        Date currentDate = new Date();
        Date fromTime = new Date();
        Date toTime = new Date();
        try {
            if (sid != null) {
                try {
                    if (timeBookingFrom.length() != 16 || timeBookingTo.length() != 16) {
//                        systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : timeBooking is incorrect pattern -> -> dd/mm/yyyy hh:mm"));
//                        throw new ServiceValidation(ProjectConstant.TRANSACTION_BOOKING_ROOM_ERROR_CODE_SERVICE_VALIDATION_REQUEST_DATE_INPUT_PATTERN);
                    }
                    fromTime = DateUtil.parseForBEMinEN(timeBookingFrom);
                    toTime = DateUtil.parseForBEMinEN(timeBookingTo);
                    systemLogger.info(LogFormatter.info(sid.toString(), "-> timeFrom = " + fromTime));
                    systemLogger.info(LogFormatter.info(sid.toString(), "-> timeTo = " + toTime));
                } catch (Exception e) {
//                    systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : timeBooking is incorrect pattern -> dd/mm/yyyy hh:mm"));
//                    throw new ServiceValidation(ProjectConstant.TRANSACTION_BOOKING_ROOM_ERROR_CODE_SERVICE_VALIDATION_REQUEST_DATE_INPUT_PATTERN);
                }
                PckUserSession pckUserSession = new PckUserSession();
                pckUserSession.setSid(sid) ;
                List<PckUserSession> pckUserSessionList = pckUserSessionDao.getPckUserSession(pckUserSession);
                PckUserSession pckUserSessionListDB = pckUserSessionList != null && pckUserSessionList.size() > 0 ? pckUserSessionList.get(0) : null;
                if (pckUserSessionListDB != null && StringUtils.isNotEmptyOrNull(pckUserSessionListDB.getUid())) {

                    result.setUid(pckUserSessionListDB.getUid());
                    systemLogger.info(LogFormatter.info(sid.toString(), "- set uid for result complete ."));

                    if (StringUtils.isNotEmptyOrNull(eventId)) {
                        MasEvent masEventDB = MasterUtils.loadMasEvent(eventId) != null && MasterUtils.loadMasEvent(eventId).size() > 0 ? MasterUtils.loadMasEvent(eventId).get(0) : null;

                        if (masEventDB != null) {

                            String eventLocationId = String.valueOf(masEventDB.getEventLocationId());
                            //สร้างตัวแปรตัวเดียวแล้วเช็ตเอา
                            MasEventLocation masEventLocationDB = MasterUtils.loadMasEventLocation(eventLocationId) != null && MasterUtils.loadMasEventLocation(eventLocationId).size() > 0 ? MasterUtils.loadMasEventLocation(eventLocationId).get(0) : null;

                            if (masEventLocationDB != null) {
                                if (masEventLocationDB.getIsDelete().equalsIgnoreCase(ProjectConstant.STATUS_N)) {
                                        if (masEventDB.getIsDelete().equalsIgnoreCase(ProjectConstant.STATUS_Y)) {
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- This roomid is delete ."));
                                        }                                
                                } else {
                                    systemLogger.info(LogFormatter.info(sid.toString(), "- This building is delete ."));
                                }
                            } else {
                                systemLogger.info(LogFormatter.info(sid.toString(), "- This building is invalid ."));
                            }

                            result.setEventId((masEventDB.getEventId()).toString());
                            result.setEventName((masEventDB.getEventName()));
                            systemLogger.info(LogFormatter.info(sid.toString(), "- set roomId for result complete ."));
                            systemLogger.info(LogFormatter.info(sid.toString(), "- set roomName for result complete ."));

                            DateFormat formatTest = new SimpleDateFormat(DATE_PATTERN);
                            systemLogger.info(LogFormatter.info(sid.toString(), "- currentDate format " + formatTest.format(currentDate)));
                            systemLogger.info(LogFormatter.info(sid.toString(), "- formTime format " + formatTest.format(fromTime)));
                            systemLogger.info(LogFormatter.info(sid.toString(), "- toTime format " + formatTest.format(toTime)));
                            String currentDateString = formatTest.format(currentDate);

                            if (DateUtil.compareDateOnly(currentDateString, timeBookingFrom) <= 0 && DateUtil.compareDateOnly(currentDateString, timeBookingTo) <= 0) {
                                if (DateUtil.compareDateOnly(timeBookingFrom, timeBookingTo) == 0) {

                                    PckUserEvent pckUserEvent = new PckUserEvent();
                                    pckUserEvent.setEventId((eventId));

                                    List<PckUserEvent> pckUserEventList = pckUserEventDao.getPckUserEvent(pckUserEvent);
                                    if (pckUserEventList != null) {

                                        if (DateUtil.compareDateOnly(currentDateString, timeBookingFrom) == 0 && DateUtil.compareDateOnly(currentDateString, timeBookingTo) == 0) {
                                            if (currentDate.compareTo(fromTime) > 0 && currentDate.compareTo(toTime) > 0) {
                                                systemLogger.info(LogFormatter.info(sid.toString(), "- time is before : successTime = false"));
                                                throw new ServiceValidation();
                                            }
                                        }

                                        if (toTime.before(fromTime)) {
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- toTime before fromTime"));
                                            throw new ServiceValidation();
                                        }

                                        for (PckUserEvent pckUserEventDB : pckUserEventList) {
//                                        if ((fromTime.before(pckUserMeetingRoomDB.getFromTime()) && !toTime.after(pckUserMeetingRoomDB.getFromTime())) || (!fromTime.before(pckUserMeetingRoomDB.getToTime()) && toTime.after(pckUserMeetingRoomDB.getToTime()))) {
                                            if (((fromTime.compareTo(pckUserEventDB.getFromTime()) < 0 && toTime.compareTo(pckUserEventDB.getToTime()) <= 0) || (fromTime.compareTo(pckUserEventDB.getToTime()) >= 0 && toTime.compareTo(pckUserEventDB.getToTime()) > 0))) {
                                                successTime = true;
                                            } else {
                                                if (ProjectConstant.STATUS_CANCELBOOK.equalsIgnoreCase(pckUserEventDB.getEventStatus())) {
                                                    successTime = true;
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- time is match : successTime = true cause STATUS_CANCLE"));
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- fromTime : " + fromTime + " match " + pckUserEventDB.getFromTime() + " in base"));
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- toTime : " + toTime + " match " + pckUserEventDB.getToTime() + " in base"));
                                                } else {
                                                    successTime = false;
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- time is match : successTime = false"));
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- fromTime : " + fromTime + " match " + pckUserEventDB.getFromTime() + " in base"));
                                                    systemLogger.info(LogFormatter.info(sid.toString(), "- toTime : " + toTime + " match " + pckUserEventDB.getToTime() + " in base"));
                                                    break;
                                                }
                                            }
                                        }

                                        if (successTime) {
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- successTime = true"));
                                            result.setTimeBookingFrom(fromTime);
                                            result.setTimeBookingTo(toTime);
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- set timeBookingFrom for result complete ."));
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- set timeBookingTo for result complete ."));
                                        } else {
                                            systemLogger.info(LogFormatter.info(sid.toString(), "- Service Validation : this time can't booking"));
                                            throw new ServiceValidation();
                                        }
                                    }

                                    Boolean uidMatch = false;

                                    if (StringUtils.isNotEmptyOrNull(uidOfJoin)) {
                                        List<String> parts = Arrays.asList(uidOfJoin.split(","));

                                        for (String uidPart : parts) {
                                            PckProfile pckProfile = new PckProfile();
                                            pckProfile.setUid(uidPart);
                                            pckProfile.setIsDelete(ProjectConstant.STATUS_N);
                                            List<PckProfile> pckProfileList = pckProfileDao.getPckProfile(pckProfile);
                                            PckProfile pckProfileDB = pckProfileList != null && pckProfileList.size() > 0 ? pckProfileList.get(0) : null;

                                            if (pckProfileDB != null) {

                                                if (pckUserSessionListDB.getUid().equalsIgnoreCase(uidPart)) {
                                                    uidMatch = true;
                                                }
                                            } else {
                                                systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : uidOfAttendees not found in database."));
                                                throw new ServiceValidation();
                                            }
                                        }
                                    }

                                    if (uidMatch) {
                                        result.setUidOfJoin(uidOfJoin);
                                    } else {
                                        if (StringUtils.isEmptyOrNull(uidOfJoin)) {
                                            uidOfJoin = pckUserSessionListDB.getUid();
                                        } else {
                                            uidOfJoin = pckUserSessionListDB.getUid() + "," + uidOfJoin;
                                        }
                                        result.setUidOfJoin(uidOfJoin);

                                    }

                                 
                                } else {
                                    systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : fromTime and toTime not in 1 day"));
                                    throw new ServiceValidation();
                                }
                            } else {
                                systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : fromTime and toTime is before currentDate"));
                                throw new ServiceValidation();
                            }

                        }//(masMeetingRoomDB != null)
                        else {
                            systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : roomId not found."));
                            throw new ServiceValidation();
                        }
                    }//(StringUtils.isNotEmptyOrNull(roomId))
                    else {
                        systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : roomId is null."));
                        throw new ServiceValidation();
                    }

                }//(pckUserSessionListDB != null)
                else {
                    systemLogger.info(LogFormatter.info(sid.toString(), "- Service validation : can't find uid by this sid."));
                    throw new ServiceValidation();
                }

            }//(sid != null)

        } catch (DatabaseException e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        } catch (ServiceValidation e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return result;

    }

    public TransactionBookingEvent transactionBookingEvent(String sid, String language, VerifyTransactionBookingEvent result) throws Exception {
    TransactionBookingEvent response = new TransactionBookingEvent();
        Boolean successTime = true;
        Date currentDate = new Date();
        systemLogger.info(LogFormatter.info(sid.toString(), "-> current date = " + currentDate));
        Date fromTime = result.getTimeBookingFrom();
        Date toTime = result.getTimeBookingTo();
        systemLogger.info(LogFormatter.info(sid.toString(), "-> timeFrom = " + fromTime));
        systemLogger.info(LogFormatter.info(sid.toString(), "-> timeTo = " + toTime));

        try {
            PckProfile pckProfile = new PckProfile();
            pckProfile.setUid(result.getUid());
            pckProfile.setIsDelete(ProjectConstant.STATUS_N);
            List<PckProfile> pckProfileListDB = pckProfileDao.getPckProfile(pckProfile);
            PckProfile pckProfileDB = pckProfileListDB != null && pckProfileListDB.size() > 0 ? pckProfileListDB.get(0) : null;

            if (pckProfileDB != null) {

                PckUserEvent pckUserEvent = new PckUserEvent();
                pckUserEvent.setEventId((result.getEventId()));
                pckUserEvent.setFromTime(fromTime);
                pckUserEvent.setToTime(toTime);
                pckUserEvent.setIsDelete(ProjectConstant.STATUS_N);
                List<PckUserEvent> pckUserEventList = pckUserEventDao.getPckUserEvent(pckUserEvent);
                
                long tranUserID = db2SequencerService.getSeqNumTransaction(ProjectConstant.SEQ_TRAN_USER);

                if (pckUserEventList != null && !pckUserEventList.isEmpty()) {

                    for (PckUserEvent pckUserEventDB : pckUserEventList) {

                        if (((fromTime.compareTo(pckUserEventDB.getFromTime()) < 0 && toTime.compareTo(pckUserEventDB.getToTime()) <= 0) || (fromTime.compareTo(pckUserEventDB.getToTime()) >= 0 && toTime.compareTo(pckUserEventDB.getToTime()) > 0))) {
                            successTime = true;
                        } else {
                            if (ProjectConstant.STATUS_CANCELBOOK.equalsIgnoreCase(pckUserEventDB.getEventStatus())) {
                                successTime = true;
                                systemLogger.info(LogFormatter.info(sid.toString(), "- time is match : successTime = true cause STATUS_CANCLE"));
                                systemLogger.info(LogFormatter.info(sid.toString(), "- fromTime : " + fromTime + " match " + pckUserEventDB.getFromTime() + " in base"));
                                systemLogger.info(LogFormatter.info(sid.toString(), "- toTime : " + toTime + " match " + pckUserEventDB.getToTime() + " in base"));
                                break;
                            } else {
                                successTime = false;
                            }
                        }
                    }

                }//(pckeventList != null)

                if (successTime) {
                    List<String> parts = Arrays.asList(result.getUidOfJoin().split(","));

                    for (String uidPart : parts) {

                        PckUserEvent pckUserEventInsert = new PckUserEvent();
                        pckUserEventInsert.setUid(uidPart);
                        pckUserEventInsert.setEventId(result.getEventId());
                        pckUserEventInsert.setTranIdGen(BigInteger.valueOf(tranUserID));
                        pckUserEventInsert.setTranIdCancel(null);
                        pckUserEventInsert.setFromTime(result.getTimeBookingFrom());
                        pckUserEventInsert.setToTime(result.getTimeBookingTo());
                        pckUserEventInsert.setUidJoin(result.getUidOfJoin());
                        if (result.getUid().equalsIgnoreCase(uidPart)) {
                            pckUserEventInsert.setEventStatus(ProjectConstant.BOOKING);
                        } else {
                            pckUserEventInsert.setEventStatus(ProjectConstant.JOINBOOKING);
                        }
                        pckUserEventInsert.setIsDelete(ProjectConstant.STATUS_N);
                        pckUserEventInsert.setCreateDate(currentDate);
                        pckUserEventInsert.setCreateBy(pckProfileDB.getFirstName());

                        pckUserEventDao.insertPckUserEvent(pckUserEventInsert);
                        systemLogger.info(LogFormatter.info(sid.toString(), "- Insert pck user meeting room for uid = " + uidPart));

                    }//(String uidPart : part)
                }//(successTime)
                else {
                    systemLogger.info(LogFormatter.info(sid.toString(), "- This time can not booking  ."));
                    throw new ServiceValidation();
                }

                TranUser tranUser = new TranUser();

                tranUser.setTranId(BigInteger.valueOf(tranUserID));
                tranUser.setTranCode(ProjectConstant.BOOKING);
                tranUser.setUid(result.getUid());
                tranUser.setTranRef(BigInteger.valueOf(tranUserID));
                tranUser.setEventId(Integer.valueOf(result.getEventId()));
                tranUser.setRankingId(null);

                tranUser.setIsDelete(ProjectConstant.STATUS_N);
                tranUser.setCreateDate(currentDate);
                tranUser.setCreateBy(pckProfileDB.getFirstName());

                tranUserDao.insertTranUser(tranUser);
                systemLogger.info(LogFormatter.info(sid.toString(), "- Insert user transaction complete."));

                TranEvent tranEvent = new TranEvent();
                tranEvent.setTranId(BigInteger.valueOf(tranUserID));
                tranEvent.setTranCode(ProjectConstant.BOOKING);
                tranEvent.setUid(result.getUid());
                tranEvent.setEventId((result.getEventId()));
                tranEvent.setFromTime(result.getTimeBookingFrom());
                tranEvent.setToTime(result.getTimeBookingTo());
                tranEvent.setUidJoin(result.getUidOfJoin());
                tranEvent.setIsDelete(ProjectConstant.STATUS_N);
                tranEvent.setCreateDate(currentDate);
                tranEvent.setCreateBy(pckProfileDB.getFirstName());

                tranEventDao.insertTranEvent(tranEvent);
                systemLogger.info(LogFormatter.info(sid.toString(), "- Insert meeting room transaction complete."));

                response.setTransactionId(String.valueOf(tranUserID));
                response.setTransactionDateTime(DateUtil.formatDateTime(currentDate));
                response.setEventName(result.getEventName());
                response.setTimeBookingFrom(DateUtil.formatDateTime(result.getTimeBookingFrom()));
                response.setTimeBookingTo(DateUtil.formatDateTime(result.getTimeBookingTo()));
                systemLogger.info(LogFormatter.info(sid.toString(), "- set response complete."));
            } else {
                systemLogger.info(LogFormatter.info(sid.toString(), "- Database exception : เดี๋ยวมาแก้ ."));
                throw new DatabaseException();
            }

        } catch (DatabaseException e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        } catch (ServiceValidation e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }

        return response;
    }
    
    
    
    
    

}
