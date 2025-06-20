package com.myjava;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Output Function
        *System.out.println("This would add a new line after it finishes");
        *System.out.print("This would not add a new line after it finishes.");
        *System.out.print("S OUT is used for shortcut of print statement.");
        */
        // Variables
        byte age = 30;
        int phone = 1234567890;
        long phone2 = 12345678900L;
        float pi = 3.14F;
        char letter = '@';
        boolean isAdult = true;
        final float PI = 3.1414F; // Constant cannot be changed

        // strings

        String name1 = new String("Harry");
        String name2 = new String("Potter");
        System.out.println(name1.length());
        System.out.println(name1 + name2);
        String name3 = new String(name1.replace('a','b'));
        System.out.println(name3);
        System.out.println(name2.substring(0,3));

        // Arrays

        int[] marks =new int[3];
        marks[0] =99; marks[1] =97; marks[2] =98;
        System.out.println(marks.length);
        System.out.println(marks[0]);
        Arrays.sort(marks);
        System.out.println(marks[0]);
        int[][] finalMarks ={{97,98,95},{97,100,92}};
        System.out.println(finalMarks[1][1]);

        // Explicit casting

        int price = 100 +(int)18.98;
        System.out.println(price);

        // Operators
        System.out.println(10+12);

        int num = 10;
        int num1 = num++;
        int num2 = ++num;
        System.out.println(num);
        System.out.println(num1);
        System.out.println(num2);

        System.out.println((int)(Math.random()*100));

        // How to Take an input?
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Age");
        int ageNew = sc.nextInt();
        System.out.println(ageNew);
        System.out.println("Enter your Name");
        String myName = new String(sc.nextLine());
        System.out.println(myName);

        // Conditional Statements

        boolean isSunUp = true;
        if(isSunUp){
            System.out.println("Day");
        }
        else System.out.println("Night");
    }
}
