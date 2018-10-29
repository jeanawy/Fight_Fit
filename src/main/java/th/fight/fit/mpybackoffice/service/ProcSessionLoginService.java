package th.fight.fit.mpybackoffice.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.ProcSessionLogin;
import th.fight.fit.mpybackoffice.domain.UserDetail;

public interface ProcSessionLoginService {

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void extendSessionTimeout(BigInteger sid, UserDetail userDetail) throws Exception;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteProcSessionLogin(final BigInteger sessionLoginId) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public ProcSessionLogin getProcSessionLogin(BigInteger sid) throws Exception;
	
}
