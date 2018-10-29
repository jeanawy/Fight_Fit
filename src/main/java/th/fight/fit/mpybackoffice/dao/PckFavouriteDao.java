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

import th.fight.fit.mpybackoffice.domain.PckFavourite;


/**
 *
 * @author Jeep_
 */
public interface PckFavouriteDao {
    
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED )
    public List<PckFavourite> getPckFavourite(PckFavourite pckFavourite ) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean insertPckFavourite(PckFavourite pckFavourite) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean updatePckFavourite(PckFavourite pckFavourite) throws Exception;

    
}
