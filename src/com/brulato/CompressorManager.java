package com.brulato;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CompressorManager {

    public static FileInputStream inputStream;
    public static FileOutputStream outputStream;
    public static int bytesPerLeaf;
    public static byte[] bytesBuffer;

    public CompressorManager(FileInputStream inputStream, FileOutputStream outputStream, int bytesPerLeaf){
        CompressorManager.inputStream = inputStream;
        CompressorManager.outputStream = outputStream;
        CompressorManager.bytesPerLeaf = bytesPerLeaf;
        CompressorManager.bytesBuffer = new byte[bytesPerLeaf];
    }

    public void prepareCompression(){
        try{
            while(true){
                bytesBuffer = new byte[bytesPerLeaf];
                int bytesRead = inputStream.read(bytesBuffer, 0, bytesBuffer.length);
                if(bytesRead == bytesPerLeaf){
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
        System.out.println("Prepared for compression!");
    }

    public void doCompression(){
        System.out.println(FrequencyCounter.bytes.stream().map(bytes -> new String(bytes, StandardCharsets.UTF_8)).collect(Collectors.toList()));
        System.out.println(FrequencyCounter.freqs);
        BitWriter.writeBits(0, true);
    }

    public void writeCompressedFile(){

    }

}
