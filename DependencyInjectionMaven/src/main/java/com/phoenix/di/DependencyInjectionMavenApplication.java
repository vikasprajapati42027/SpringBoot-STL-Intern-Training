package com.phoenix.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.phoenix.di.performers.Performer;

@SpringBootApplication
public class DependencyInjectionMavenApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionMavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		for (String arg : args)
			System.out.println(arg);

		Performer p = context.getBean("Pyaare_Raghav", Performer.class);

		p.perform();

	}

}
