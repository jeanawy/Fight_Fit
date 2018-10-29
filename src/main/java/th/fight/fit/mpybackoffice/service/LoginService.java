package th.fight.fit.mpybackoffice.service;

import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.fight.fit.mpybackoffice.domain.UserDetail;

public interface LoginService {

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserDetail login() throws AuthenticationException;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void logout() throws Exception;
	
}
