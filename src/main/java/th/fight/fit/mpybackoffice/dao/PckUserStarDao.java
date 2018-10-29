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
import th.fight.fit.mpybackoffice.domain.PckUserStar;

/**
 *
 * @author ธนากร
 */
public interface PckUserStarDao {

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<PckUserStar> getPckUserStar(PckUserStar pckUserStar) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void updatePckUserStar(PckUserStar pckUserStar) throws Exception;
}
