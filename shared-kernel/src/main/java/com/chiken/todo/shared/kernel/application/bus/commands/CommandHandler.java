package com.chiken.todo.shared.kernel.application.bus.commands;

public interface CommandHandler<C extends Command> {

	void handle(final C command);

	boolean isHandable(final C command);
	
}
