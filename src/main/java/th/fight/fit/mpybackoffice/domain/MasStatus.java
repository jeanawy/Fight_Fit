/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author Sukrit_p
 */
public class MasStatus {

    private String statusUseIn;
    private String statusId;
    private String statusTh;
    private String statusEn;
    private String canUse;
    private String color;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

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

    public String getStatusTh() {
        return statusTh;
    }

    public void setStatusTh(String statusTh) {
        this.statusTh = statusTh;
    }

    public String getStatusEn() {
        return statusEn;
    }

    public void setStatusEn(String statusEn) {
        this.statusEn = statusEn;
    }

    public String getCanUse() {
        return canUse;
    }

    public void setCanUse(String canUse) {
        this.canUse = canUse;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" + "statusUseIn=" + statusUseIn + ", statusId=" + statusId + ", statusTh=" + statusTh + ", statusEn=" + statusEn + ", canUse=" + canUse + ", color=" + color + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

}
