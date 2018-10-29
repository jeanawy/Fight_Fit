/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.StarRewardManagement.SearchByUserGiveStarResponseRESTModel;
import th.fight.fit.mpybackoffice.model.StarRewardManagement.SearchGroupUserStarGiveResponseRESTModel;

/**
 *
 * @author ธนากร
 */
public interface StarService {
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public SearchGroupUserStarGiveResponseRESTModel getGroupUserStarGive(String sid, String language, String groupUserID) throws Exception;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public SearchByUserGiveStarResponseRESTModel getByUserGiveStar(String sid, String language,String requestIndex, String requestRowPerPage, String groupUserID, String department, String division, String searchName) throws Exception;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public SearchGroupUserStarGiveResponseRESTModel updateGroupUserStarGive(String sid, String language, String groupUserID, String giveGoldStar, String giveSilverStar, String giveBronzeStar) throws Exception;
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public SearchGroupUserStarGiveResponseRESTModel updateByUserStarGive(String sid, String language, String uid, String giveGoldStar, String giveSilverStar, String giveBronzeStar) throws Exception;

}
