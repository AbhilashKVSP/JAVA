package com.in28min.Spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {
	
	public void up() {
		System.out.println("jump");
	}
	
	public void down() {
		System.out.println("down into a hole");
	}
	
	public void right() {
		System.out.println("accelerate");
	}
	
	public void left() {
		System.out.println("stop");
	}
}
