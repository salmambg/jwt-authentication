package info.salma.jwtauthentication.repository;

import info.salma.jwtauthentication.entity.Role;
import info.salma.jwtauthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);

    User findByRole(Role role);
}
