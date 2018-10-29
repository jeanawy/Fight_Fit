/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.CreateEvent;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class CreateEvent {

    private String eventName;
    private String conditionTh;
    private Date fromTime;
    private Date toTime;
    private String latitude;
    private String longtitude;
    private String urlLocationPicture;
    private String searchName;
    private String sportID;
    private String sportName;
    private String teamId;
    private String eventLocationID;
    private String profileID;

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getConditionTh() {
        return conditionTh;
    }

    public void setConditionTh(String conditionTh) {
        this.conditionTh = conditionTh;
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

   
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

   


  
    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSportID() {
        return sportID;
    }

    public void setSportID(String sportID) {
        this.sportID = sportID;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getEventLocationID() {
        return eventLocationID;
    }

    public void setEventLocationID(String eventLocationID) {
        this.eventLocationID = eventLocationID;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getUrlLocationPicture() {
        return urlLocationPicture;
    }

    public void setUrlLocationPicture(String urlLocationPicture) {
        this.urlLocationPicture = urlLocationPicture;
    }

    @Override
    public String toString() {
        return "{" + "eventName=" + eventName + ", conditionTh=" + conditionTh + ", fromTime=" + fromTime + ", toTime=" + toTime + ", latitude=" + latitude + ", longtitude=" + longtitude + ", urlLocationPicture=" + urlLocationPicture + ", searchName=" + searchName + ", sportID=" + sportID + ", sportName=" + sportName + ", teamId=" + teamId + ", eventLocationID=" + eventLocationID + ", profileID=" + profileID + '}';
    }

   

   
  

   

   

}
