/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import java.math.BigInteger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.GetProfile;

/**
 *
 * @author Sent
 */
public interface ProfileManagementService {
     @Transactional(propagation = Propagation.SUPPORTS)
    public GetProfile getProfile(String sid, String language,String groupId) throws Exception;
    
   
}
