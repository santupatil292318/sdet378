package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author santu
 *
 */
public class FileUtility {
	/**
	 * To fetch the data in properties
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String fetchTheDataFrompropertyFile(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IConstants.filePath);
		Properties property = new Properties();
		property.load(file);
		String value = property.getProperty(key);
		return value;
	}
}
