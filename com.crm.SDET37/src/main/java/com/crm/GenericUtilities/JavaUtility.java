package com.crm.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author santu
 *
 */
public class JavaUtility {
	/**
	 * To get randomNumber
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomnum = random.nextInt(1000);
		return randomnum;
	}
	/**
	 * To get dateformate
	 * @return
	 */
	public String getDateTime()
	{
		Date date = new Date();
		String currentdate = date.toString();
		System.out.println(currentdate);
		String[] currentdatearr = currentdate.split("");
		String year =currentdatearr[5];
		String dd=currentdatearr[2];
		String month=currentdatearr[1];
		String formate=year+""+month+""+dd;
		return formate;
	}

}
