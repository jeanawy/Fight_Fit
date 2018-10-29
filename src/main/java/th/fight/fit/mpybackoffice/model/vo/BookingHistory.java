/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.vo;

import java.util.Date;

/**
 *
 * @author Anuwat_K
 */
public class BookingHistory {

    private String buildingID;
    private String meetingRoomID;
    private String searchDateTimeFrom;
    private String searchDateTimeTo;

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getMeetingRoomID() {
        return meetingRoomID;
    }

    public void setMeetingRoomID(String meetingRoomID) {
        this.meetingRoomID = meetingRoomID;
    }

    public String getSearchDateTimeFrom() {
        return searchDateTimeFrom;
    }

    public void setSearchDateTimeFrom(String searchDateTimeFrom) {
        this.searchDateTimeFrom = searchDateTimeFrom;
    }

    public String getSearchDateTimeTo() {
        return searchDateTimeTo;
    }

    public void setSearchDateTimeTo(String searchDateTimeTo) {
        this.searchDateTimeTo = searchDateTimeTo;
    }

    @Override
    public String toString() {
        return "{" + "buildingID=" + buildingID + ", meetingRoomID=" + meetingRoomID + ", searchDateTimeFrom=" + searchDateTimeFrom + ", searchDateTimeTo=" + searchDateTimeTo + '}';
    }

}
