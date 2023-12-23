package SpringSecurity.SpringSecurityCustomImpl.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration	
@EnableWebSecurity
public class SecurityConfigCls extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	CustomPassswordImpl customPassswordImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/admin").hasAuthority("admin")
		.antMatchers("/employee").hasAnyAuthority("admin","employee").antMatchers("/test").authenticated()
		.antMatchers("/auth").authenticated().anyRequest().permitAll().and().httpBasic().and().formLogin();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	{
		auth.authenticationProvider(customAuthenticationProvider);
	}
	
	@Bean
	public PasswordEncoder encode()
	{
		return new CustomPassswordImpl();
	}
}
