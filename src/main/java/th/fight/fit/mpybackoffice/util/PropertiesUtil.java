package th.fight.fit.mpybackoffice.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil {
	
	@Autowired private MessageSource messageSource;
	
	public String getValue(String messageKey){ 
		return messageSource.getMessage(messageKey, null, null);
		
	} 

	public String getValue(String messageKey, Locale local){ 
		return messageSource.getMessage(messageKey, null, local);
		
   }

}
