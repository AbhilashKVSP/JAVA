package com.myjava;
import MyBank.*;

class Pen{
    String color;
    String type; // ball point, Gel

    public void action(){
        System.out.println("Write something..");
    }
    public void colorReturn(){
        System.out.println(this.color);
    }
}
class Student{
    String name;
    int age;

    // Polymorphism

    public void printInfo( String name){
        System.out.println(this.name);
    }
    public void printInfo( int age){
        System.out.println(this.age);
    }
    public void printInfo( String name, int age){
        System.out.println(this.name + " " + this.age);
    }
    Student(){
        System.out.println("Constructor Called");
    }
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    Student(Student s){
        this.name = s.name;
        this.age = s.age;
    }
}

// Inheritance

class Shape{
    String color;
}
class Triangle extends Shape{

}

class MyBankHere extends MyBank{
    public void outHere(){
        this.accDetails ="12345";
    }
}

class testStatic{
    public int number1;
    static int number2;
    public void setNumbers(int n1, int n2){
     this.number1 = n1;
     this.number2 =n2;
    }
    static void setStaticNumbers(int n1){
        number2 =n1;
    }

}
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Harry";
        s1.age = 30;
        s1.printInfo("Harry",30);

        Student s2 = new Student("Abhilash", 26);
        s2.printInfo(s2.name);

        Student s3 = new Student(s2);
        s3.printInfo(s3.age);

        Pen pen2 = new Pen();
        pen2.color = "Red";
        pen2.type = "Gel";
        pen2.colorReturn();

        Triangle t1 = new Triangle();
        t1.color = "Red";

        // Package import use
        Account acc = new Account();
        acc.holderName = "1234567890";
//        acc.bankDetails = "1234";
        acc.printInfo();

        testStatic ts = new testStatic();
        ts.setStaticNumbers(10);
        ts.setNumbers(20,30);
        System.out.println(ts.number1 + " " + testStatic.number2);
    }
}
