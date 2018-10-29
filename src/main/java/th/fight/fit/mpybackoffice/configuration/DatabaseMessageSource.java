package th.fight.fit.mpybackoffice.configuration;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMessageSource extends AbstractMessageSource implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    private final Map<String, Map<String, String>> properties = new HashMap<String, Map<String, String>>();

    public DatabaseMessageSource() {
        reload();
    }

    private String getText(String code, Locale locale) {
        Map<String, String> localized = properties.get(code);
        String textForCurrentLanguage = null;

        if (localized != null) {
            textForCurrentLanguage = localized.get(locale.getLanguage());

            if (textForCurrentLanguage == null) {
                textForCurrentLanguage = localized.get(Locale.ENGLISH.getLanguage());

            }

        }

        if (textForCurrentLanguage == null) {
            try {
                textForCurrentLanguage = getParentMessageSource().getMessage(code, null, locale);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return textForCurrentLanguage != null ? textForCurrentLanguage : code;

    }

    protected Map<String, Map<String, String>> loadTexts() {
        Map<String, Map<String, String>> m = new HashMap<String, Map<String, String>>();

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("en", "Log in");
        map1.put("th", "Log in Thai");
        m.put("messagesource.db.login", map1);

        map1 = new HashMap<String, String>();
        map1.put("en", "Log out");
        map1.put("th", "Log out Thai");
        m.put("messagesource.db.logout", map1);

        return m;

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = (resourceLoader != null ? resourceLoader : new DefaultResourceLoader());

    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = getText(code, locale);
        MessageFormat result = createMessageFormat(msg, locale);

        return result;
    }

    public void reload() {
        properties.clear();
        properties.putAll(loadTexts());

    }

}
