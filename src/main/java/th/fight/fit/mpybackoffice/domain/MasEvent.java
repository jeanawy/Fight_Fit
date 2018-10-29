/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class MasEvent {

    private Integer eventId;
    private String eventLocationId;
    private String sportId;
    private String teamId;
    private Date fromTime;
    private Date toTime;
    private String eventName;
    private String teamSize;
    private String noOfJoin;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    

    public String getEventLocationId() {
        return eventLocationId;
    }

    public void setEventLocationId(String eventLocationId) {
        this.eventLocationId = eventLocationId;
    }

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getNoOfJoin() {
        return noOfJoin;
    }

    public void setNoOfJoin(String noOfJoin) {
        this.noOfJoin = noOfJoin;
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
        return "MasEvent{" + "eventId=" + eventId + ", eventLocationId=" + eventLocationId + ", sportId=" + sportId + ", teamId=" + teamId + ", fromTime=" + fromTime + ", toTime=" + toTime + ", eventName=" + eventName + ", teamSize=" + teamSize + ", noOfJoin=" + noOfJoin + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

    

   
}
