package th.fight.fit.mpybackoffice.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcSessionLogin;

public interface ProcSessionLoginDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public long insertProcSessionLogin(ProcSessionLogin sessionLogin) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public ProcSessionLogin getProcSessionLogin(String username) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateProcSessionLogin(ProcSessionLogin sessionLogin) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void deleteProcSessionLogin(final BigInteger sessionLoginId) throws Exception;

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public boolean deleteByUserID(final String userName) throws Exception;
 	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<ProcSessionLogin> findProcSessionLogin(ProcSessionLogin vo) throws Exception;
	
}
