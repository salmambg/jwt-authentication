package info.salma.jwtauthentication.controller;

import info.salma.jwtauthentication.dto.JwtAuthenticationResponse;
import info.salma.jwtauthentication.dto.RefreshTokenRequest;
import info.salma.jwtauthentication.dto.SignInRequest;
import info.salma.jwtauthentication.dto.SignUpRequest;
import info.salma.jwtauthentication.entity.User;
import info.salma.jwtauthentication.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
     private final AuthenticationService authenticationService;

     @PostMapping("/signup")
     public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
         return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
     }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }


}
