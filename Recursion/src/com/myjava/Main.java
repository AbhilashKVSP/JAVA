package com.myjava;

import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

class Recursion{

    public void factorial(int num, int fact) {
        if (num < 1) {
            System.out.println("Factorial value is: " + fact);
            return;
        }
        fact= fact* num;
        factorial(num-1,fact);
    }


    public void fibanoci(int first, int second,int c ) {
        if (c==0) {
            return;
        }
        int val =first+second;
        System.out.print(val+" ");
        fibanoci(second,val,c-1);
    }

    public int xpown(int x, int n ) {
        if (n == 0) {
            return 1;
        }
        else if(n%2==0){
            x = xpown(x, n/2) * xpown(x, n/2);
            return x;
        }
        else{
            x = x* xpown(x, n/2) * xpown(x, n/2);
            return x;
        }
    }

    public void towerofHanoi(int blocks, String source, String helper, String destination){
        if(blocks==1){
            System.out.println("Transfer " + blocks + "from " + source + "To " + destination );
            return;
        }
        towerofHanoi(blocks-1,source,destination,helper);
        System.out.println("Transfer " + blocks + "from " + source + "To " + destination );
        towerofHanoi(blocks-1,helper,source,destination);
    }

    public void reverseString ( String str){
        if(str==""){
            return;
        }
        System.out.print(str.charAt(str.length()-1));
        reverseString(str.substring(0,str.length()-1));
    }

    public void getElementRange(String str,int first,int last,char x){
        if(str == ""){
            System.out.println("First find is at index" + first);
            System.out.println("Last find is at index" + last);
            return;
        }
        if(str.charAt(str.length()-1) == x){
            if(last >0){
                first = str.length()-1;
            }
            else{
                last = str.length()-1;
            }
        }
        getElementRange(str.substring(0,str.length()-1),first,last,x);
    }
    static boolean flag = true;
    public void checkStrictInc(int[] arr, int idx){
        if(idx==1){
            System.out.println("It is strictly Inc");
            return;
        }
        else if(arr[idx-1] <= arr[idx-2] ){
            flag = false;
            System.out.println("It is not strictly Inc");
            return;
        }
        else checkStrictInc(arr,idx-1);
    }

    static String strNew = "";
    static int count = 0;
    public void pushChar(String str, int idx, char x){
        if(idx == str.length()){
            for (int i=0; i< count; i++){
                strNew+=x;
            }
            System.out.println("Output after the push is " + strNew);
            return;
        }

        if(str.charAt(idx) == x){
            count++;
        }
        else{
            strNew+=str.charAt(idx);
        }
        pushChar(str,idx+1,x);
    }

    static String strNew2 ="";
    boolean[] map = new boolean[26];
    public void removeDuplicates(String str, int idx){
        if(idx == str.length()){
            System.out.println("Output after removing duplicates is " + strNew2);
            return;
        }
        if(map[str.charAt(idx)-'a'] == false){
            strNew2+=str.charAt(idx);
            map[str.charAt(idx)-'a'] = true;
        }
        removeDuplicates(str,idx+1);
    }

    public void subSeq(String str, int idx, String newStr, HashSet<String> set){
        if(idx == str.length()) {
            if (set.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }
        char current = str.charAt(idx);
        // Choose it to come
        subSeq(str,idx+1,newStr+current,set);

        //choose it not to come
        subSeq(str,idx+1,newStr,set);
    }

    public static String[] keyPad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public void printComb(String str, int index, String combination){
        if(index == str.length()){
            System.out.println(combination);
            return;
        }
        char current =str.charAt(index);
        String keyString =keyPad[current-'0'];
        for(int k=0; k< keyString.length();k++){
            // Add the char
            printComb(str, index+1, combination+keyString.charAt(k));
        }
    }

    public void printPerm(String str, String perm){
        if(str.length()== 0){
            System.out.println(perm);
            return;
        }
        for (int i=0; i< str.length(); i++){
            char current = str.charAt(i);
            // abc => bc
            String newStr = str.substring(0,i) + str.substring(i+1);
            printPerm(newStr,perm+current);
        }
    }

    public int countPaths(int i, int j, int m, int n){
        if(i==m || j ==n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        int downPaths =countPaths (i,j+1,m,n);
        int rightPaths = countPaths (i+1,j,m,n);
        return downPaths+rightPaths;
    }

    public int placeTiles(int n, int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        // when n>m
        int vertPlacements =placeTiles (n-m,m);
        int horPlacements =placeTiles (n-1,m);
        return vertPlacements+horPlacements;
    }
    public int callGuests(int n){
        if(n<=1){
            return 1;
        }
        int singleCall =callGuests (n-1);
        int pairCall =(n-1)*callGuests (n-2);
        return singleCall+pairCall;
    }

    public static void printSubSet(ArrayList<Integer> subSet){
        for(int i=0;i<subSet.size();i++){
            System.out.print(subSet.get(i)+ " ");
        }
        System.out.println();
    }
    public void getSubSets (int n, ArrayList<Integer> subSet){
        if(n==0){
            printSubSet(subSet);
            return;
        }
        // add ele to subset
        subSet.add(n);
        getSubSets(n-1,subSet);
        // cannot add ele to subSet
        subSet.remove(subSet.size()-1);
        getSubSets(n-1,subSet);

    }
    // N-Queen Problem

    public void saveBoard(char[][] board,List<List<String>> allBoards){
        String row = "";
        List<String> newboard = new ArrayList<>();
        for(int i=0; i< board.length;i++){
            row="";
            for(int j=0; j<board[0].length;j++){
                if(board[i][j] == 'Q') row+="Q";
                else row+=".";
            }
            newboard.add(row);
        }
        allBoards.add(newboard);
    }
    public boolean isSafe(int row, int col,char[][] board){
        // Horizontal Check
        for (int j=0; j<board.length;j++) {
            if (board[row][j] == 'Q') return false;
        }
        // Vertical Check
        for(int i=0; i<board.length;i++){
            if (board[i][col] == 'Q') return false;
        }
        // upper left check
        int r= row;
        for(int c=col; c>=0 && r>=0;c--,r--){
            if (board[r][c] == 'Q') return false;
        }
        // upper right check
        r= row;
        for(int c=col; c<col && r>=0;c++,r--){
            if (board[r][c] == 'Q') return false;
        }
        // down left check
        r= row;
        for(int c=col; c>=0 && r<board.length;c--,r++){
            if (board[r][c] == 'Q') return false;
        }
        // down right check
        r= row;
        for(int c=col; c< board.length && r<board.length;c++,r++){
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }
    public void placeQueen(char[][] board,List<List<String>> allBoards, int col ){
        if(col == board.length){
            saveBoard(board,allBoards);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                placeQueen(board,allBoards,col+1);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> NQueen(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        placeQueen(board, allBoards,0);
        return allBoards;
    }
}
public class Main {

    public static void main(String[] args) {
        Recursion rec = new Recursion();
        // Factorial of an integer n
        rec.factorial(12, 1);
        // Fibonacci to an integer n
        System.out.print("0 "+ "1 ");
        int n = 5;
        rec.fibanoci(0,1,n-2);
        // x power n
        System.out.println("\n" +rec.xpown(2,n));
        // Tower of Hanoi
        rec.towerofHanoi(4,"Tower1", "Tower2", "Tower3");
        rec.reverseString("abcdefgh");
        System.out.println();
        rec.getElementRange("abadae",-1,-1,'a');
        int arr[] = {1,2,12,12,92,95};
        rec.checkStrictInc(arr,arr.length);
        rec.pushChar("axbxcdxxefx",0,'x');

        // Remove Duplicates
        rec.removeDuplicates("axbxcdxxefx", 0);
        // SubSeq of unique
        HashSet<String> set = new HashSet<>();
        rec.subSeq("aaa",0,"",set);

        //KeyPad
        rec.printComb("421",0,"");

        //Print Permutations
        rec.printPerm("abc","");

        // total paths from one point to another in matrix only permitting right or down
        System.out.println(rec.countPaths(0,0,3,4));
        // total ways to place tiles of 1Xm on nXm floor
        System.out.println(rec.placeTiles(4,3));
        // total ways to call n guests single or in pairs
        System.out.println(rec.callGuests(3));

        ArrayList<Integer> subsets = new ArrayList<>();
        System.out.println("Subsets of first natural numbers of size");
        rec.getSubSets(4,subsets);

        // Backtracking - NQueen Problem
        System.out.println(rec. NQueen(4));


    }
}
