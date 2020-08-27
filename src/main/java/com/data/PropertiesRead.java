package com.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead
{
	public Properties RequiredData () throws IOException, Exception
	
	{
		Properties obj = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//Properties//Required.properties");
		obj.load(file);
		return obj;

	}

}
