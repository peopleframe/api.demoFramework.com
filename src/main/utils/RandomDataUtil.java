package main.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * This Class is used to generate dyanamic data
 * 
 * @author shaik
 *
 */
public class RandomDataUtil {

	Random random = new Random();
	Calendar calendar = Calendar.getInstance();

	/**
	 * this method is used to generate RandaomName
	 * 
	 * @return randomName
	 */
	public String generateRandomName() {
		String randomName = null;
		try {
			randomName = RandomStringUtils.randomAlphabetic(5);
		} catch (Exception exception) {
			System.out.println("Exception occured in generateRandomName :: " + exception.getMessage());
		}
		return randomName;
	}

	/**
	 * this method is used to generate Random PhoneNumber
	 * 
	 * @return phone
	 */
	public String generateRandomPhone() {
		String randomPhone = null;
		try {
			int random3DigitNo1 = random.nextInt(900) + 100;
			int random3DigitNo2 = random.nextInt(900) + 100;
			int random4DigitNo = random.nextInt(9000) + 1000;
			randomPhone = random3DigitNo1 + "-" + random3DigitNo2 + "-" + random4DigitNo;
		} catch (Exception exception) {
			System.out.println("Exception occured in generateRandomPhone :: " + exception.getMessage());
		}
		return randomPhone;
	}

	/**
	 * This method is used to generate tomorrow date
	 * 
	 * @param expectedDateFormat
	 *            Expected date format
	 * @return Tomorrow date
	 */
	public String generateTomorrowDate(String expectedDateFormat) {
		String tomorowsDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(expectedDateFormat);

			calendar.add(Calendar.DAY_OF_MONTH, 1);
			tomorowsDate = dateFormat.format(calendar.getTime());
		} catch (Exception exception) {
			System.out.println("Exception occured in generateTomorrowDate :: " + exception.getMessage());
		}
		return tomorowsDate;
	}

}
