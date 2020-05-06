package com.brulato;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.brulato.CompressorManager.bytesPerLeaf;

public class FrequencyCounter {

    public static ArrayList<byte[]> bytes = new ArrayList<>();
    public static ArrayList<Integer> freqs = new ArrayList<>();
    public static byte[] bytesBuffer;

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

    public static void countFrequencies(){
        try{
            while(true){
                bytesBuffer = new byte[CompressorManager.bytesPerLeaf];
                int bytesRead = CompressorManager.inputStream.read(bytesBuffer, 0, bytesBuffer.length);
                if(bytesRead == CompressorManager.bytesPerLeaf){
                    FrequencyCounter.addByteFreq(bytesBuffer);
                } else if (bytesRead != -1){
                    FrequencyCounter.addByteFreq(Arrays.copyOfRange(bytesBuffer, 0, bytesRead));
                } else {
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new Error("There was an exception during compression!");
        }
    }

}
