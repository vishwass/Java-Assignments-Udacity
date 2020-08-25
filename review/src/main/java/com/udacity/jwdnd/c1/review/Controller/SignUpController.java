package com.udacity.jwdnd.c1.review.Controller;

import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserService userService;

    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView(){
         return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model){
        logger.info("Received signup request. User name:" + user.getUsername());
        String signupError = null;

        if(!userService.isUsernameAvailable(user)){
            signupError = "Username already exists!";
        }

        if(signupError == null){
            int rowsAffected = userService.createUser(user);
            if(rowsAffected < 1){
                signupError = "There was an error signing you up . Please try again!";
            }
        }
        logger.info(signupError);

        if(signupError == null){
            model.addAttribute("signupSuccess",true);
        }else{
            model.addAttribute("signupError",signupError);
        }

        return "login";


    }
}
