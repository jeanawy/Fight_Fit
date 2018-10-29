/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;


public class PckUserSession {

    private String sid;
    private String jack;
    private String uid;
    private String sidStatus;
    private Date sessionTime;

    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getJack() {
        return jack;
    }

    public void setJack(String jack) {
        this.jack = jack;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSidStatus() {
        return sidStatus;
    }

    public void setSidStatus(String sidStatus) {
        this.sidStatus = sidStatus;
    }

    public Date getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Date sessionTime) {
        this.sessionTime = sessionTime;
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
        return "{" + "sid=" + sid + ", jack=" + jack + ", uid=" + uid + ", sidStatus=" + sidStatus + ", sessionTime=" + sessionTime + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

}
