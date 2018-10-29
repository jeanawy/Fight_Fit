/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author 58050232
 */
public class MasTranCode {

    private String tranCode;
    private String tranGroup;
    private String tranCodeTh;
    private String tranCodeEn;
    private String statusUseIn;
    private String statusId;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getTranGroup() {
        return tranGroup;
    }

    public void setTranGroup(String tranGroup) {
        this.tranGroup = tranGroup;
    }

    public String getTranCodeTh() {
        return tranCodeTh;
    }

    public void setTranCodeTh(String tranCodeTh) {
        this.tranCodeTh = tranCodeTh;
    }

    public String getTranCodeEn() {
        return tranCodeEn;
    }

    public void setTranCodeEn(String tranCodeEn) {
        this.tranCodeEn = tranCodeEn;
    }

    public String getStatusUseIn() {
        return statusUseIn;
    }

    public void setStatusUseIn(String statusUseIn) {
        this.statusUseIn = statusUseIn;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "MasTranCode{" + "tranCode=" + tranCode + ", tranGroup=" + tranGroup + ", tranCodeTh=" + tranCodeTh + ", tranCodeEn=" + tranCodeEn + ", statusUseIn=" + statusUseIn + ", statusId=" + statusId + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

}
