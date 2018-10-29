package th.fight.fit.mpybackoffice.controller;

import java.math.BigInteger;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;

public abstract class BaseController {

	@Autowired protected HttpServletRequest request;
	@Autowired protected MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public String getLanguage()throws Exception {
		return getLanguage(request);
	}

	public String getLanguage(HttpServletRequest request)throws Exception {
		return RequestContextUtils.getLocale(request).getLanguage();
	}
	
	public Locale getLocalTH() {
		return new Locale("th", "TH");
		
	}
        
        public Locale getLocalForDate(String language) {
            if(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language)){
                return new Locale("en", "EN");
            } else {
                return new Locale("th", "TH");
            }
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleGlobalException(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		ex.printStackTrace();
		modelAndView.addObject("globalErrorMsg", messageSource.getMessage(ProjectConstant.EXCEPTION_GLOBAL, null, RequestContextUtils.getLocale(request)));

		modelAndView.setViewName("mfm.error");

		return modelAndView;
	}
	
	public String getIpAddress(HttpServletRequest request){
		String ipAddress = null;

		if(request.getRemoteAddr() !=null){
			ipAddress = request.getRemoteAddr();
		}else{
			String ipX =  request.getHeader("X-FORWARDED-FOR");  
			if(ipX != null){
				String[] ipXarray= ipX.split("\\,");
				if(ipXarray != null && ipXarray.length >0){
					ipAddress = ipXarray[0]!=null?ipXarray[0].trim():null;
				}
			}
		}

		return ipAddress;
	}
	
	public ResponseEntity<String> getJSONResponseHeaders(String json){
		HttpHeaders responseHeaders = new HttpHeaders(); 
        responseHeaders.add("Content-Type", "application/json; charset=utf-8"); 
        return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
		
	}
	
}
