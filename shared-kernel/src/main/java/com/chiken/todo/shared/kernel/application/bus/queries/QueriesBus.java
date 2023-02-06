package com.chiken.todo.shared.kernel.application.bus.queries;

public interface QueriesBus<R extends QueryResponse> {

	R ask(Query query);
	
}
