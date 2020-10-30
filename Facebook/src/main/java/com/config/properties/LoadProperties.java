package com.config.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
private static Properties prop = null;
	
	public static void setProperties() throws IOException {
		FileInputStream fis = null;
		String configFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		try {
			fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
		}catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}catch(IOException exception) {
			System.out.println(exception.getMessage());
		}finally {
			fis.close();
		};
	}
	
	public static Properties getProperties() {
		return prop;
	}
}
