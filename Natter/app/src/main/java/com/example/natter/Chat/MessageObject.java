package com.example.natter.Chat;

public class MessageObject {

    String messageId,
           message,
            senderId;
    public MessageObject(String messageId, String senderId, String message)
    {
        this.messageId = messageId;
        this.senderId = senderId;
        this.message = message;

    }

    public String getMessageId() {
        return messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}
