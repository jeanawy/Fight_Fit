package th.fight.fit.mpybackoffice.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcUserAuthen;

public interface ProcUserAuthDao {
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public long insertProcUserAuth(ProcUserAuthen procUserAuthen) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateProcUserAuth(ProcUserAuthen procUserAuthen) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<ProcUserAuthen> findProcUserAuthen(ProcUserAuthen vo) throws Exception;
	
}
