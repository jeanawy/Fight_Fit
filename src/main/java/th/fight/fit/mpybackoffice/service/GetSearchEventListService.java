/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.GetEvent.SearchEventListResponeRESTModel;

/**
 *
 * @author Sent
 */
public interface GetSearchEventListService {
    
      @Transactional(propagation = Propagation.SUPPORTS)
    public SearchEventListResponeRESTModel getSearchEventListbyName(String sid, String language, String requestIndex, String requestRowPerPage, String eventName,String eventId,String eventLocationID,String searchDateTimeFrom, String searchDateTimeTo) throws Exception;
////
//   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
//    public SearchEventListResponeRESTModel transactionDeleteEvent(String sid, String language, String eventId) throws Exception;

//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
//    public SearchEventListResponeRESTModel transactionUpdateEvent(String sid, String language, String rewardId);
}
