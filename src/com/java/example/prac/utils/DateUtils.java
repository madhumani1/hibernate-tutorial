/**
 * 
 */
package com.java.example.prac.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.taglibs.standard.tag.common.fmt.FormatDateSupport;

import java.text.ParseException;

/**
 * @author 15197
 * <b>Handling Dates with Hibernate</b>
 * Read date strings from the command-line and store them as dates in the database?
 */
public class DateUtils {
	/**
	 * The Date formatter
	 * dd: date in month (number)
	 * MM: month in year (number)
	 * yyyy: year
	 *
	 * https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
	 * 
	 */
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Read a date string and parse/convert to a date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException	{
		Date theDate = formatter.parse(dateStr);
		return theDate;
	}
	
	public static String formatDate(Date theDate)	{
		String result = null;
		if(theDate!=null)	{
			result=formatter.format(theDate);
		}
		return result;
	}
}
