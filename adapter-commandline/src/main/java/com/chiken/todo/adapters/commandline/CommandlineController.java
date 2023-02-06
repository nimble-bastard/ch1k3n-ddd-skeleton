package com.chiken.todo.adapters.commandline;

import java.util.Objects;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import picocli.CommandLine;
import picocli.CommandLine.Option;

@Component
@CommandLine.Command(name = "Todo CLI", mixinStandardHelpOptions = true, version = "todo-cli-1.0", description = "Todo CLI Project")
public class CommandlineController implements Callable<Integer> {

	@Option(
				  names = {"-h", "--help"}
				, paramLabel = "help"
				, description = "help"
			)
	private String help;
	
	@Override
	public Integer call() throws Exception {

		if(!Objects.isNull(help)) {
			
		}
		
		return null;
	}

}
