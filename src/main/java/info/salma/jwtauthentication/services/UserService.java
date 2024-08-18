package info.salma.jwtauthentication.services;

import info.salma.jwtauthentication.services.impl.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
    UserDetailsService getUserDetailsService();
}
