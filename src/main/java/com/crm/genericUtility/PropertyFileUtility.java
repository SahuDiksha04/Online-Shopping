package com.crm.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * This method is used to read data from property file
	 * @author CHINMAY
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

	
	

	
	

}
