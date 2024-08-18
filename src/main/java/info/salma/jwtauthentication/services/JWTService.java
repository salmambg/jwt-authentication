package info.salma.jwtauthentication.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String extractUsername(String token);
    String generateToken(UserDetails userDetails);

    public boolean validateToken(String token, UserDetails userDetails);

}
