package th.fight.fit.mpybackoffice.security;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.UserDetail;
import th.fight.fit.mpybackoffice.exception.ProcessAuthenticationException;
import th.fight.fit.mpybackoffice.exception.SessionControlException;
import th.fight.fit.mpybackoffice.exception.UserNotAvailableException;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.LoginService;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
	private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	@Autowired
	private LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Date startDate = new Date();
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		WebAuthenticationDetails webAuthen = (WebAuthenticationDetails)authentication.getDetails();
		String ipAddress = webAuthen.getRemoteAddress();
		
		String errorMsg = null;
		UserDetail userDetail = null;
		UsernamePasswordAuthenticationToken token = null;
		
		try {
			userDetail = loginService.login();
			token = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
			
		}
		catch (Exception e) {
			try {
				throw new Exception(String.format("|"+ ProjectConstant.EXCEPTION_LOGIN_PROCESS+"|" + authentication.getPrincipal().toString(), authentication.getPrincipal()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		accessLogger.info(LogFormatter.accessLog(startDate, new Date(), null, username, ProjectConstant.STATUS_SUCCESS, null, null));
		
		return token;
	}

	public boolean supports(Class<? extends Object> aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

}
