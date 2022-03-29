package me.shab.yt.cleaner.commands.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.swing.JOptionPane;

import me.shab.yt.cleaner.templates.Command;

public class CommandManager {
	
	private final List<Command> commands = new ArrayList<>();
	
	public CommandManager(Command[] data) {
		for (Command cmd : data) {
			this.addCommand(cmd);
		}
	}

	public void addCommand (Command cmd) {
		boolean exists = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));
		
		if (exists) {
			JOptionPane.showMessageDialog(null, "Command is already registered!", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		this.commands.add(cmd);
	}
	
	@Nullable
	private Command getCommand(String cmd) {
		String search = cmd.toLowerCase();
		
		for (Command c : this.commands) {
			if (c.getName().equals(search)) {
				return c;
			}
		}
		return null;
	}
	
	public void handle(String cmd) {
		
		if (cmd.equalsIgnoreCase("help")) {
			JOptionPane.showMessageDialog(null, "The help command is managed automatically", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		String[] actions = cmd.toLowerCase().split("\s");
		Command invoke = this.getCommand(actions[0]);
		
		if (actions.length == 2)
			invoke.register(actions[actions.length - 1]);
		else
			invoke.register();
	}
}
