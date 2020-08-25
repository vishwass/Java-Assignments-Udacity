package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private String messageid;
    private String username;
    private String messagetext;
    private String messageType;

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageTxt() {
        return messagetext;
    }

    public void setMessageTxt(String messageTxt) {
        this.messagetext = messageTxt;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
