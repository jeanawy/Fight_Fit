package th.fight.fit.mpybackoffice.filter;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.log4j.Logger;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.util.StringUtils;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	
	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
		
	}

	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		String value = super.getHeader(name);
		
		return stripXSS(value);
	}

	@Override
	public String getParameter(String parameter) {
		// TODO Auto-generated method stub
		String value = super.getParameter(parameter);
		
		return stripXSS(value);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            systemLogger.debug("Request values [" + i + "] :" + values[i]);
            
            encodedValues[i] = stripXSS(values[i]);
            systemLogger.debug("Request values stripXSS [" + i + "] :" + encodedValues[i]);
        }

        return encodedValues;
	}

	private String stripXSS(String value) {

		if(StringUtils.isNotEmptyOrNull(value)) {
			value = value.replaceAll("", "");
			Pattern scriptPattern = Pattern.compile("eval\\\\((.*)\\\\)", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("[\\\\\\\"\\\\\\'][\\\\s]*javascript:(.*)[\\\\\\\"\\\\\\']", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("(?i)<script.*?>.*?<script.*?>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("(?i)<script.*?>.*?</script.*?>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("(?i)<.*?javascript:.*?>.*?</.*?>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("(?i)<.*?\\\\s+on.*?>.*?</.*?>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
			scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			
		}
		
		return value;
	}
	
}
