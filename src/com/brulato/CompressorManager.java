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

    public CompressorManager(FileInputStream inputStream, FileOutputStream outputStream, int bytesPerLeaf){
        CompressorManager.inputStream = inputStream;
        CompressorManager.outputStream = outputStream;
        CompressorManager.bytesPerLeaf = bytesPerLeaf;
    }

    public void prepareCompression(){
        FrequencyCounter.countFrequencies();
        System.out.println("Prepared for compression!");
    }

    public void doCompression(){
        System.out.println(FrequencyCounter.bytes.stream().map(bytes -> new String(bytes, StandardCharsets.UTF_8)).collect(Collectors.toList()));
        System.out.println(FrequencyCounter.freqs);
        BitWriter.writeBits(5, true);
    }

    public void writeCompressedFile(){

    }

}
