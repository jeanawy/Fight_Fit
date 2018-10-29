/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.MasEventDao;
import th.fight.fit.mpybackoffice.dao.MasEventLocationDao;
import th.fight.fit.mpybackoffice.dao.MasSportDao;
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.dao.PckUserEventDao;
import th.fight.fit.mpybackoffice.dao.PckUserSessionDao;
import th.fight.fit.mpybackoffice.dao.TranEventDao;
import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.domain.MasEventLocation;
import th.fight.fit.mpybackoffice.domain.MasSport;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.domain.PckUserSession;
import th.fight.fit.mpybackoffice.domain.TranEvent;
import th.fight.fit.mpybackoffice.exception.DatabaseException;
import th.fight.fit.mpybackoffice.exception.ServiceValidation;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.model.CreateEvent.CreateEvent;
import th.fight.fit.mpybackoffice.model.GetEvent.EventLists;
import th.fight.fit.mpybackoffice.service.DB2SequencerService;
import th.fight.fit.mpybackoffice.service.EventService;
import th.fight.fit.mpybackoffice.util.DateUtil;
import th.fight.fit.mpybackoffice.util.Utility;

/**
 *
 * @author Sent
 */
@Service
public class EventServiceImpl implements EventService {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
    
    @Autowired
    private TranEventDao tranEventDao;
    @Autowired
    private PckUserEventDao pckUserEventDao;
    @Autowired
    private MasEventLocationDao masEventLocationDao;
    @Autowired
    private MasSportDao masSportDao;
    @Autowired
    private MasEventDao masEventDao;
    @Autowired
    private DB2SequencerService db2SequencerService;
    @Autowired
    private PckUserSessionDao pckUserSessionDao;
    @Autowired
    private PckProfileDao pckProfileDao;

//    public void createRewardTable(String sid, CreateEvent createEvent) throws Exception {
//        MasEvent masEvent = new MasEvent();
//        MasEventLocation masEventLocation = new MasEventLocation();
//        Date currentDate = new Date();
//        Boolean successTime = true;
//        Date fromTime = new Date();
//        Date toTime = new Date();
//        
//        try {
//            PckUserSession pckUserSessionPre = new PckUserSession();
//            pckUserSessionPre.setSid(sid);
//            pckUserSessionPre.setSidStatus(ProjectConstant.SESSION_ACTIVE);
//            List<PckUserSession> pckUserSessionListDB = pckUserSessionDao.getPckUserSession(pckUserSessionPre);
//            PckUserSession pckUserSessionDB = pckUserSessionListDB != null && pckUserSessionListDB.size() > 0 ? pckUserSessionListDB.get(0) : null;
//
//            PckProfile pckProfilePre = new PckProfile();
//            pckProfilePre.setUid(pckUserSessionDB.getUid());
//            pckProfilePre.setIsDelete(ProjectConstant.STATUS_N);
//            List<PckProfile> pckProfileListDB = pckProfileDao.getPckProfile(pckProfilePre);
//            PckProfile pckProfileDB = pckProfileListDB != null && pckProfileListDB.size() > 0 ? pckProfileListDB.get(0) : null;
//            systemLogger.info(LogFormatter.info(sid, "PckProfile Name : " + pckProfileDB.getFirstName().toString()));
//            if (pckProfileDB != null) {
//
//                if (createEvent != null) {
//                    if (createEvent.getEventName() != null) {
//                        masEvent.setEventName(createEvent.getEventName());
//                        List<MasEvent> masEventList = masEventDao.getMasEvent(masEvent);
//                        List<MasEventLocation> masEventLocationList = masEventLocationDao.getMasEventLocation(masEventLocation);
//
////                        if (masEventList.isEmpty()) {
////                            Date activeDate = DateUtil.parseForAD(createEvent.getActiveDate());
////                            if (currentDate.compareTo(activeDate) >= 0) {
////                                masEvent.setRedeemStatus(ProjectConstant.STATUS_AVAILABLE);
////                            } else {
////                                masReward.setRedeemStatus(ProjectConstant.STATUS_UPCOME);
////                            }
//                        int eventId = db2SequencerService.getSeqNum("SEQ_MAS_EVENT");
//                        masEvent.setEventId(Integer.valueOf(eventId));
//                        masEvent.setSportId(createEvent.getSportID());
////                            masEvent.setTeamId(createEvent.getTeamId());
//                        masEvent.setEventLocationId(createEvent.getEventLocationID());
//                        
//                        masEventLocation.setLatitude(Double.valueOf(createEvent.getLatitude()));
//                        masEventLocation.setLongitude(Double.valueOf(createEvent.getLongtitude()));
//                        masEventLocation.setLocationPictureUrl(createEvent.getUrlLocationPicture());
//                        
//                        TranEvent tranEvent = new TranEvent();
//                        List<TranEvent> tranEventList = tranEventDao.getTranEvent(tranEvent);
//                        
//                        tranEvent.setFromTime(createEvent.getFromTime());
//                        tranEvent.setToTime(createEvent.getToTime());
//                        
//                        
//                        MasSport masSport = new MasSport();
//                        List<MasSport> masSportsList = masSportDao.getMasSport(masSport);
//                       
//                        masSport.setSportName(createEvent.getSportName());
//                        
//
//                       
//                        masEvent.setIsDelete(ProjectConstant.STATUS_N);
//                        masEvent.setCreateDate(currentDate);
//                        masEvent.setCreateBy(pckProfileDB.getFirstName());
//                        
//                        masEventDao.insertMasEvent(masEvent);
//                        tranEventDao.insertTranEvent(tranEvent);
//                        masEventLocationDao.insertMasEventLocation(masEventLocation);
//                        
//                        systemLogger.info(LogFormatter.info(sid, "- createEvent success! "));
//
//                    } else {
//                        systemLogger.info(LogFormatter.info(sid, "- Service validation : this rewardName has already been used"));
//                        throw new ServiceValidation("WAIT ERROR CODE");
//                    }
//
//                } else {
//                    systemLogger.info(LogFormatter.info(sid, "- Service validation : input form is null"));
//                    throw new ServiceValidation("WAIT ERROR CODE");
//                }
//            }
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//        } catch (ServiceValidation e) {
//            e.printStackTrace();
//            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
//            throw e;
//
//        } catch (Exception e) {
//        }
//
//    }

    public EventLists getEventAll(String sid, String language) throws Exception {
        
        EventLists result = new EventLists();
//        private String eventName;
//    private Date fromTime;
//    private Date toTime;
//    private String eventLocationID;
//    private String latitude;
//    private String longtitude;
//    private String urlLocationPicture;
//    private String sportName;









    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
