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
 * @author 58050232
 */
public class TranUser {

    private BigInteger tranId;
    private String tranCode;
    private String uid;
    private Integer eventId;
    private BigInteger tranRef;
    private Integer rankingId;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public BigInteger getTranId() {
        return tranId;
    }

    public void setTranId(BigInteger tranId) {
        this.tranId = tranId;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public BigInteger getTranRef() {
        return tranRef;
    }

    public void setTranRef(BigInteger tranRef) {
        this.tranRef = tranRef;
    }

    public Integer getRankingId() {
        return rankingId;
    }

    public void setRankingId(Integer rankingId) {
        this.rankingId = rankingId;
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
        return "TranUser{" + "tranId=" + tranId + ", tranCode=" + tranCode + ", uid=" + uid + ", eventId=" + eventId + ", tranRef=" + tranRef + ", rankingId=" + rankingId + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

    

}
