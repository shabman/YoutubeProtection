package me.shab.yt.cleaner.exec;

import java.io.IOException;

import javax.swing.JOptionPane;

import me.shab.yt.cleaner.commands.TestCommand;
import me.shab.yt.cleaner.commands.manager.CommandManager;
import me.shab.yt.cleaner.parser.FileReader;
import me.shab.yt.cleaner.templates.Command;
import me.shab.yt.cleaner.templates.ParserType;

public class Launch {
	
	private static final String[][] CLI_COMMANDS = {
			{"help", "\t\t\tShows this.\n\n"},
			{"removeNsfw", "\t\tRemoves any NSFW/Suspicious links from the comment section. Also checks if the User's PFP is NSFW.\n\n"},
			{"removeLinks", "\t\tRemoves any links sent into the comments section.\n\n"},
			{"removeFakes", "\t\tRemoves popular fake account trends. (E.g) The fake verified Mr Beast accounts.\n\n"},
			{"removeAll", "\t\tRemoves all: NSFW, Links and Fakes from the comment section.\n\n"},
			{"apitok <token>", "\t\tSets the Youtube API Token which is required for connecting to YouTube.\n\n"}
	};
	
	public static void main(String[] args) {
		
		final FileReader read = new FileReader(ClassLoader.getSystemResourceAsStream("config/Creds.txt"));
		try {
			String[] data = read.parse(read.getContents(), ParserType.API_CRED);
			if (data[1].equalsIgnoreCase("null")) {
				JOptionPane.showMessageDialog(null, "Please set a Youtube API Token via command 'apitok <token>'", "ERROR", JOptionPane.ERROR_MESSAGE);				
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		final CommandManager manager = new CommandManager(new Command[] {new TestCommand()});
		
		String command = args[0].toLowerCase();
		if (command.equalsIgnoreCase(CLI_COMMANDS[0][0])) {
			for (int i = 0; i < CLI_COMMANDS.length - 1; i++) {
				System.out.print(CLI_COMMANDS[i][0] + CLI_COMMANDS[i][1]);
			}
		} else {
			manager.handle(command);
		}
	}
}
