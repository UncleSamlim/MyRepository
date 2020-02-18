package cn.tocean.com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Config {
	private  Properties  properties = new  Properties();
	public Config(String fileName){
		try {
			InputStream in = new FileInputStream(fileName);
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String get(String key) {
		String value = properties.getProperty(key);
		return value;
	}
}
