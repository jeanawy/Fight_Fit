package th.fight.fit.mpybackoffice.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import th.fight.fit.mpybackoffice.interceptor.DuplicateLoginCheckingInterceptor;
import th.fight.fit.mpybackoffice.interceptor.SessionCheckingInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "th.fight.fit.mpybackoffice")
public class ApplicationConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Autowired private DatabaseMessageSource databaseMessageSource;
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("th", "TH"));
        return slr;
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    /*@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}*/
    @Bean
    TilesViewResolver viewResolver() {
        TilesViewResolver viewResolver = new TilesViewResolver();
        return viewResolver;
    }

    @Bean
    TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("classpath:tiles-definitions.xml");
        tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
        return tilesConfigurer;
    }

    @Bean
    //public ReloadableResourceBundleMessageSource messageSource() {
    public AbstractMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("classpath:FightFitSecretsApplicationResources");
        messageSource.addBasenames("classpath:FightFitSecretsMessageResources");
        messageSource.addBasenames("classpath:FightFitSecretsResources");

        databaseMessageSource.setParentMessageSource(messageSource);
        
        /*messageSource.setBasenames("file:D:/apps/bos/config/BOSApplicationResources",
				"classpath:BOSMessageResources",
				"file:D:/apps/bos/config/BOSSecretsResources");*/
        return databaseMessageSource;

    }

	@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
        //mapping.setInterceptors(new Object[] {localeChangeInterceptor(),getSessionCheckingHandler(), getDuplicateLoginCheckingHandler()});
        mapping.setInterceptors(new Object[]{localeChangeInterceptor()});
        return mapping;
    }

    @Bean
    public SessionCheckingInterceptor getSessionCheckingHandler() {
        return new SessionCheckingInterceptor();

    }

    @Bean
    public DuplicateLoginCheckingInterceptor getDuplicateLoginCheckingHandler() {
        return new DuplicateLoginCheckingInterceptor();

    }

    @Bean
    public MultipartResolver multipartResolver() {
    	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 10MB
        multipartResolver.setMaxUploadSizePerFile(1048576); // 1MB
        return multipartResolver;
    }

}
