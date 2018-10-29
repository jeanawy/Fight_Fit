/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest;

/**
 *
 * @author Sent
 */
public class Booking {

    private String transactionID;
    private String dateBooking;
    private String timeBooking;
    private String topicMeeting;
    private String roomName;

    private String projecter;
    private String monitor;
    private String vdoConference;
    private String whiteboard;
    private String roomPictureURL;

    private String buildingName;
    private String ownerBooking;
    private String employeeName;
    private String department;
    private String division;

    private String mobileNo;
    private String lineID;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(String timeBooking) {
        this.timeBooking = timeBooking;
    }

    public String getTopicMeeting() {
        return topicMeeting;
    }

    public void setTopicMeeting(String topicMeeting) {
        this.topicMeeting = topicMeeting;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getProjecter() {
        return projecter;
    }

    public void setProjecter(String projecter) {
        this.projecter = projecter;
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

    public String getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(String whiteboard) {
        this.whiteboard = whiteboard;
    }

    public String getRoomPictureURL() {
        return roomPictureURL;
    }

    public void setRoomPictureURL(String roomPictureURL) {
        this.roomPictureURL = roomPictureURL;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getOwnerBooking() {
        return ownerBooking;
    }

    public void setOwnerBooking(String ownerBooking) {
        this.ownerBooking = ownerBooking;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    @Override
    public String toString() {
        return "{" + "transactionID=" + transactionID + ", dateBooking=" + dateBooking + ", timeBooking=" + timeBooking + ", topicMeeting=" + topicMeeting + ", roomName=" + roomName + ", projecter=" + projecter + ", monitor=" + monitor + ", vdoConference=" + vdoConference + ", whiteboard=" + whiteboard + ", roomPictureURL=" + roomPictureURL + ", buildingName=" + buildingName + ", ownerBooking=" + ownerBooking + ", employeeName=" + employeeName + ", department=" + department + ", division=" + division + ", mobileNo=" + mobileNo + ", lineID=" + lineID + '}';
    }

}
