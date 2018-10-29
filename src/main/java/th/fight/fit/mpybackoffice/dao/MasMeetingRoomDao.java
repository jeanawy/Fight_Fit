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

import th.fight.fit.mpybackoffice.domain.MasMeetingRoom;

/**
 *
 * @author 58050232
 */
public interface MasMeetingRoomDao {

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<MasMeetingRoom> getMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean insertMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public boolean updateMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception;

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.SERIALIZABLE)
    public int countMasMeetingRoom(MasMeetingRoom masMeetingRoom) throws Exception;
}
