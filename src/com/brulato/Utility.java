package com.brulato;

public class Utility {

    public static Byte[] bytesToBytes(byte[] in){
        Byte[] bytes = new Byte[in.length];
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = in[i];
        }
        return bytes;
    }

}
