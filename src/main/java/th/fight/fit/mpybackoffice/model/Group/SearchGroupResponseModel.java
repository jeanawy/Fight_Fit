/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.Group;

import java.util.List;

/**
 *
 * @author Panaporn
 */
public class SearchGroupResponseModel {

    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<GroupId> group;

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

    public List<GroupId> getGroup() {
        return group;
    }

    public void setGroup(List<GroupId> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "SearchGroupResponseModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", group=" + group + '}';
    }

}
