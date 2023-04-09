package genericLibrary;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class javaUtility {

	/**
	 * This method is used to generate random number
	 * @param limit
	 */
	public void randomNumber(int limit) {
		Random r = new Random();
		int randomNum = r.nextInt(limit);
	}
	
	/**
	 * This method is used to get current Date and Time in a specified format
	 * @return
	 */
	public String getCurrentDateTime() {
		java.util.Date d = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String currentTime = sdf.format(d);
		return currentTime;

	}
}
