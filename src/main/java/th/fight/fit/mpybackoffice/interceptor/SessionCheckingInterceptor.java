package th.fight.fit.mpybackoffice.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.UserDetail;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.ProcSessionLoginService;
import th.fight.fit.mpybackoffice.util.Utility;

public class SessionCheckingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
    private static String[] ignoredRequestArr = {"/BOS/loginAdminController-welcome", "/BOS/loginAdmin", "/BOS/initLoginAdmin"};
    private static String requestRequest = "BOSRestController";
    private static String CLASS_SESSION_CHECKING_INTERCEPTOR = "SessionCheckingInterceptor";
    private static String METHOD_PRE_HANDLE = "preHandle";

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ProcSessionLoginService procSessionLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	systemLogger.info(LogFormatter.common("request uri : " + request.getRequestURI()));
    	systemLogger.info(LogFormatter.common("request url : " + request.getRequestURL()));
    	
        // Check for ignore request.
        boolean foundIgnoredRequest = false;
        boolean foundRESTRequest = false;

        for (String ignoredRequest : ignoredRequestArr) {
            if (request.getRequestURI().indexOf(ignoredRequest) != -1) {
                foundIgnoredRequest = true;
                
                systemLogger.info(LogFormatter.common("Found ignoredRequest : " + ignoredRequest));
                
                break;

            }

        }

        if (request.getRequestURI().indexOf(requestRequest) > 0) {
            foundRESTRequest = true;

            systemLogger.info(LogFormatter.common("Found foundRESTRequest."));
                 
        }

        if (!foundIgnoredRequest && !foundRESTRequest) {
            HttpSession session = request.getSession();

            if (session != null) {
                UserDetail user = (UserDetail) session.getAttribute("userDetail");

                if (user != null) {
                	systemLogger.info(LogFormatter.common("Session UserId : " + user.getProcUserProfile().getUserId() + " valid."));
                	
                    // Extend logout time. Added by Ratapong W. 20150917.
                    procSessionLoginService.extendSessionTimeout(user.getSid(), user);

                    return true;

                } else {
                	systemLogger.info(LogFormatter.common("Session invalid."));
                    request.setAttribute("errorMsg", messageSource.getMessage(ProjectConstant.EXCEPTION_SESSION_TIMEOUT, null, Utility.getLocale(RequestContextUtils.getLocale(request).getLanguage())));

                    RequestDispatcher dispatcher = request.getRequestDispatcher("errorSession.jsp");
                    dispatcher.forward(request, response);

                    return false;
                }

            }

        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        boolean foundRESTRequest = false;

        if (request.getRequestURI().indexOf(requestRequest) > 0) {
            foundRESTRequest = true;

        }

        if (!foundRESTRequest) {
            HttpSession session = request.getSession();
            UserDetail userDetail = (UserDetail) session.getAttribute(ProjectConstant.KEY_USER_DETAIL);

            request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());

            if (userDetail != null) {
                request.setAttribute("sid", userDetail.getSid() != null ? userDetail.getSid().toString() : "");
            }

        }

        super.postHandle(request, response, handler, modelAndView);
    }

}
