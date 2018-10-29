/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest.UserAuthorize;

import java.util.List;

/**
 *
 * @author Panaporn
 */
public class SearchUserAuthorizeResponseRestModel {
    
    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<UserAuthorize> userAuthorize;

    public boolean isRemaindRecordFlag() {
        return remaindRecordFlag;
    }

    public void setRemaindRecordFlag(boolean remaindRecordFlag) {
        this.remaindRecordFlag = remaindRecordFlag;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<UserAuthorize> getUserAuthorize() {
        return userAuthorize;
    }

    public void setUserAuthorize(List<UserAuthorize> userAuthorize) {
        this.userAuthorize = userAuthorize;
    }

    @Override
    public String toString() {
        return "SearchUserAuthorizeResponseRestModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", userAuthorize=" + userAuthorize + '}';
    }

   
    
    
}
