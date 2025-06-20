package com.myjava;

public class MyException extends Exception{
    @Override
    public String toString() {
        return "Welcome to MyException. This is default";
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public String NegativeRadiusException(){
        return "We cannot have radius as Negative";
    }
}
