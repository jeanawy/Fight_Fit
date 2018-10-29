package th.fight.fit.mpybackoffice.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcUserProfile;

public interface ProcUserProfileDao {

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public void updateProcUserProfile(final ProcUserProfile userProfile) throws Exception;

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.SERIALIZABLE)
	public long insertProcUserProfile(ProcUserProfile procUserProfile) throws Exception;

	@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
	public List<ProcUserProfile> getProcUserProfile(ProcUserProfile procUserProfile) throws Exception;

}
