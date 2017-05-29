package com.kiwilandrailways;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) throws IOException {
		Map<String, String> argParams = extractArguments(args);
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ApplicationInitializer initializer = (ApplicationInitializer) ctx.getBean(ApplicationInitializer.class);
		initializer.init(argParams);
	}
	
	public static Map<String, String> extractArguments(String[] args) {
		Map<String, String> aMap = new HashMap<String, String>();
		for (String arg : args) {
			String[] a = arg.split("=",2);
			aMap.put(a[0], a[1]);
		}
		
		return aMap;
	}
}
