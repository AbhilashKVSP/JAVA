package com.in28min.Spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28min.Spring.learnspringframework.enterprise.example.web.MyWebController;
import com.in28min.Spring.learnspringframework.game.*;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
	
		//MarioGame game = new MarioGame();
		//PacManGame game = new PacManGame();
		//SuperContraGame game = new SuperContraGame();
		
		//GamingConsole game = new MarioGame();
		//GameRunner runner = new GameRunner(game);
		
		ConfigurableApplicationContext context =
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}
}
