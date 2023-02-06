package com.chiken.todo.bc.bus.commands.application;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chiken.todo.shared.kernel.annotations.Service;
import com.chiken.todo.shared.kernel.application.bus.commands.Command;
import com.chiken.todo.shared.kernel.application.bus.commands.CommandHandler;
import com.chiken.todo.shared.kernel.application.bus.commands.CommandsBus;

@Service
public class PureJavaCommandsBus implements CommandsBus {

	private final Logger logger = LoggerFactory.getLogger(PureJavaCommandsBus.class);
	
	private final Collection<CommandHandler> handlers;
	
	public PureJavaCommandsBus() {
		this.logger.trace("** PureJavaCommandsBus() **");
		this.handlers = new HashSet<>();
	}
	
	@Override
	public void dispatch(final Command command) {
		
		this.logger.trace("-> PureJavaCommandsBus.handle({})", command);
		
		final Stream<CommandHandler> handlerMatches = this.handlers
				.stream()
				.filter(handler -> handler.isHandable(command));
		
		if(handlerMatches.count() > 1) {
			throw new IllegalStateException("find more than one command handler");
		}
		
		if(handlerMatches.count() < 1) {
			throw new IllegalStateException("find less than one command handler");
		}

		handlerMatches
				.findAny()
				.ifPresent(handler -> handler.handle(command));
		
		this.logger.trace("<-- PureJavaCommandsBus.handle({})", command);
	}
	
	@Override
	public void register(final CommandHandler commandHandler) {
		this.logger.trace("-> PureJavaCommandsBus.register({})", commandHandler);
		this.handlers.add(commandHandler);
		this.logger.trace("<-- PureJavaCommandsBus.register({})", commandHandler);
	}
	
}
