package com.udacity.jwdnd.c1.review.Controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    private final String[] messageTypes = new String[]{"Say", "Shout", "Whisper"};

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"/","/chat"},method = RequestMethod.GET)
    public String showChatMessages(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("chatMessages", messageService.getMessages());
        return "chat";
    }

    @RequestMapping(value = {"/","/chat"}, method = RequestMethod.POST)
    public String addMessage(@ModelAttribute("chatForm") ChatForm chatForm, final BindingResult bindingResult, Model model){
        this.messageService.addMessage(chatForm);
        model.addAttribute("chatMessages", messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] getAllMessageTypes(){
        return messageTypes;
    }

}
