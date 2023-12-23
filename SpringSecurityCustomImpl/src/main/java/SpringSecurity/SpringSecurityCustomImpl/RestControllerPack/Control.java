package SpringSecurity.SpringSecurityCustomImpl.RestControllerPack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringSecurity.SpringSecurityCustomImpl.Model.User;
import SpringSecurity.SpringSecurityCustomImpl.RepositoryUser.UserRepository;

@RestController
public class Control {
	@Autowired
	UserRepository ur;
	
	@GetMapping("/home")
	public String home()
	{
		return "WELCOME HOME";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "THIS IS ADMIN";
	}
	
	@GetMapping("/employee")
	public String employee()
	{
		return "THIS IS employee";
	}
	
	@GetMapping("/auth")
	public String check(Authentication auth)
	{
		System.out.println(auth);

		return "THIS IS PRINCIPAL IS "+auth.getName();
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return ur.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id)
	{
		return ur.findById(id).orElse(null);
	}
	
	@GetMapping("/user")
	public User getUserById(@RequestParam("username") String username)
	{
		return ur.findByUsername(username);
	}
	@GetMapping("/test")
	public String test()
	{
		return "THIS IS TESTING END POINT";
	}

}
