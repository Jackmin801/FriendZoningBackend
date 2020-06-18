package com.meowmeow.dhateapp.Encryption;

import java.util.Base64;

public class TeaEncryption implements Encryption {
    @Override
    public String encrypt(String text, Key key) {
        byte[] temp = text.getBytes();
        for(int i=0;i<temp.length-8;i+=8){
            encrypt64(temp,i,key);
        }

        return Base64.getEncoder().encodeToString(temp);
    }

    @Override
    public String decrypt(String cipherText, Key key) {
        byte[] temp = Base64.getDecoder().decode(cipherText);
        for(int i=0;i<temp.length-8;i+=8){
            decrypt64(temp,i,key);
        }
        return new String(temp);
    }

    private int byteToInt(byte[] arr, int offset){
        return ((arr[offset] & 0xFF) << 24) | ((arr[offset+1] & 0xFF) << 16) | ((arr[offset+2] & 0xFF) << 8 ) | (arr[offset+3] & 0xFF);
    }
    private void toByteArray(int integer,byte[] arr, int offset) {
        arr[offset] = (byte)(integer >> 24);
        arr[offset + 1] = (byte)(integer >> 16);
        arr[offset + 2] = (byte)(integer >> 8);
        arr[offset + 3] = (byte)integer;
    }
    private void encrypt64(byte[] text, int offset,Key key){
        int a = byteToInt(text,offset);
        int b = byteToInt(text,offset+4);
        int sum=0, delta = 0x9E3779B9;
        int[] k = key.getKey();
        for (int i = 0; i < 32; i++) {
            sum += delta;
            a += ((b<<4) + k[0]) ^ (b + sum) ^ ((b>>5) + k[1]);
            b += ((a<<4) + k[2]) ^ (a + sum) ^ ((a>>5) + k[3]);
        }
        toByteArray(a,text,offset);
        toByteArray(b,text,offset+4);
    }

    private void decrypt64(byte[] text, int offset,Key key){
        int a = byteToInt(text,offset);
        int b = byteToInt(text,offset+4);
        int sum=0xC6EF3720, delta = 0x9E3779B9;
        int[] k = key.getKey();
        for (int i = 0; i < 32; i++) {
            b -= ((a<<4) + k[2]) ^ (a + sum) ^ ((a>>5) + k[3]);
            a -= ((b<<4) + k[0]) ^ (b + sum) ^ ((b>>5) + k[1]);
            sum -= delta;
        }
        toByteArray(a,text,offset);
        toByteArray(b,text,offset+4);
    }

}
