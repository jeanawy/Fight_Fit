/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author ธนากร
 */
public class PckUserStar {

    private String uid;
    private String starType;
    private Integer starGiveBal;
    private Integer starReceiveBal;
    private Integer genGiveAmount;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Integer getStarGiveBal() {
        return starGiveBal;
    }

    public void setStarGiveBal(Integer starGiveBal) {
        this.starGiveBal = starGiveBal;
    }

    public Integer getStarReceiveBal() {
        return starReceiveBal;
    }

    public void setStarReceiveBal(Integer starReceiveBal) {
        this.starReceiveBal = starReceiveBal;
    }

    public Integer getGenGiveAmount() {
        return genGiveAmount;
    }

    public void setGenGiveAmount(Integer genGiveAmount) {
        this.genGiveAmount = genGiveAmount;
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
        return "PckUserStar{" + "uid=" + uid + ", starType=" + starType + ", starGiveBal=" + starGiveBal + ", starReceiveBal=" + starReceiveBal + ", genGiveAmount=" + genGiveAmount + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

}
