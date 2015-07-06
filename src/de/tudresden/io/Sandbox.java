package de.tudresden.io;

import java.io.InputStream;

import com.google.gson.Gson;

public class Sandbox {

	public static void main(String[] args) {
		final String TEST = "{\"type\":\"temperature\",\"model\":\"LM35\",\"temperature\":22.95,\"unit\":\"celcilus\"}" +
//			"Doing something" +
			"{\"type\":\"push_button\",\"model\":\"generic\",\"state\":\"off\"}" +
//			"Doing something" +
			"{\"type\":\"hygrometer\",\"model\":\"DHT22\",\"humidity\":55.60,\"humidityUnit\":\"%\",\"temperature\":23.50,\"temperatureUnit\":\"celcius\",\"heatIndex\":25.12,\"heatIndexUnit\":\"celcius\"}" +
//			"Doing something" +
			"{\"type\":\"triaxial_accelerometer\",\"model\":\"MMA7361\",\"xAxis\":-4.67,\"xAxisUnit\":\"g\",\"yAxis\":-5.00,\"yAxisUnit\":\"g\",\"zAxis\":-5.00,\"zAxisUnit\":\"g\"}" +
//			"Doing something" +
			"{\"type\":\"motion\",\"model\":\"RE200B\",\"motion\":\"false\"}" +
//			"Doing something" +
			"{\"type\":\"ultrasonic\",\"model\":\"HC-SR04\",\"distance\":6,\"unit\":\"cm\"}";
//			"Doing something" +
//			"echo: echo echo!echo echo!echo echo!echo echo!echo echo!e";
		final String TEST2 = "{\"id\":5,\"type\":\"motion\",\"model\":\"RE200B\",\"properties\":{\"state\":{\"value\":\"true\",\"unit\":\"binary\"}}}";
		Gson gson = new Gson();
//		gson.fromJson(TEST2, classOfT)
		

	}
}
