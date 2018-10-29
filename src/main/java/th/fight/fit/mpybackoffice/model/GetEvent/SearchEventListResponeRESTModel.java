/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.GetEvent;

import java.util.List;

/**
 *
 * @author Sent
 */
public class SearchEventListResponeRESTModel {

    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<EventLists> eventLists;

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

    public List<EventLists> getEventLists() {
        return eventLists;
    }

    public void setEventLists(List<EventLists> eventLists) {
        this.eventLists = eventLists;
    }

    @Override
    public String toString() {
        return "SearchEventListResponeRESTModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", eventLists=" + eventLists + '}';
    }

    
}
