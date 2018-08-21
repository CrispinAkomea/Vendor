package com.caa.vendor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

	private static String database;

	/**
	 * 
	 * Static initialization block loads the database configuration property from
	 * the properties file located in the resources folder.
	 * 
	 * Use the app.cfg.xml file to keep any other general application configurations
	 * you need. Create the fields and load them in the try block in other class.
	 * 
	 */
	static {
		Properties properties = new Properties();
		try (InputStream config = App.class.getClassLoader().getResourceAsStream("app.cfg.xml")) {
			properties.loadFromXML(config);
			database = properties.getProperty("connection.url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDatabase() {
		return database;
	}

}
