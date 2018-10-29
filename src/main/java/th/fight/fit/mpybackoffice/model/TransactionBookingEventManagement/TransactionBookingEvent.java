/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement;

/**
 *
 * @author Sent
 */
public class TransactionBookingEvent {
    private String transactionId;
    private String transactionDateTime;
    private String eventName;
    private String timeBookingFrom;
    private String timeBookingTo;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTimeBookingFrom() {
        return timeBookingFrom;
    }

    public void setTimeBookingFrom(String timeBookingFrom) {
        this.timeBookingFrom = timeBookingFrom;
    }

    public String getTimeBookingTo() {
        return timeBookingTo;
    }

    public void setTimeBookingTo(String timeBookingTo) {
        this.timeBookingTo = timeBookingTo;
    }

    @Override
    public String toString() {
        return "TransactionBookingEvent{" + "transactionId=" + transactionId + ", transactionDateTime=" + transactionDateTime + ", eventName=" + eventName + ", timeBookingFrom=" + timeBookingFrom + ", timeBookingTo=" + timeBookingTo + '}';
    }
    
    
    
    
}
