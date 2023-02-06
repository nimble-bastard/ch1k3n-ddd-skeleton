package com.chiken.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.chiken.todo.shared.kernel.annotations.Service;

@SpringBootApplication
@ComponentScan(
	    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	    value = {"com.chiken.todo", "com.chiken.todo.adapters.commandline"}
	)
public class Starter {

	private static final Logger logger = LoggerFactory.getLogger(Starter.class);

	public static void main(String[] args) {
		logger.trace("STARTING THE APPLICATION");
		SpringApplication.run(Starter.class, args);
		logger.trace("APPLICATION FINISHED");
	}

}
