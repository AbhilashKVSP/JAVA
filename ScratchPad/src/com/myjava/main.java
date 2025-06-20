package com.myjava;

import java.util.*;

class Solution {

	public static void main(String[] args) {
		int res = strStr("delulu","lulu");
		System.out.println(res);
	}
	
	public static int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        else {
        	for(int i=0; i<= haystack.length() - needle.length(); i++) {
        		if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        	}
        }
        return -1;
    }
}


