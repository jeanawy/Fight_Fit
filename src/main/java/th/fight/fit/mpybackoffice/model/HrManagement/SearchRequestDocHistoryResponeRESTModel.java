/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.HrManagement;
import java.util.List;

/**
 *
 * @author Sukrit_p
 */
public class SearchRequestDocHistoryResponeRESTModel {

    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<HistRequestDoc> histRequestDoc;

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

    public List<HistRequestDoc> getHistRequestDoc() {
        return histRequestDoc;
    }

    public void setHistRequestDoc(List<HistRequestDoc> histRequestDoc) {
        this.histRequestDoc = histRequestDoc;
    }

    @Override
    public String toString() {
        return "SearchRequestDocHistoryResponeRESTModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", histRequestDoc=" + histRequestDoc + '}';
    }

}
