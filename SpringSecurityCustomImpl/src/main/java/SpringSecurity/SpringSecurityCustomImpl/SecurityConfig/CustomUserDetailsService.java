package SpringSecurity.SpringSecurityCustomImpl.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SpringSecurity.SpringSecurityCustomImpl.Model.User;
import SpringSecurity.SpringSecurityCustomImpl.RepositoryUser.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=ur.findByUsername(username);
		if(u==null)
		{
			throw  new UsernameNotFoundException(
			          "Problem during authentication!");
		}
		return new CustomUserDetails(u);
	}

}
