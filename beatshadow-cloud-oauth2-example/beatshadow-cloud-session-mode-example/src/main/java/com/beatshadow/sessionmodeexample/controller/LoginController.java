package com.beatshadow.sessionmodeexample.controller;

import com.beatshadow.sessionmodeexample.model.AuthorizationRequest;
import com.beatshadow.sessionmodeexample.model.UserDto;
import com.beatshadow.sessionmodeexample.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:35
 */
@RestController
public class LoginController {

    private AuthorizationService authorizationService;

    public LoginController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping(value = "/login" ,produces = "text/plain; charset=utf-8")
    public String login(AuthorizationRequest authorizationRequest , HttpSession httpSession){
        UserDto authorization = authorizationService.authorization(authorizationRequest);
        httpSession.setAttribute(UserDto.SESSION_USER_KEY,authorization);
        return authorization.getFullName()+" login success";
    }

    @GetMapping(value = "/r1",produces = "text/plain; charset=utf-8")
    public String r1(HttpSession httpSession){
        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        return object!=null?((UserDto)object).getFullName()+"logged":"not logged in";
    }

    @GetMapping(value = "/r2",produces = "text/plain; charset=utf-8")
    public String r2(HttpSession httpSession){
        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        return object!=null?((UserDto)object).getFullName()+"logged":"not logged in";
    }


    @GetMapping(value = "/logout" ,produces = "text/plain; charset=utf-8")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "logout success" ;
    }

}
