/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest;

import java.util.List;

/**
 *
 * @author Jeep_
 */
public class SearchContactRepairHistoryResponseRESTModel {
    
    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<ContactRepair> contactRepair;

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

    public List<ContactRepair> getContactRepair() {
        return contactRepair;
    }

    public void setContactRepair(List<ContactRepair> contactRepair) {
        this.contactRepair = contactRepair;
    }

    @Override
    public String toString() {
        return "SearchContactRepairHistoryResponseRESTModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", contactRepair=" + contactRepair + '}';
    }
    
        
}
