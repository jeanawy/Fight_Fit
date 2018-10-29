package th.fight.fit.mpybackoffice.dao;

import java.math.BigInteger;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcLoginFail;

public interface ProcLoginFailDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void insertProcSessionLoginFail(ProcLoginFail loginFail) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void deleteProcSessionLogin(BigInteger sessionLoginId) throws Exception;
	
}
