package me.shab.yt.cleaner.templates;

public abstract class Command {
	
	public abstract void register();
	
	public abstract void register(Object...args);
	
	public abstract String getName();
	
}
