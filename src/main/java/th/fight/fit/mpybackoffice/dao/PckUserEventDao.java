/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.dao;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.fight.fit.mpybackoffice.domain.PckUserEvent;

/**
 *
 * @author Sent
 */
public interface PckUserEventDao {
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<PckUserEvent> getPckUserEvent(PckUserEvent pckUserEvent) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void insertPckUserEvent(PckUserEvent pckUserEvent) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void updatePckUserEvent(PckUserEvent pckUserEvent) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<PckUserEvent> getSearchPckUserEvent(PckUserEvent pckUserEvent, Integer index, Integer rowPerPage) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public int getCountSearchPckUserEvent(PckUserEvent pckUserEvent) throws Exception;
}
