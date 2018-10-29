/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.StarRewardManagement;

import java.util.List;

/**
 *
 * @author 58050232
 */
public class SearchRedeemRewardResponseRESTModel {

    private boolean remaindRecordFlag;
    private String recordsTotal;
    private String recordsFiltered;
    private List<RedeemReward> redeemReward;

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

    public List<RedeemReward> getRedeemReward() {
        return redeemReward;
    }

    public void setRedeemReward(List<RedeemReward> redeemReward) {
        this.redeemReward = redeemReward;
    }

    @Override
    public String toString() {
        return "SearchRedeemRewardResponseRESTModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered + ", redeemReward=" + redeemReward + '}';
    }

}
