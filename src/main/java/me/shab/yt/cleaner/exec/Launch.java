package me.shab.yt.cleaner.exec;

public class Launch {
	
	private static final String[][] CLI_COMMANDS = {
			{"help", "\t\t\tShows this.\n\n"},
			{"removeNsfw", "\t\tRemoves any NSFW/Suspicious links from the comment section. Also checks if the User's PFP is NSFW.\n\n"},
			{"removeLinks", "\t\tRemoves any links sent into the comments section.\n\n"},
			{"removeFakes", "\t\tRemoves popular fake account trends. (E.g) The fake verified Mr Beast accounts.\n\n"},
			{"removeAll", "\t\tRemoves all: NSFW, Links and Fakes from t he comment section\n\n"}
	};
	
	public static void main(String[] args) {
		String command = args[0].toLowerCase();
		if (command.equalsIgnoreCase(CLI_COMMANDS[0][0])) {
			for (int i = 0; i < CLI_COMMANDS.length - 1; i++) {
				System.out.print(CLI_COMMANDS[i][0] + CLI_COMMANDS[i][1]);
			}
		}
	}
}
