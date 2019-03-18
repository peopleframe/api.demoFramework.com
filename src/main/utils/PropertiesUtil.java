package main.utils;

import java.util.Properties;

/**
 * This class is Invoke the values from Properties File
 * 
 * @author shaik
 *
 */
public class PropertiesUtil {

	public static String SignOnUrl;
	public static String BaseUrl;
	public static String Environment;
	public static String testURL;

	/**
	 * This method is used to read the properties from properties file
	 * 
	 */
	public void initProperties() {
		Properties properties = new Properties();
		try {
			properties = Common.getProperties(
					"C:\\Users\\Swathi\\Downloads\\API-RestAssure\\src\\test\\resources\\test.properties");

			Environment = properties.getProperty("test.env");

			SignOnUrl = properties.getProperty("test." + Environment.toLowerCase() + ".signOnUrl");

			BaseUrl = properties.getProperty("test." + Environment.toLowerCase() + ".baseUrl");
			testURL = properties.getProperty("test.Url");
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}
