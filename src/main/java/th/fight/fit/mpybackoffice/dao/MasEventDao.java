

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
import th.fight.fit.mpybackoffice.domain.MasEvent;

/**
 *
 * @author Sent
 */
public interface MasEventDao {
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<MasEvent> getMasEvent(MasEvent masEvent) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean insertMasEvent(MasEvent masEvent) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean updateMasEvent(MasEvent masEvent) throws Exception;
    
     @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<MasEvent> getSearchMasEvent(MasEvent masEvent, Integer index, Integer rowPerPage) throws Exception;

    
}
