package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessagesMapper;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Integer addMessage(ChatMessage chatmessage){
        logger.info("Received new chat message from username:"+ chatmessage.getUsername() +", messageTxt:" +chatmessage.getMessageTxt());
        return messagesMapper.createChatMessage(chatmessage);
    }

    public List<ChatMessage> getMessages(){

        List<ChatMessage> chatMessages =  this.messagesMapper.getAllMessages();
        for(ChatMessage chatMessage : chatMessages){
            if(chatMessage.getMessageType().equals("Shout")){
                chatMessage.setMessageTxt(chatMessage.getMessageTxt().toUpperCase());
            }else if(chatMessage.getMessageType().equals("Whisper")){
                chatMessage.setMessageTxt(chatMessage.getMessageTxt().toLowerCase());
            }
        }
        return chatMessages;
    }

    @PostConstruct
    public void initializations(){
        System.out.println("MessageService created. Received message value from message bean.");
    }

}
