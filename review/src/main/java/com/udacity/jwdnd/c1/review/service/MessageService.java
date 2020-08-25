package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessagesMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private MessagesMapper messagesMapper;

    public MessageService(MessagesMapper messagesMapper) {
        this.messagesMapper = messagesMapper;
    }

    public Integer addMessage(ChatForm chatForm){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(username == null){
            throw new UsernameNotFoundException("Username is null in security context.");
        }
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(username);
        if(chatForm.getMessageType().equals("Shout")){
            chatMessage.setMessageTxt(chatForm.getMessageText().toUpperCase());
        }else if(chatForm.getMessageType().equals("Whisper")){
            chatMessage.setMessageTxt(chatForm.getMessageText().toLowerCase());
        }else{
            chatMessage.setMessageTxt(chatForm.getMessageText());
        }
        return messagesMapper.createChatMessage(chatMessage);
    }

    public List<ChatMessage> getMessages(){
        return  this.messagesMapper.getAllMessages();
    }

    @PostConstruct
    public void initializations(){
        System.out.println("MessageService created. Received message value from message bean.");
    }

}
