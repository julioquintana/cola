package com.qs.cola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
public class ColaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaApplication.class, args);
		run();
	}

	
	public static void run () {
		ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
      MyBean bean = context.getBean(MyBean.class);
      bean.runTasks();
      ThreadPoolTaskExecutor t = context.getBean(ThreadPoolTaskExecutor.class);
      t.shutdown();
		
	}
}
