package th.fight.fit.mpybackoffice.dao;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcUserLogin;

public interface ProcUserLoginDao {
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public ProcUserLogin getProcUserLogin(String username) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateProcUserLogin(ProcUserLogin userLogin) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public long insertProcUserLogin(ProcUserLogin procUserLogin) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<ProcUserLogin> findProcUserLoginResponsible() throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public ProcUserLogin getProcUserLoginByUserId(String userId)throws Exception ;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public boolean updateProcUserLoginByUserId(ProcUserLogin  vo) throws Exception ;
	
}
