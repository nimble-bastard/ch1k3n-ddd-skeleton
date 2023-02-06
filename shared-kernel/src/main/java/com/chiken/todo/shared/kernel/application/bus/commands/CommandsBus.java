package com.chiken.todo.shared.kernel.application.bus.commands;

public interface CommandsBus {

	void dispatch(Command command);

	void register(CommandHandler commandHandler);

}