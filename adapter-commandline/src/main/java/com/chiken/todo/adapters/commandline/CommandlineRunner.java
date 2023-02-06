package com.chiken.todo.adapters.commandline;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;

import com.chiken.todo.shared.kernel.annotations.Service;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Service
public class CommandlineRunner implements CommandLineRunner, ExitCodeGenerator {

	private static final Logger logger = LoggerFactory.getLogger(CommandlineRunner.class);

	private final IFactory factory;
	
	private final Object commandlineController;
	
	private int exitCode;
	
	public CommandlineRunner(final IFactory factory, final CommandlineController commandlineController) {
		logger.trace("** CommandlineAdapter() **");
		this.factory = factory;
		this.commandlineController = commandlineController;
		this.exitCode = 1;
	}
	
	@Override
	public void run(final String... args) throws Exception {
		
		final String line = Optional
				.ofNullable(args)
				.stream()
				.flatMap(Arrays::stream)
				.reduce((a, b) -> a.concat(b))
				.orElseThrow();
		
		logger.trace("-> CommandlineAdapter.run({})", line);

		this.exitCode = new CommandLine(this.commandlineController, factory).execute(args);
		
		logger.trace("<-- CommandlineAdapter.run({})", line);
	}

	@Override
	public int getExitCode() {
		return exitCode;
	}
}
