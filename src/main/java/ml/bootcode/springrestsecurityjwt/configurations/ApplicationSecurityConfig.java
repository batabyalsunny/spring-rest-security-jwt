/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import ml.bootcode.springrestsecurityjwt.configurations.security.AuthorizationFilter;

/**
 * @author sunnyb
 *
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthenticationEntryPoint authenticationEntryPoint;
	private LogoutSuccessHandler logoutSuccessHandler;
	private UserDetailsService userDetailsService;
	private AuthorizationFilter authorizationFilter;

	/**
	 * @param authenticationEntryPoint
	 * @param logoutSuccessHandler
	 * @param userDetailsService
	 * @param authorizationFilter
	 */
	public ApplicationSecurityConfig(AuthenticationEntryPoint authenticationEntryPoint,
			LogoutSuccessHandler logoutSuccessHandler, UserDetailsService userDetailsService,
			AuthorizationFilter authorizationFilter) {
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.logoutSuccessHandler = logoutSuccessHandler;
		this.userDetailsService = userDetailsService;
		this.authorizationFilter = authorizationFilter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/auth/**").permitAll().anyRequest()
				.authenticated().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				.logout().logoutSuccessHandler(logoutSuccessHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
