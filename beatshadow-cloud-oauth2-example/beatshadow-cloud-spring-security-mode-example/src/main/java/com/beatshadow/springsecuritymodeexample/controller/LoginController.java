package com.beatshadow.springsecuritymodeexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/15 14:35
 */
@RestController
public class LoginController {


    @GetMapping(value = "/r/r1",produces = "text/plain; charset=utf-8")
    public String r1(){
      return "/r/r1";
    }

    @GetMapping(value = "/r/r2",produces = "text/plain; charset=utf-8")
    public String r2(){
        return "/r/r2";
    }


    @PostMapping(value = "/index" ,produces = "text/plain; charset=utf-8")
    public String index(){
        return "logout success " ;
    }

}
