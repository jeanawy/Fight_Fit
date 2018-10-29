package th.fight.fit.mpybackoffice.dao;

import java.lang.Exception;
import java.math.BigInteger;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcUserLogin;
import th.fight.fit.mpybackoffice.domain.ProcUserProfile;
import th.fight.fit.mpybackoffice.domain.UserDetail;

public interface UserDetailDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public UserDetail getUserDetail(BigInteger userId) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public ProcUserLogin getUserLogin(String userName) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateUserLogin(ProcUserLogin userLogin) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateUserProfile(ProcUserProfile userProfile) throws Exception;
	
}
