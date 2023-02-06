package com.chiken.todo.adapters.commandline;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chiken.todo.shared.kernel.application.bus.commands.Command;

public class CommandlineTransformer {

	private final Logger logger = LoggerFactory.getLogger(CommandlineTransformer.class);
	
	public CommandlineTransformer() {
		this.logger.trace("** CommandlineTransformer()");
	}
	
	public Command transform(final String input) {
		
		this.logger.trace("-> CommandlineTransformer.transform({})", input);

		final Pattern pattern = Pattern.compile("add ");
		
		pattern.matcher(input);
		
		final Command command = null;
		
		this.logger.trace("<-- CommandlineTransformer.transform({}): {}", input, command);
		
		return command;
	}


}
