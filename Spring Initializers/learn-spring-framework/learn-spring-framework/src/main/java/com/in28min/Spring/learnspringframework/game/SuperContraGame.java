package com.in28min.Spring.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Primary
public class SuperContraGame implements GamingConsole {
	
	public void up() {
		System.out.println("SuperContraGame up");
	}
	
	public void down() {
		System.out.println("SuperContraGame down");
	}
	
	public void right() {
		System.out.println("SuperContraGame left");
	}
	
	public void left() {
		System.out.println("SuperContraGame right");
	}
}
