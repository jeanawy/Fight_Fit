package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.SecurityService;
import th.fight.fit.mpybackoffice.util.SecurityUtil;
import th.fight.fit.mpybackoffice.util.StringUtils;

@Service
public class SecurityServiceImpl implements SecurityService {
	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	@Autowired private MessageSource messageSource;
	@Autowired private ResourceLoader resourceLoader;
	
	// Added by Ratapong W. 20151209.
	public String encryptP12(String plainText) throws Exception{
		String p12ActiveFlag = messageSource.getMessage(ProjectConstant.KEY_SECURITY_ENCRYPT_P12_ACTIVE, null, null);
		String p12EnceryptStr = null;

		try {
			if(ProjectConstant.STATUS_Y.equals(p12ActiveFlag)){
				String p12SecurityPath = messageSource.getMessage(ProjectConstant.KEY_SECURITY_KEY_P12_PATH, null, null);

				if(StringUtils.isNotEmptyOrNull(p12SecurityPath)){
					// For sever
					p12EnceryptStr = SecurityUtil.encryptStringBase64(plainText, p12SecurityPath);

				}else{
					// For localhost Test
					p12EnceryptStr = SecurityUtil.encryptStringBase64(plainText, resourceLoader.getResource("classpath:corporate.p12").getURL().getFile());

				}

			}else{
				p12EnceryptStr = plainText;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;

		}

		//systemLogger.info(LogFormatter.info(null, null, "encrypted p12 : " + p12EnceryptStr));
		
		return p12EnceryptStr;

	}

	public String decryptP12(String encryptedText) throws Exception{
		String p12ActiveFlag = messageSource.getMessage(ProjectConstant.KEY_SECURITY_ENCRYPT_P12_ACTIVE, null, null);
		String plainText = null;

		try {
			if(ProjectConstant.STATUS_Y.equals(p12ActiveFlag)){
				String p12SecurityPath = messageSource.getMessage(ProjectConstant.KEY_SECURITY_KEY_P12_PATH, null, null);

				if(StringUtils.isNotEmptyOrNull(p12SecurityPath)){
					// For sever
					plainText = SecurityUtil.decryptStringBase64(encryptedText, p12SecurityPath);

				}else{
					// For localhost Test
					plainText = SecurityUtil.decryptStringBase64(encryptedText, resourceLoader.getResource("classpath:corporate.p12").getURL().getFile());

				}

			}else{
				plainText = encryptedText;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;

		}

		systemLogger.info(LogFormatter.info(null, null, "decryptP12 p12 : " + plainText));

		return plainText;
		
	}

	public String getWebToken(BigInteger custId, String functionName) throws Exception {
		Date currentDate = new Date();
		String webTokenPlaneTxt = functionName + "|" + custId.toString() + "|" + currentDate.getTime();
		String tokenEncryptFlag = messageSource.getMessage(ProjectConstant.KEY_TOKEN_ENCRYPT, null, null);
		
		String hashWebToken = null;
		
		if(ProjectConstant.STATUS_Y.equals(tokenEncryptFlag))
			hashWebToken = encryptP12(webTokenPlaneTxt);
		else
			hashWebToken = webTokenPlaneTxt;
		
		systemLogger.info(LogFormatter.info(null, null, "webToken : " + hashWebToken));
		
		return hashWebToken;
	}
	
}
