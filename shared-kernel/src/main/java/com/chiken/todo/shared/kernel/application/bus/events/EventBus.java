package com.chiken.todo.shared.kernel.application.bus.events;

public interface EventBus {

	void emit(Event event);

	void register(EventHandler eventHandler);

}