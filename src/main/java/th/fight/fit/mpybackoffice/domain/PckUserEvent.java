/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Sent
 */
public class PckUserEvent {
        private String uid;
    private String eventId;
    private BigInteger tranIdGen;
    private BigInteger tranIdCancel;
    private Date fromTime;
    private Date toTime;
    private String uidJoin;
    private String EventStatus;
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public BigInteger getTranIdGen() {
        return tranIdGen;
    }

    public void setTranIdGen(BigInteger tranIdGen) {
        this.tranIdGen = tranIdGen;
    }

    public BigInteger getTranIdCancel() {
        return tranIdCancel;
    }

    public void setTranIdCancel(BigInteger tranIdCancel) {
        this.tranIdCancel = tranIdCancel;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public String getUidJoin() {
        return uidJoin;
    }

    public void setUidJoin(String uidJoin) {
        this.uidJoin = uidJoin;
    }

    public String getEventStatus() {
        return EventStatus;
    }

    public void setEventStatus(String EventStatus) {
        this.EventStatus = EventStatus;
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
        return "pckUserEvent{" + "uid=" + uid + ", eventId=" + eventId + ", tranIdGen=" + tranIdGen + ", tranIdCancel=" + tranIdCancel + ", fromTime=" + fromTime + ", toTime=" + toTime + ", uidJoin=" + uidJoin + ", EventStatus=" + EventStatus + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }
    
}
