package com.udacity.jwdnd.c1.review.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class LogoutController {

    @Controller
    @RequestMapping("/logout")
    public class LoginController {

        Logger logger = LoggerFactory.getLogger(com.udacity.jwdnd.c1.review.Controller.LoginController.class);

        @PostMapping
        public String logout(){
            logger.info("logout request received");
            return "login";
        }
    }
}
