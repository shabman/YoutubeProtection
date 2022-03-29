package me.shab.yt.cleaner.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;

import java.util.stream.Stream;

import me.shab.yt.cleaner.templates.ParserType;

public class FileReader {

	private final InputStream path;

	private InputStreamReader file;	
	private FileParser parser;
	
	public FileReader(InputStream path) {
		this.path = path;
	}
	
	public Stream<String> getContents() throws IOException {
		this.file = new InputStreamReader(path, StandardCharsets.UTF_8);
		return new BufferedReader(this.file).lines();
	}
	
	public String convertFromPath(byte[] data) {
		return new String(data);
	}
	
	public String[] parse(Stream<String> in, ParserType parseType) {
		this.parser = new FileParser(in);
		if (parseType == ParserType.API_CRED) {
			return this.parser.readApiCreds();
		} else if (parseType == ParserType.NORMAL) {
			return this.parser.readNormal();
		}
		return null;
	}
	
	public InputStream getPath() {
		return this.path;
	}
	
	public InputStreamReader getFile() {
		return this.file;
	}
}
