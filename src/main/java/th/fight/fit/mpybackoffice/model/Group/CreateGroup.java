/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.Group;

import java.util.List;

/**
 *
 * @author Worakan
 */
public class CreateGroup {
    
private String bosGroupId ;
private String bosMenuId;
private String mobileMenuId;
    
private String groupNameTh;
private String groupNameEn;

    public String getBosGroupId() {
        return bosGroupId;
    }

    public void setBosGroupId(String bosGroupId) {
        this.bosGroupId = bosGroupId;
    }

    public String getBosMenuId() {
        return bosMenuId;
    }

    public void setBosMenuId(String bosMenuId) {
        this.bosMenuId = bosMenuId;
    }

    public String getMobileMenuId() {
        return mobileMenuId;
    }

    public void setMobileMenuId(String mobileMenuId) {
        this.mobileMenuId = mobileMenuId;
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

    @Override
    public String toString() {
        return "CreateGroup{" + "bosGroupId=" + bosGroupId + ", bosMenuId=" + bosMenuId + ", mobileMenuId=" + mobileMenuId + ", groupNameTh=" + groupNameTh + ", groupNameEn=" + groupNameEn + '}';
    }

    
    
}
