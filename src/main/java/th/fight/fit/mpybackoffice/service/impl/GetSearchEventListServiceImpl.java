/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.MasEventDao;
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.dao.PckUserSessionDao;
import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.domain.MasEventLocation;
import th.fight.fit.mpybackoffice.domain.MasSport;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.model.GetEvent.EventLists;
import th.fight.fit.mpybackoffice.model.GetEvent.SearchEventListResponeRESTModel;
import th.fight.fit.mpybackoffice.model.StarRewardManagement.SearchRewardsListResponeRESTModel;
import th.fight.fit.mpybackoffice.util.MasterUtils;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;
import th.fight.fit.mpybackoffice.service.GetSearchEventListService;

/**
 *
 * @author Sent
 */
@Service
public class GetSearchEventListServiceImpl implements GetSearchEventListService {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    @Autowired
    private MasEventDao masEventDao;
//    @Autowired
//    private PckUserSessionDao pckUserSessionDao;
//    @Autowired
//    private PckProfileDao pckProfileDao;

    
    
    //แก้ Service Search
    public SearchEventListResponeRESTModel getSearchEventListbyName(String sid, String language, String requestIndex, String requestRowPerPage, String eventName,
            String eventId,String eventLocationId,String searchDateTimeFrom, String searchDateTimeTo) throws Exception {
        SearchEventListResponeRESTModel result = new SearchEventListResponeRESTModel();
        List<EventLists> eventList = new ArrayList<EventLists>();

        boolean remaindRecordFlag = false;
        int index = 0;
        int rowPerPage = 0;

        try {

            if (NumberUtils.isDigits(requestIndex) && NumberUtils.isDigits(requestRowPerPage)) {
                index = Integer.parseInt(requestIndex);
                rowPerPage = Integer.parseInt(requestRowPerPage);
                MasEvent masEvent = new MasEvent();
                masEvent.setIsDelete(ProjectConstant.STATUS_N);

                if (StringUtils.isNotEmptyOrNull(eventName)) {

                    masEvent.setEventName(eventName);
                    systemLogger.info(LogFormatter.info(sid, " --> 1.Set Event name " + masEvent.getEventName()));

                } else {
                    masEvent.setEventName(null);
                }

                if (StringUtils.isNotEmptyOrNull(eventName)) {

                    masEvent.setEventName(eventName);
                    systemLogger.info(LogFormatter.info(sid, " --> 1.2.Set  searchByName " + masEvent.getEventName()));

                } else {
                    masEvent.setEventName(null);
                }

                List<EventLists> eventListDB = new ArrayList<EventLists>();
                List<MasEvent> masEventListDB = masEventDao.getSearchMasEvent(masEvent, index, rowPerPage);

                systemLogger.info(LogFormatter.info(sid, " --> 2.Get masRewardListDB"));

                for (MasEvent masEventDB : masEventListDB) {
                    EventLists eventLists = new EventLists();

                    List<MasEventLocation> masEventLocationListDB = (MasterUtils.loadMasEventLocation(masEventDB.getEventLocationId()));
                    MasEventLocation masEventLocationDB = masEventLocationListDB != null && masEventLocationListDB.size() > 0 ? masEventLocationListDB.get(0) : null;

                    systemLogger.info(LogFormatter.info(sid, " --> 7.GetColor from LoadMasStatus"));

                    if (masEventLocationDB != null) {
//                    eventLists.set("<button disabled style=\"background-color:" + masEventLocationDB.getColor() + "; border: 2px; padding: 3px; border-radius: 4px; width: 80px; font-color: white;\"><font color=\"white\">" + masRewardDB.getRedeemStatus() + "</font></button>");

                    }

                    eventLists.setLatitude(String.valueOf(masEventLocationDB.getLatitude()));
                    eventLists.setLongtitude(String.valueOf(masEventLocationDB.getLongitude()));

                    eventLists.setFromTime(masEventDB.getFromTime());
                    eventLists.setToTime(masEventDB.getToTime());
                    eventLists.setUrlLocationPicture(masEventLocationDB.getLocationPictureUrl());

                    List<MasSport> masSportListDB = (MasterUtils.loadMasSport(masEventDB.getSportId()));
                    MasSport MasSportDB = masSportListDB != null && masSportListDB.size() > 0 ? masSportListDB.get(0) : null;
                    if (MasSportDB != null) {
                        eventLists.setSportName(MasSportDB.getSportName());
                    }

//                rewardList.setStatus(masRewardDB.getRedeemStatus());
                    //set to modal edit Reward
                    eventListDB.add(eventLists);

                }
//                    int count = masRewardDao.getCountSearchMasReward(masEvent);
                int count = 0;
                if ((index + rowPerPage) < count) {
                    result.setRemaindRecordFlag(true);
                } else {
                    result.setRemaindRecordFlag(false);
                }
                result.setRecordsFiltered(String.valueOf(count));
                result.setRecordsTotal(String.valueOf(count));
                result.setRemaindRecordFlag(remaindRecordFlag);
                result.setEventLists(eventListDB);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            throw e;
        }
        return result;
    }

//    public SearchEventListResponeRESTModel transactionDeleteEvent(String sid, String language, String eventId) throws Exception {
//        SearchEventListResponeRESTModel result = new SearchEventListResponeRESTModel();
//        Date currentDate = new Date();
////        int quantityEx = 0;
//
//        try {
//            if (StringUtils.isNotEmptyOrNull(sid) && StringUtils.isNotEmptyOrNull(language)) {
//
////                PckUserSession pckUserSession = new PckUserSession();
////                pckUserSession.setSid(sid);
////                List<PckUserSession> pckUserSessionListDB = pckUserSessionDao.getPckUserSession(pckUserSession);
////                PckUserSession pckUserSessionDB = pckUserSessionListDB != null && pckUserSessionListDB.size() > 0 ? pckUserSessionListDB.get(0) : null;
////                systemLogger.info(LogFormatter.info("-> 1.set sid for get uid" + sid));
////                if (pckUserSessionDB != null && StringUtils.isNotEmptyOrNull(pckUserSessionDB.getUid())) {
//                PckProfile pckProfile = new PckProfile();
////                    pckProfile.setUid(pckUserSessionDB.getUid());
////                    pckProfile.setIsDelete(ProjectConstant.STATUS_N);
////                    List<PckEmployee> pckEmployeeListDB = pckEmployeeDao.getPckEmployee(pckProfile, null, null);
////                    PckEmployee pckEmployeeDB = pckEmployeeListDB != null && pckEmployeeListDB.size() > 0 ? pckEmployeeListDB.get(0) : null;
////                    systemLogger.info(LogFormatter.info(sid, "-> 2.set uid for get FirstName - pckEmployee" + pckUserSessionDB.getUid()));
//
////                    if (StringUtils.isNotEmptyOrNull(rewardId) && StringUtils.isNotEmptyOrNull(quantityExchange)) {
//                if (StringUtils.isNotEmptyOrNull(eventId)) {
//                    systemLogger.info(LogFormatter.info(sid, "-> 3.eventId = " + eventId ));
//
//                    MasEvent masEvent = new MasEvent();
//                    masEvent.setEventId(Integer.valueOf(eventId));
//                    masEvent.setIsDelete(ProjectConstant.STATUS_N);
//                    systemLogger.info(LogFormatter.info(sid, "-> 4.set masEvent"));
//
////                    if (quantityEx == 0) {
//
//                        List<MasEvent> masEventListDB = masEventDao.getMasEvent(masEvent);
//                        MasEvent masEventDB = masEventListDB != null && masEventListDB.size() > 0 ? masEventListDB.get(0) : null;
//                        systemLogger.info(LogFormatter.info(sid, "-> 5.get masReward"));
//
////                        if (masEventDB != null && pckEmployeeDB != null) {
//                        if (masEventDB != null ) {
//
//                            masEventDB.setIsDelete(ProjectConstant.STATUS_Y);
//                            masEventDB.setUpdateDate(currentDate);
//                            masEventDB.setUpdateBy(ProjectConstant.STATUS_FAIL);
//
//                            masEventDao.updateMasEvent(masEventDB);
//                            systemLogger.info(LogFormatter.info(sid, "- 6.Delete a Reward, masReward complete."));
//
//                        }
////                        }
////                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        }
//
//        return result;
//    }

}
