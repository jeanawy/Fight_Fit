/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service;

import java.math.BigInteger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement.TransactionBookingEvent;
import th.fight.fit.mpybackoffice.model.TransactionBookingEventManagement.VerifyTransactionBookingEvent;

/**
 *
 * @author Sent
 */
public interface TransactionBookingEventService {
    @Transactional(propagation = Propagation.SUPPORTS)
    public VerifyTransactionBookingEvent verifyTransactionBookingEvent(String sid, String language, String eventId, String timeBookingFrom, String timeBookingTo, String uidOfJoin) throws Exception;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public TransactionBookingEvent transactionBookingEvent(String sid, String language, VerifyTransactionBookingEvent result) throws Exception;

}
