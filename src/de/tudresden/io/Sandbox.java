package de.tudresden.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import de.tudresden.businessobjects.Property;
import de.tudresden.businessobjects.Sample;
import de.tudresden.parsers.PropertyJsonParser;

public class Sandbox {
	
	public static void testParser(){
		final String INPUT_FILE_PATH = "/home/rodrigo.lins/personal/git/master_arduino/assets/real_data.sample";
		File file = new File(INPUT_FILE_PATH);
		Gson gson = new Gson();
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			try {
				String line = null;
				while((line = input.readLine()) != null){
					Sample sample = PropertyJsonParser.parseLine(line);
					System.out.println("Print sample: " + sample);
					System.out.println("Print line: " + line);
				}
			} finally {
				input.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("There was a problem reading the file.");
		}
	}
	
	public static void testGson(){
		Property prop1 = new Property();
		prop1.setName("distance");
		prop1.setValue(12.00);
		prop1.setUnit("cm");
		Sample sample1 = new Sample();
		sample1.setId(6);
		sample1.setType("temperature");
		sample1.setModel("HC-SR04");
		List<Property> properties = new ArrayList<Property>();
		properties.add(prop1);
		sample1.setProperties(properties);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(sample1));
	}

	public static void main(String[] args) {
		testParser();
//		testGson();
	}
}
