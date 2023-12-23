package SpringSecurity.SpringSecurityCustomImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import SpringSecurity.SpringSecurityCustomImpl.Model.User;
import SpringSecurity.SpringSecurityCustomImpl.RepositoryUser.UserRepository;
import SpringSecurity.SpringSecurityCustomImpl.SecurityConfig.CustomPassswordImpl;

@SpringBootApplication
public class SpringSecurityCustomImplApplication implements CommandLineRunner{

	@Autowired
	CustomPassswordImpl customPassswordImpl;
	
	@Autowired
	UserRepository ur;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCustomImplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String password=customPassswordImpl.encode("abcd");
		User u1=new User("praveen",password,"admin");
		User u2=new User("rasool",password,"admin");
		User u3=new User("thousif",password,"admin");
		User u4=new User("bhanu",password,"employee");
		User u5=new User("anil",password,"employee");
		ur.save(u1);
		ur.save(u2);
		ur.save(u3);
		ur.save(u4);
		ur.save(u5);
		
	}

}
