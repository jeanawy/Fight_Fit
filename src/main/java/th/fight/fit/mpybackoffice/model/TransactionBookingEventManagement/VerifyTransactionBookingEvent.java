/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class VerifyTransactionBookingEvent {
    private String uid;
    private String eventId;
    private String eventName;
    private Date timeBookingFrom;
    private Date timeBookingTo;
    private String uidOfJoin;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getTimeBookingFrom() {
        return timeBookingFrom;
    }

    public void setTimeBookingFrom(Date timeBookingFrom) {
        this.timeBookingFrom = timeBookingFrom;
    }

    public Date getTimeBookingTo() {
        return timeBookingTo;
    }

    public void setTimeBookingTo(Date timeBookingTo) {
        this.timeBookingTo = timeBookingTo;
    }

    public String getUidOfJoin() {
        return uidOfJoin;
    }

    public void setUidOfJoin(String uidOfJoin) {
        this.uidOfJoin = uidOfJoin;
    }

    @Override
    public String toString() {
        return "VerifyTransactionBookingEvent{" + "uid=" + uid + ", eventId=" + eventId + ", eventName=" + eventName + ", timeBookingFrom=" + timeBookingFrom + ", timeBookingTo=" + timeBookingTo + ", uidOfJoin=" + uidOfJoin + '}';
    }


}
