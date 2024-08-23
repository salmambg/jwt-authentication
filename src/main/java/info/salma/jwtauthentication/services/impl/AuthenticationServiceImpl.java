package info.salma.jwtauthentication.services.impl;

import info.salma.jwtauthentication.dto.JwtAuthenticationResponse;
import info.salma.jwtauthentication.dto.SignInRequest;
import info.salma.jwtauthentication.dto.SignUpRequest;
import info.salma.jwtauthentication.entity.Role;
import info.salma.jwtauthentication.entity.User;
import info.salma.jwtauthentication.repository.UserRepository;
import info.salma.jwtauthentication.services.AuthenticationService;
import info.salma.jwtauthentication.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signUp(SignUpRequest signUpRequest) {
         User user = new User();
         user.setEmail(signUpRequest.getEmail());
         user.setFirstname(signUpRequest.getFirstname());
         user.setLastname(signUpRequest.getLastname());
         user.setRole(Role.USER);
         user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

         userRepository.save(user);
         return user;
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));
       var user = userRepository.findByEmail(signInRequest.getEmail()).
               orElseThrow(() -> new IllegalArgumentException("Email or password not found"));
       var jwt =jwtService.generateToken(user);
       var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),user);

       JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
       jwtAuthenticationResponse.setToken(jwt);
       jwtAuthenticationResponse.setRefreshToken(refreshToken);
       return jwtAuthenticationResponse;

    }

}
