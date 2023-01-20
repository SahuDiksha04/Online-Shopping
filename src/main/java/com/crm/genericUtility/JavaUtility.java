opackage com.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNo()
	{
		Random r = new Random();
		int random = r.nextInt();
		return random;

	}
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		date=date.replaceAll(":", ",");
		return date;
	}
	
	public String getSystemDateAndTimeInFormat()
	{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
		Date systemdate = new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":", "-");
	}

}
