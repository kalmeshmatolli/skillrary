package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFileUtility {

	private Properties property;
	
	/**
	 * This method is used to Initialize the Property file
	 * 
	 * @param filePath
	 */
	public void propertyConfg(String filePath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		property = new Properties();

		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Fetch the properties from property file
	 * @param key value
	 * @return String value
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
	
	/**
	 * This method is used to Write the data into Property file
	 * @param key
	 * @param value
	 * @param filePath
	 * @param message
	 */
	public void setDataToProperty(String key, String value, String filePath, String message) {
		property.put(key, value);
		
		try {
			property.store(new FileOutputStream(filePath), message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
