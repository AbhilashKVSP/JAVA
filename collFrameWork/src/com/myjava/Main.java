package com.myjava;
import java.util.ArrayList;
import java.util.Collections;

class CollFrameWork{
    public void intAL(){
        ArrayList<Integer> intAL = new ArrayList<>();
        // Add elements
        intAL.add(0);
        intAL.add(2);
        System.out.println(intAL);
        //Get elements
        System.out.println(intAL.get(0));
        //Add elements in between
        intAL.add(1,1);
        System.out.println(intAL);
        //Set Element
        intAL.set(0,5);
        System.out.println(intAL);
        //Delete Element
        intAL.remove(2);
        System.out.println(intAL);
        System.out.println(intAL.size());
        // loop
        for(int i=0; i< intAL.size();i++){
            System.out.print(intAL.get(i) + " ");
        }
        System.out.println();
        // Sorting
        Collections.sort(intAL);
        System.out.println(intAL);
    }
}
public class Main {

    public static void main(String[] args) {
        CollFrameWork clfw = new CollFrameWork();
        clfw.intAL();
    }
}
