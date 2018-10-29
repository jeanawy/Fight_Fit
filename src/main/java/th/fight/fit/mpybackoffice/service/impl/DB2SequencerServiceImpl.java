/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.fight.fit.mpybackoffice.dao.DB2SequencerDao;
import th.fight.fit.mpybackoffice.service.DB2SequencerService;

/**
 *
 * @author Nuttapon
 */
@Service
public class DB2SequencerServiceImpl implements DB2SequencerService {

    @Autowired
    private DB2SequencerDao db2SequencerDao;

    public int getSeqNum(String sequenceName) throws Exception {
        return db2SequencerDao.getSeqNum(sequenceName);
    }

    public long getSeqNumTransaction(String sequenceName) throws Exception {
        return db2SequencerDao.getSeqNumTransaction(sequenceName);
    }
}
