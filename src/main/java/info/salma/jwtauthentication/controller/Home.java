package info.salma.jwtauthentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/welcome")
    public String welcome() {
        String text = "Welcome to JWTAuthentication!";
        text+= "this text is not for unauthenticated users.";
        return text;
    }
}
