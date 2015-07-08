package de.tudresden.parsers;

import com.google.gson.Gson;

import de.tudresden.businessobjects.Sample;

public class PropertyJsonParser {
	private static Gson gson = new Gson();
	
	/*
	 * Return only Sample objects
	 * 
	 * If the line is not well formed, return null
	 */
	public static Sample parseLine(String line) {
		if(!line.startsWith("{")){
			return null;
		}
		try {
			return gson.fromJson(line, Sample.class);
		} catch (Exception e) {
		}
		
		return null;
	}

}
