package com.chiken.todo.bc.bus.commands.application;

import com.chiken.todo.shared.kernel.application.bus.commands.CommandsBus;
import com.chiken.todo.shared.kernel.application.bus.commands.CommandsBusProvider;

public class PureJavaCommandsBusProvider implements CommandsBusProvider {

	@Override
	public CommandsBus create() {
		return new PureJavaCommandsBus();
	}

}
