package com.brulato;

public class BitReader {

    public static int noPos = 0b00000000;
    public static int firstPos = 0b10000000;
    public static int secondPos = 0b01000000;
    public static int thirdPos = 0b00100000;
    public static int fourthPos = 0b00010000;
    public static int fifthPos = 0b00001000;
    public static int sixthPos = 0b00000100;
    public static int seventhPos = 0b00000010;
    public static int eighthPos = 0b00000001;

    public static boolean checkBitInPos(byte in, int position){
        if(position == 0){
            return in == 0;
        } else if(position == 1){
            return (firstPos & in) == 128;
        } else if(position == 2){
            return (secondPos & in) == 64;
        } else if(position == 3){
            return (thirdPos & in) == 32;
        } else if(position == 4){
            return (fourthPos & in) == 16;
        } else if(position == 5){
            return (fifthPos & in) == 8;
        } else if(position == 6){
            return (sixthPos & in) == 4;
        } else if(position == 7){
            return (seventhPos & in) == 2;
        } else if(position == 8){
            return (eighthPos & in) == 1;
        } else {
            throw new Error("Invalid position to check bit! pos: " + position);
        }
    }

}
