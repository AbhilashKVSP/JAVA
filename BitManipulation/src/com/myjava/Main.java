package com.myjava;

import java.util.Scanner;

class BitManipulator {
    public StringBuilder Dec2Binary(int i) {
        StringBuilder res = new StringBuilder("");
        if (i == 0) {
            res.append("0");
            return res;
        }
        while (i != 1) {
            res.append(i % 2);
            i /= 2;
        }
        res = res.reverse();
        res.insert(0, '1');
        return res;
    }

    public int Binary2Dec(StringBuilder bool) {
        int res = 0;
        int pow= 0;
        for (int i = bool.length() - 1; i >= 0; i--) {
            if (bool.charAt(i) == '1') {
                res += Math.pow(2, pow);
            }
            pow++;
        }
        return res;
    }

    // Get Bit
    public int getChar(int num, int pos) {
        int bitMask = 1<<pos;
        int res = num & bitMask;
        if(res == 0){ return 0;}
        else{return 1;}
    }
    public int toggleChar (int num, int pos) {
        int ch = this.getChar(num,pos);
        int bitMask = 1<<pos;
        int res;
        // clear Bit
        if(ch ==1){
            int newBitMask = ~bitMask;
            res = num & newBitMask;
        }
        // Set Bit
        else{
            res = num | bitMask;
        }
        return res;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first number");
        int num1 = sc.nextInt();
        BitManipulator bM = new BitManipulator();
        StringBuilder binary1 = new StringBuilder(bM.Dec2Binary(num1));
        System.out.println("The Binary format is " +binary1 );
        System.out.println("The Decimal format is " +bM.Binary2Dec(binary1) );
        System.out.println("Provide the bit position to display and toggle");
        int pos = sc.nextInt();
        System.out.println("The bit - " + pos + " of binary is" + bM.getChar(num1,pos));
        int toggledNum = bM.toggleChar(num1,pos);
        StringBuilder binary2 = new StringBuilder(bM.Dec2Binary(toggledNum));
        System.out.println("The Toggled Binary is" + binary2 );
        System.out.println("The Toggled Decimal is" + bM.Binary2Dec(binary2) );
    }
}
