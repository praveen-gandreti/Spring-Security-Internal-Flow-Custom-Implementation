package SpringSecurity.SpringSecurityCustomImpl.SecurityConfig;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPassswordImpl implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		String encodedPassword="";
		for(int i=0;i<rawPassword.toString().length();i++)
		{
			encodedPassword=encodedPassword+rawPassword.toString().charAt(i);
			encodedPassword=encodedPassword+"$";
		}
		
		return encodedPassword;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if(encode(rawPassword).equals(encodedPassword))
		{
			return true;
		}
		return false;
	}

}
