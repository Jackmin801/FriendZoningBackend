package com.meowmeow.dhateapp.Chat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation implements Serializable,Comparable<Conversation> {
    private UUID uid;
    private int unreadMsgNum;
    private LocalDateTime lastMsgTime;
    private String lastMsgText;
    private String img;
    private String name;
    private List<Message> msg;

    public Conversation(){}
    public Conversation(String img, String name) {
        this.uid = UUID.randomUUID();
        this.unreadMsgNum = 0;
        this.img = img;
        this.name = name;
    }

    private void incrUnread(){
        unreadMsgNum++;
    }

    public void clearUnread(){
        unreadMsgNum = 0;
    }

    public Message addMsgOther(String text){
        lastMsgText = text;
        lastMsgTime = LocalDateTime.now();
        incrUnread();
        return new Message(false,lastMsgText);
    }

    public Message addMsgSelf(String text){
        lastMsgText = text;
        lastMsgTime = LocalDateTime.now();
        return new Message(true,lastMsgText);
    }

    public UUID getUid() {
        return uid;
    }

    public void setMsg(List<Message> msg){
        this.msg = msg;
    }

    ///

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public int getUnreadMsgNum() {
        return unreadMsgNum;
    }

    public void setUnreadMsgNum(int unreadMsgNum) {
        this.unreadMsgNum = unreadMsgNum;
    }

    public LocalDateTime getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(LocalDateTime lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public String getLastMsgText() {
        return lastMsgText;
    }

    public void setLastMsgText(String lastMsgText) {
        this.lastMsgText = lastMsgText;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMsg() {
        return msg;
    }

    @Override
    public int compareTo(Conversation o) {
        return -getLastMsgTime().compareTo(o.getLastMsgTime());
    }
}
