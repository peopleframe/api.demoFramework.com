package main.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This is the common class
 * 
 * @author shaik
 *
 */
public class Common {

	/**
	 * This method is used to Read Properties file
	 * 
	 * @param propertiesPath
	 *            Properties file path
	 * @return Properties
	 */
	public static Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(propertiesPath);
			properties.load(fileInputStream);
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return properties;
	}

	/**
	 * This method is used to Read Properties file
	 * 
	 * @param propertiesPath
	 *            Properties file path
	 * @return Properties
	 */
	public static String getPropertiesValue(Properties properties, String propertiesKey) {
		String propertiesValue = null;
		try {
			properties.getProperty(propertiesKey);
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return propertiesValue;
	}

	/**
	 * This method is used to Replace params
	 * 
	 * @param actualString
	 *            Actual string
	 * @param replaceParam
	 *            Replace param
	 * @param replaceParamValue
	 *            Replace param value
	 * @return finalString Final string
	 */
	public static String replaceParams(String actualString, String replaceParam, String replaceParamValue) {
		String finalString = null;
		try {
			finalString = actualString.replace(replaceParam, replaceParamValue);
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return finalString;
	}

}
