/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.CreateEvent.CreateEvent;
import th.fight.fit.mpybackoffice.model.GetEvent.EventLists;
import th.fight.fit.mpybackoffice.model.GetProfile;
import th.fight.fit.mpybackoffice.model.StarRewardManagement.CreateReward;
import th.fight.fit.mpybackoffice.model.StarRewardManagement.SearchRedeemRewardResponseRESTModel;

/**
 *
 * @author Sent
 */
public interface EventService {



    @Transactional(propagation = Propagation.SUPPORTS)
    public EventLists getEventAll(String sid, String language) throws Exception;
    

//    @Transactional(propagation = Propagation.SUPPORTS)
//    public SearchEventJoinResponseRESTModel getEventJoin(String sid, String language, String requestIndex, String requestRowPerPage, String searchUser, String searchRewardName, String requestDay, String searchByStatus) throws Exception;
}
