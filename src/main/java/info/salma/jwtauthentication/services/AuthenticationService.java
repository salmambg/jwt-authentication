package info.salma.jwtauthentication.services;

import info.salma.jwtauthentication.dto.JwtAuthenticationResponse;
import info.salma.jwtauthentication.dto.SignInRequest;
import info.salma.jwtauthentication.dto.SignUpRequest;
import info.salma.jwtauthentication.entity.User;

public interface AuthenticationService {

    User signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

}
