package th.fight.fit.mpybackoffice.service;

import java.math.BigInteger;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface SecurityService {

	@Transactional(propagation=Propagation.SUPPORTS)
	public String encryptP12(String plainText) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public String decryptP12(String encryptedText) throws Exception;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public String getWebToken(BigInteger userId, String functionName) throws Exception;
	
}
