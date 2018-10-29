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
import th.fight.fit.mpybackoffice.dao.PckProfileDao;
import th.fight.fit.mpybackoffice.domain.PckProfile;
import th.fight.fit.mpybackoffice.model.GetProfile;
import th.fight.fit.mpybackoffice.service.ProfileManagementService;

/**
 *
 * @author Sent
 */
@Service
public class ProfileManagementServiceImpl implements ProfileManagementService {

    @Autowired
    private PckProfileDao pckProfileDao;

    public GetProfile getProfile(String sid, String language,String groupId) throws Exception {
        GetProfile result = new GetProfile();
        PckProfile pckProfile = new PckProfile();
        try {
            List<PckProfile> pckProfileListDB = pckProfileDao.getPckProfile(pckProfile);
            PckProfile PckProfileDB = pckProfileListDB != null && pckProfileListDB.size() > 0 ? pckProfileListDB.get(0) : null;
           
            result.setProfileId(PckProfileDB.getProfileId());
            result.setUid(PckProfileDB.getUid());
            result.setFirstName(PckProfileDB.getFirstName());
            result.setLastName(PckProfileDB.getLastName());
            result.setNickName(PckProfileDB.getNickName());
            result.setMobilePhoneNo(PckProfileDB.getMobilePhone());
            result.setPictureURL(PckProfileDB.getPictureUrl());
            result.setPosition(PckProfileDB.getPositionNo());

            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
    
    
    
    

}
