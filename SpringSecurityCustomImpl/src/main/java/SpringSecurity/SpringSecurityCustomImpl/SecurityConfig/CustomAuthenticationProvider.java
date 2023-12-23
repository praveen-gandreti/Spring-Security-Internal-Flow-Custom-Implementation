package SpringSecurity.SpringSecurityCustomImpl.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider{

	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	CustomPassswordImpl customPassswordImpl;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String password=authentication.getCredentials().toString();
		UserDetails user=customUserDetailsService.loadUserByUsername(authentication.getName());
		System.out.println("***************************");
		System.out.println(user);
		System.out.println("***************************");
		if(customPassswordImpl.matches(password, user.getPassword()))
		{
			return new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
		}
		else
		throw new BadCredentialsException("Bad Password you have entered");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
	
	

}
