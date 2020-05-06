package com.brulato;

import java.io.IOException;

public class BitWriter {

    public static byte currentlyOperating = 0x0;
    public static int bitsLeft = 8;

    public static void writeBits(int numZeroes, boolean isLastWrite) {
        int numZeroesLeft = numZeroes;
        while (bitsLeft >= 0) {
            if (bitsLeft == 0) {
                writeBytes(new byte[]{currentlyOperating});
                bitsLeft = 8;
                currentlyOperating = 0x0;
            }
            if (numZeroesLeft > 0) {
                numZeroesLeft--;
                bitsLeft--;
            } else if (numZeroesLeft == 0) {
                currentlyOperating += Math.pow(2, bitsLeft - 1);
                bitsLeft--;
                if (bitsLeft == 0 || isLastWrite) {
                    writeBytes(new byte[]{currentlyOperating});
                }
                break;
            }
        }
    }

    public static void writeBytes(byte[] toWrite) {
        System.out.println("Byte written to output: " + toWrite[0]);
        try {
            CompressorManager.outputStream.write(toWrite, 0, toWrite.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Couldn't write bytes to output file!");
        }
    }

}
