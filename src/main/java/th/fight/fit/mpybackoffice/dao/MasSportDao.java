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
import th.fight.fit.mpybackoffice.domain.MasSport;

/**
 *
 * @author Sent
 */
public interface MasSportDao {
     @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<MasSport> getMasSport(MasSport masSport) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean insertMasSport(MasSport masSport) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean updateMasSport(MasSport masSport) throws Exception;
    
}
