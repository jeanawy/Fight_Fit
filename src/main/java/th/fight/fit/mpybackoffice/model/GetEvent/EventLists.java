/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.GetEvent;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class EventLists {

    private String eventName;
    private Date fromTime;
    private Date toTime;
    private String eventLocationID;
    private String latitude;
    private String longtitude;
    private String urlLocationPicture;
    private String sportName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getUrlLocationPicture() {
        return urlLocationPicture;
    }

    public void setUrlLocationPicture(String urlLocationPicture) {
        this.urlLocationPicture = urlLocationPicture;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getEventLocationID() {
        return eventLocationID;
    }

    public void setEventLocationID(String eventLocationID) {
        this.eventLocationID = eventLocationID;
    }

    @Override
    public String toString() {
        return "EventLists{" + "eventName=" + eventName + ", fromTime=" + fromTime + ", toTime=" + toTime + ", latitude=" + latitude + ", longtitude=" + longtitude + ", urlLocationPicture=" + urlLocationPicture + ", sportName=" + sportName + ", eventLocationID=" + eventLocationID + '}';
    }

}
