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

import th.fight.fit.mpybackoffice.domain.MasTranCode;

/**
 *
 * @author Chayoth
 */
public interface MasTranCodeDao {

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<MasTranCode> getMasTranCode(MasTranCode masTranCode) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void insertMasTranCode(MasTranCode masTranCode) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public void updateMasTranCode(MasTranCode masTranCode) throws Exception;

}