package com.myjava;

class Circle{

    public double circumference(int r) throws MyException {
        if(r>=0){
            double cir = Math.PI * r* r;
            return cir;
        }
        else throw new MyException();
    }
}

public class Main {

    public static void main(String[] args) {
        try{
            double cuf = new Circle().circumference(-1);
            System.out.println(cuf);
        }
        catch (MyException ex){
            System.out.println(ex.NegativeRadiusException());
        }
    }
}
