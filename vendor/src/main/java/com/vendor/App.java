package com.vendor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

	private static String name;
	private static String database;

	/**
	 * 
	 * Static initialization block loads configuration properties from the
	 * properties file located in the resources folder.
	 * 
	 * Use the app.cfg.xml file to keep any other general application configurations
	 * you need. Create the fields and load them in the try-with-resource block.
	 * 
	 */
	static {
		Properties properties = new Properties();
		try (InputStream config = App.class.getClassLoader().getResourceAsStream("app.cfg.xml")) {
			properties.loadFromXML(config);
			name = properties.getProperty("app.name");
			database = properties.getProperty("connection.url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getName() {
		return name;
	}

	public static String getDatabase() {
		return database;
	}

}
