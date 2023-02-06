package com.chiken.todo.shared.kernel.application.bus.events;

public interface EventHandler {
	
	void handle(Event event);

}
