/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.Group;

import java.util.List;
import java.util.Map;
import th.fight.fit.mpybackoffice.domain.vo.CheckBoxVO;

/**
 *
 * @author Worakan
 */
public class GetGroupDetails {
     private Map<String, List<CheckBoxVO>> authority;
      private String groupNameTh;
      private String groupNameEn;
      private String groupIDs;

    public Map<String, List<CheckBoxVO>> getAuthority() {
        return authority;
    }

    public void setAuthority(Map<String, List<CheckBoxVO>> authority) {
        this.authority = authority;
    }

    public String getGroupNameTh() {
        return groupNameTh;
    }

    public void setGroupNameTh(String groupNameTh) {
        this.groupNameTh = groupNameTh;
    }

    public String getGroupNameEn() {
        return groupNameEn;
    }

    public void setGroupNameEn(String groupNameEn) {
        this.groupNameEn = groupNameEn;
    }

    public String getGroupIDs() {
        return groupIDs;
    }

    public void setGroupIDs(String groupIDs) {
        this.groupIDs = groupIDs;
    }

    @Override
    public String toString() {
        return "GetGroupDetails{" + "authority=" + authority + ", groupNameTh=" + groupNameTh + ", groupNameEn=" + groupNameEn + ", groupIDs=" + groupIDs + '}';
    }

    
      
}
