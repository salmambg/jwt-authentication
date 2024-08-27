package info.salma.jwtauthentication.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
    UserDetailsService getUserDetailsService();
}
