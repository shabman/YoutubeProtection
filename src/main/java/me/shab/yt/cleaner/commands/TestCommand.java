package me.shab.yt.cleaner.commands;

import me.shab.yt.cleaner.templates.Command;

public class TestCommand extends Command {

	@Override
	public void register() {
		System.out.println("hello world lol!");
	}

	@Override
	public void register(Object... args) {
		
	}

	@Override
	public String getName() {
		return "test";
	}
}
