/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.MasEventDao;
import th.fight.fit.mpybackoffice.domain.MasEvent;
import th.fight.fit.mpybackoffice.model.rest.SendDateFitbit;
import th.fight.fit.mpybackoffice.service.SendDataFitbitService;
import th.fight.fit.mpybackoffice.util.DateUtil;

/**
 *
 * @author Sent
 */
@Service
public class SendDataFitbitServiceImpl implements SendDataFitbitService {

    @Autowired
    private MasEventDao masEventDao;

    public SendDateFitbit sendDatefitbit(BigInteger sid) throws Exception {
        SendDateFitbit result = new SendDateFitbit();
        
        String mytime =  null ;
        String startTime = null ;
        String endTime = null ;
        
        
        try {
            MasEvent masEvent = new MasEvent();
            masEvent.setIsDelete(ProjectConstant.STATUS_N);
            List<MasEvent> masEventListDB = masEventDao.getMasEvent(masEvent);
            for (MasEvent eventDB : masEventListDB) {
            
//            mytime = DateUtil.DATE_PATTERNFORDB2(eventDB.getFromTime());
                
            result.setMytime(DateUtil.formatDateForDB2(eventDB.getFromTime()));
            result.setStartTime(DateUtil.formatTime(eventDB.getFromTime()));
            result.setEndTime(DateUtil.formatTime(eventDB.getToTime()));
            
            }

        } catch (Exception e) {
            throw e;
        }

        return result;
    }

}
