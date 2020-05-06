package com.brulato;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FrequencyCounter {

    public static ArrayList<byte[]> bytes = new ArrayList<>();
    public static ArrayList<Integer> freqs = new ArrayList<>();

    public static void addByteFreq(byte[] bytesVal){
        int index = -1;
        for(int i = 0; i < bytes.size(); i++){
            if(Arrays.equals(bytes.get(i), bytesVal)){
                index = i;
            }
        }
        if(index != -1){
            System.out.println("Contained");
            freqs.set(index, freqs.get(index) + 1);
        } else {
            System.out.println("Not Contained");
            bytes.add(bytesVal);
            freqs.add(1);
        }
    }

}
