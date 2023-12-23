package SpringSecurity.SpringSecurityCustomImpl.RepositoryUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringSecurity.SpringSecurityCustomImpl.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);

}
