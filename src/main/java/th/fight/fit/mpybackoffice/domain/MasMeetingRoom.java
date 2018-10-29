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
public class MasMeetingRoom {

    private Integer roomId;
    private String roomTh;
    private String roomEn;
    private Integer buildingId;
    private String projecter;
    private String monitor;
    private String vdoConference;
    private String whiteBoard;
    private Integer noOfAttendees;
    private String roomPictureUrl;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomTh() {
        return roomTh;
    }

    public void setRoomTh(String roomTh) {
        this.roomTh = roomTh;
    }

    public String getRoomEn() {
        return roomEn;
    }

    public void setRoomEn(String roomEn) {
        this.roomEn = roomEn;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildId) {
        this.buildingId = buildId;
    }

    public String getProjecter() {
        return projecter;
    }

    public void setProjecter(String projectter) {
        this.projecter = projectter;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getVdoConference() {
        return vdoConference;
    }

    public void setVdoConference(String vdoConference) {
        this.vdoConference = vdoConference;
    }

    public String getWhiteBoard() {
        return whiteBoard;
    }

    public void setWhiteBoard(String whiteBoard) {
        this.whiteBoard = whiteBoard;
    }

    public Integer getNoOfAttendees() {
        return noOfAttendees;
    }

    public void setNoOfAttendees(Integer noOfAttendees) {
        this.noOfAttendees = noOfAttendees;
    }

    public String getRoomPictureUrl() {
        return roomPictureUrl;
    }

    public void setRoomPictureUrl(String roomPictureUrl) {
        this.roomPictureUrl = roomPictureUrl;
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
        return "{" + "roomId=" + roomId + ", roomTh=" + roomTh + ", roomEn=" + roomEn + ", buildingId=" + buildingId + ", projecter=" + projecter + ", monitor=" + monitor + ", vdoConference=" + vdoConference + ", whiteBoard=" + whiteBoard + ", noOfAttendees=" + noOfAttendees + ", roomPictureUrl=" + roomPictureUrl + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }

}
