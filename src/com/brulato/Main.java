package com.brulato;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        if(args.length < 1){
            throw new Error("At least 1 argument must be provided! (The path to the file to compress.)");
        }

        String filepath = args[0];
        int bytesPerLeaf;
        if(args.length > 1){
            try {
                bytesPerLeaf = Integer.valueOf(args[1]);
            } catch (Error e){
                e.printStackTrace();
                throw new Error("Second argument must be an integer number of bytes per leaf in the compression tree!");
            }
        } else {
            bytesPerLeaf = 1;
        }

        FileInputStream toBeCompressed;

        try {
             toBeCompressed = new FileInputStream(filepath);
        } catch (FileNotFoundException e){
             e.printStackTrace();
             throw new Error("File to be compressed could not be found at: " + filepath);
        }

        String[] splits = filepath.split("\\.");
        File outputFile = new File(splits[0] + ".jcomp");
        FileOutputStream compressedFileStream;

        try{
            if(outputFile.createNewFile()){
                // File didn't exist
            } else {
                // File already exists
                // TODO: Add overwrite message?
            }
            compressedFileStream = new FileOutputStream(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Couldn't create .jcomp file in the same folder as the input file!");
        }


        CompressorManager compressorManager = new CompressorManager(toBeCompressed, compressedFileStream, bytesPerLeaf);
        compressorManager.prepareCompression();
        compressorManager.doCompression();
        compressorManager.writeCompressedFile();

    }
}
