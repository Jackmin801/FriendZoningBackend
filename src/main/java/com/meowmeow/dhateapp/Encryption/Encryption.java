package com.meowmeow.dhateapp.Encryption;
public interface Encryption{
    public String encrypt(String text,Key key);
    public String decrypt(String cipherText,Key key);
}