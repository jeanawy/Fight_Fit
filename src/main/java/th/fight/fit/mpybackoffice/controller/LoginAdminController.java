package th.fight.fit.mpybackoffice.controller;

//package th.mfec.mpybackoffice.controller;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.logging.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import th.mfec.mpybackoffice.constant.ProjectConstant;
//import th.mfec.mpybackoffice.domain.UserDetail;
//import th.mfec.mpybackoffice.formatter.LogFormatter;
//import th.mfec.mpybackoffice.service.LoginService;
//import th.mfec.mpybackoffice.service.PckMenuService;
//import th.mfec.mpybackoffice.util.DateUtil;
//import th.mfec.mpybackoffice.util.MasterUtils;
//import th.mfec.mpybackoffice.util.SystemParamUtil;
//
//@Controller
//public class LoginAdminController extends BaseController {
//
//	private static final Logger accessLogger = Logger.getLogger(ProjectConstant.APPENDER_ACCESS_LOG);
//    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
//    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
//	
//    @Autowired private SystemParamUtil systemParamUtil;
//    @Autowired private LoginService loginService;
//    @Autowired private PckMenuService pckMenuService;
//    
//    @RequestMapping(value="/initLoginAdmin", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView initLogin(HttpServletRequest request){
//		Date startDate = new Date();
//		ModelAndView model = new ModelAndView("login");
//
//		systemLogger.info(LogFormatter.common(messageSource.getMessage("error.global", null, request.getLocale())));
//		systemLogger.info(LogFormatter.common(messageSource.getMessage("messagesource.db.login", null, request.getLocale())));
//		
//		request.setAttribute("currentLocale", RequestContextUtils.getLocale(request).getLanguage());
//		
//		accessLogger.info(LogFormatter.accessLog(startDate, new Date(),  null, null, ProjectConstant.STATUS_SUCCESS, null, null));
//		
//		return model;
//	}
//    
//    @RequestMapping(value="/loginAdmin", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView login(HttpServletRequest request){
//		Date startDate = new Date();
//		ModelAndView model = new ModelAndView("login");
//		
//		if(request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null){
//			String[] errors = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString().split("[|]");
//			
//			model.addObject("username",errors[2]);
//			model.addObject("errorMsg", getMessageSource().getMessage(errors[1], null, RequestContextUtils.getLocale(request)));
//			
//			request.getSession().removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
//			
//			accessLogger.info(LogFormatter.accessLog(startDate, new Date(),  null, errors[2], ProjectConstant.STATUS_FAIL, null, getMessageSource().getMessage(errors[1], null, RequestContextUtils.getLocale(request))));
//			
//			return model;
//			
//		}
//		
//		accessLogger.info(LogFormatter.accessLog(startDate, new Date(),  null, null, ProjectConstant.STATUS_SUCCESS, null, null));
//		
//		return model;
//	}
//    
//    @RequestMapping(value="/loginAdminController-welcome", method= {RequestMethod.GET, RequestMethod.POST})
//    @PreAuthorize("hasAuthority('FUNC_001')")
//	public ModelAndView weclome(Authentication authentication, HttpServletRequest request){
//		/*Date startDate = new Date();
//		HttpSession session = request.getSession();
//		session.setMaxInactiveInterval(Integer.parseInt(systemParamUtil.getValue(ProjectConstant.SYSTEM_PARAM_SESSION_TIMEOUT))); // second unit
//		session.setAttribute(ProjectConstant.SYSTEM_PARAM_SESSION_ALERT, Integer.parseInt(systemParamUtil.getValue(ProjectConstant.SYSTEM_PARAM_SESSION_ALERT)));
//		
////		if(authentication == null)
////			return initLogin(request);
//		
//		UserDetail userDetail = (UserDetail)authentication.getPrincipal();
//		session.setAttribute("userDetail", userDetail);
//		session.setAttribute("lastLoginDate", DateUtil.formatDateForHeader(userDetail.getUserLogin().getLastLoginDttm(), RequestContextUtils.getLocale(request)));
//		session.setAttribute("lastLoginTime", DateUtil.formatTime(userDetail.getUserLogin().getLastLoginDttm()));
//		
//		Map<String, String> menuMap = null;
//		try {
//			menuMap = MasterUtils.getMenuMap(getLanguage());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		session.setAttribute(ProjectConstant.KEY_MENU_MAP, menuMap);
//		
//		accessLogger.info(LogFormatter.accessLog(startDate, new Date(),  null, userDetail != null ? userDetail.getUserLogin().getUserName() : null, ProjectConstant.STATUS_SUCCESS, null, null));
//		*/
//		return new ModelAndView("login.welcome");
//		
//	}
//	
//	@RequestMapping(value="/loginAdminController-logout", method= {RequestMethod.GET, RequestMethod.POST})
//	public String logout() throws Exception{
//		Date startDate = new Date();
//		UserDetail userDetail = (UserDetail) request.getSession().getAttribute(ProjectConstant.KEY_USER_DETAIL);
//		
//		loginService.logout();
//		
//		accessLogger.info(LogFormatter.accessLog(startDate, new Date(), userDetail.getSid().toString(), userDetail.getUserLogin().getUserName(), ProjectConstant.STATUS_SUCCESS, null, null));
//		
//		return "redirect:logout";
//	}
//    
//}
