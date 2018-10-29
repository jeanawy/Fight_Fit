package th.fight.fit.mpybackoffice.interceptor;

import java.math.BigInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.ProcSessionLogin;
import th.fight.fit.mpybackoffice.service.ProcSessionLoginService;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.SystemParamUtil;
import th.fight.fit.mpybackoffice.util.Utility;

public class DuplicateLoginCheckingInterceptor extends HandlerInterceptorAdapter {

	private static final String CLASS_DUPLICATE_LOGIN_CHECKING_INTERCEPTOR = "DuplicateLoginCheckingInterceptor";
	private static final String METHOD_PRE_HANDLE = "preHandle";
	
	@Autowired private MessageSource messageSource;
	@Autowired private ProcSessionLoginService procSessionLoginService;
	@Autowired private SystemParamUtil systemParamUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String sessionMode = systemParamUtil.getValue(ProjectConstant.SYSTEM_PARAM_SESSION_MODE);

		if(ProjectConstant.SYSTEM_PARAM_SESSION_MODE_FIRST_DISCONNECT.equals(sessionMode)){
			String procSid = request.getParameter(ProjectConstant.KEY_PROC_SID);
			
			//LogUtil.printLogDebug(CLASS_DUPLICATE_LOGIN_CHECKING_INTERCEPTOR, METHOD_PRE_HANDLE, "procSid : " + procSid);
			
			if(StringUtils.isNotEmptyOrNull(procSid)){
				ProcSessionLogin procSessionLogin = procSessionLoginService.getProcSessionLogin(new BigInteger(procSid));
				
				if(procSessionLogin == null){
					//LogUtil.printLogDebug(CLASS_DUPLICATE_LOGIN_CHECKING_INTERCEPTOR, METHOD_PRE_HANDLE, "Duplicate login of sid : " + procSid);
					
					request.setAttribute("errorMsg", messageSource.getMessage(ProjectConstant.EXCEPTION_SESSION_CONTROL_DUPLICATE_LOGIN, null, Utility.getLocale(RequestContextUtils.getLocale(request).getLanguage())));
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("errorSession.jsp");
					dispatcher.forward(request, response);
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
	}

	
}
