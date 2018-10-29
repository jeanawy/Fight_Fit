/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.rest.UserAuthorize.GetEmployeeDetailsResponse;
import th.fight.fit.mpybackoffice.model.rest.UserAuthorize.SearchUserAuthorizeResponseRestModel;

/**
 *
 * @author Panaporn
 */
public interface GetUserAuthorizeService {

    @Transactional(propagation = Propagation.SUPPORTS)
    public SearchUserAuthorizeResponseRestModel getUserAuthorize(String sid, String language, String requestIndex, String requestRowPerPage, String group, String department, String division, String SearchName, boolean flageOption) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS)
    public GetEmployeeDetailsResponse getEmployeeDetails(String sid, String language, String uid) throws Exception;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public SearchUserAuthorizeResponseRestModel transactionAddUserAuthorize(String uid, String groupId) throws Exception;
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public SearchUserAuthorizeResponseRestModel transactionDeleteUserAuthorize(String uid, String groupId) throws Exception;
}
