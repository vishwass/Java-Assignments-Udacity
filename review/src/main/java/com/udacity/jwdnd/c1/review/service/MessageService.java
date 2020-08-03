package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private List<ChatMessage> messages;
    public MessageService() {
    }

    public Boolean addMessage(ChatForm chatForm){
        logger.info("Received new chat message from username:"+ chatForm.getUsername() +", messageTxt:" +chatForm.getMessageText());
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        String messageTxt = chatForm.getMessageText();
        if(chatForm.getMessageType().equals("Shout")){
             messageTxt = messageTxt.toUpperCase();
        }else if(chatForm.getMessageType().equals("Whisper")){
            messageTxt = messageTxt.toLowerCase();
        }
        chatMessage.setMessageTxt(messageTxt);
        return messages.add(chatMessage);
    }

    public List<ChatMessage> getMessages(){
        return this.messages;
    }

    @PostConstruct
    public void initializations(){
        this.messages = new ArrayList<>();
        System.out.println("MessageService created. Received message value from message bean . Value received: "+ messages.toString());
    }

}
