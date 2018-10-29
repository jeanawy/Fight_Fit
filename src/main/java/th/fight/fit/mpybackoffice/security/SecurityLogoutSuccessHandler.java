package th.fight.fit.mpybackoffice.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	private static final String CLASS_SECURITY_LOGOUT_SUCCESS_HANDLER = "SecurityLogoutSuccessHandler";
	private static final String METHOD_ON_LOG_OUT_SUCCESS = "onLogoutSuccess";

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//String userId = ((UniversalUser)authentication.getPrincipal()).getUserId();
		//LogUtil.printLogDebug(CLASS_SECURITY_LOGOUT_SUCCESS_HANDLER, METHOD_ON_LOG_OUT_SUCCESS, "Current Language : " + RequestContextUtils.getLocale(request));
		
		super.onLogoutSuccess(request, response, authentication);

	}

}
