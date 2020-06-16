package com.meowmeow.dhateapp.Encryption;

import java.util.UUID;

public class TeaKey implements Key{
    private int[] key;
    //Constructor for new random key
    public TeaKey(){
        key = new int[4];
        for(int i=0;i<4;i++)key[i]=RandomSingleton.getInstance().nextInt();
    }
    //Constructor for cloning keys
    public TeaKey(TeaKey other){
        key = other.key;
    }
    //Constructor for key from UUID
    public TeaKey(UUID uuid){
        long a = uuid.getLeastSignificantBits();
        long b = uuid.getMostSignificantBits();
        key = new int[4];
        key[0] = (int)a; key[2] = (int)b;
        a>>=32; b>>=32;
        key[1] = (int)a; key[3] = (int)b;
    }

    public int[] getKey(){
        return key;
    }
}