package info.salma.jwtauthentication;

import info.salma.jwtauthentication.entity.Role;
import info.salma.jwtauthentication.entity.User;
import info.salma.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtAuthenticationApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

    public void run(String... args) throws Exception {
        try {
            User adminAccount = userRepository.findByRole(Role.ADMIN);
            if (adminAccount == null) {
                User user = new User();
                user.setRole(Role.ADMIN);
                user.setEmail("admin@gmail.com");
                user.setFirstname("Admin");
                user.setLastname("Admin");
                user.setPassword(new BCryptPasswordEncoder().encode("admin"));
                userRepository.save(user);
            }
        } catch (Exception e) {
            // Handle the specific exception or log it
            e.printStackTrace(); // or use a logger
            throw new RuntimeException("Failed to create admin account", e);
        }

    }

}
