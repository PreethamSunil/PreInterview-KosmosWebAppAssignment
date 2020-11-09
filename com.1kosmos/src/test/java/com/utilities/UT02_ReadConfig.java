package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UT02_ReadConfig {

	public Properties prop;

	public UT02_ReadConfig() throws IOException {

		FileInputStream file = new FileInputStream("../com.1kosmos/config/config.properties");
		prop = new Properties();
		prop.load(file);
	}

	public String getUrl() {
		return prop.getProperty("url");

	}
	
	public String getbrowser() {
		return prop.getProperty("browser");

	}

}
