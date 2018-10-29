package th.fight.fit.mpybackoffice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import th.fight.fit.mpybackoffice.security.SecurityAuthenticationProvider;
import th.fight.fit.mpybackoffice.security.SecurityLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
	@Autowired private SecurityAuthenticationProvider securityAuthenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			//.antMatchers("/css/**").permitAll()
			//.antMatchers("/fonts/**").permitAll()
			//.antMatchers("/images/**").permitAll()
			//.antMatchers("/js/**").permitAll()
			//.anyRequest().authenticated()
			
			.antMatchers("/").permitAll()
			.and()
			.formLogin()
				.loginPage("/initLoginAdmin")
					.defaultSuccessUrl("/loginAdminController-welcome")
					.failureUrl("/loginAdmin")
					//.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/initLoginAdmin")
					.logoutSuccessHandler(securityLogoutSuccessHandler)
					//.permitAll()
				.and()
			.csrf().disable();	
				
	}

	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws  Exception {
		auth.authenticationProvider(securityAuthenticationProvider);
		
	}
	
}
