package com.in28min.Spring.learnspringframework.game;

public class PacManGame implements GamingConsole {
	
	public void up() {
		System.out.println("Go Straight Pac");
	}
	
	public void down() {
		System.out.println("Go Down Pac");
	}
	
	public void right() {
		System.out.println("Go Right Pac");
	}
	
	public void left() {
		System.out.println("Go Left Pac");
	}
}
