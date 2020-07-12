package com.udacity.jwdnd.c1.review;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    private String message;
    public MessageService( String message) {
        this.message = message;
    }

    protected String toUpperCase(){
        return message.toUpperCase();
    }

    protected String toLowerCase(){
        return message.toLowerCase();
    }

    @PostConstruct
    public void initializations(){
        System.out.println("MessageService created. Received message value from message bean . Value received: "+ message);
    }

}
