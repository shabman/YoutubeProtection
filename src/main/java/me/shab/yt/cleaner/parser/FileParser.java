package me.shab.yt.cleaner.parser;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {
	
	private final Stream<String> contents;

	public FileParser(Stream<String> contents) {
		this.contents = contents;
	}
	
	protected String[] readApiCreds() {
		String fromLines = this.contents.collect(Collectors.joining("\n"));
		return fromLines.split("=");
	}
	
	protected String[] readNormal() {
		return null;
	}
	
	public Stream<String> getContents() {
		return this.contents;
	}
}
