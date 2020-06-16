package com.meowmeow.dhateapp.Chat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private boolean byMe;
    private String msgText;
    private LocalDateTime timestamp;

    public Message(){}
    public Message(boolean byMe, String msgText) {
        this.byMe = byMe;
        this.msgText = msgText;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isByMe() {
        return byMe;
    }

    public String getMsgText() {
        return msgText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    ///

    public void setByMe(boolean byMe) {
        this.byMe = byMe;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
