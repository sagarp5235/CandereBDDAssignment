package com.cucmber.assignment.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties prop;
	public  ReadConfig() {
		
		prop = new Properties();
		try {
			FileInputStream inputStream  = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("issue loading config file");
			e.printStackTrace();
		}
		
	}
	

	}
	

