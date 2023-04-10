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
	
	public String read_URL() {
		String url = prop.getProperty("base_URL");
		System.out.println(url);
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");

	}
	
	public String readPageTitle() {
		String title = prop.getProperty("pageTitle");
		if(title != null) return title;
		else throw new RuntimeException("Page Title not specified in the Configuration.properties file.");
	}

	public String readSearchkeyword() {
		String keyword = prop.getProperty("SearchKeyword");
		if(keyword != null) return keyword;
		else throw new RuntimeException(" Search Keywords not specified in the Configuration.properties file.");
	}
	
	public String readSize() {
		String size =prop.getProperty("Size");
		if(size != null) return size;
		else throw new RuntimeException(" product size not specified in the Configuration.properties file.");
	}

	}
	

