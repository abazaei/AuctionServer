package com.example.auctionapplicationIntermed;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateParser {
	public static Date parse(String toParse){

		Calendar cal = null;
		Date d = null;

		Pattern patternex = Pattern.compile("(\\d{1,2})(.|\\/)(\\d{1,2})(.|\\/)(\\d{4})");
		if(Pattern.matches(patternex.pattern(), toParse))
		{
			toParse = toParse.replaceAll(patternex.pattern(), "$1-$3-$5");
			d = splitPattern(toParse);
		}
		else if(Pattern.matches("([1-9])-(\\d{4})", toParse)){
			toParse = toParse.replaceAll("([1-9])-(\\d{4})", "$1-01-$2");
			d = splitPattern(toParse); 	
		}
		else if(Pattern.matches("([a-zA-Z]{3,9})\\s(\\d{1,2})\\,?\\s(\\d{4})",toParse)){
			toParse = toParse.replaceAll("([a-zA-Z]{3,9})\\s(\\d{1,2})\\,?\\s(\\d{4})", "$1-$2-$3");
			
			
		
//			if(toParse.equals("Jan") || toParse.equals("January")){
//				
//			}
			
			String[] splitstrings = toParse.split("-");
			cal = Calendar.getInstance();
			
			cal.set(Calendar.DATE, Integer.parseInt(splitstrings[1]));
			cal.set(Calendar.YEAR, Integer.parseInt(splitstrings[2]));
		
			
			String months[] =
			    {
			        "January" , "February" , "March" , "April", "May",
			        "June", "July", "August", "September", "October",
			        "November", "December"
			    };
			for (int i = 0; i < months.length; i++) {
				if(months[i].contains(splitstrings[0])){
					cal.set(Calendar.MONTH, i);
					break;
				}
			}
			d = cal.getTime();
			
			
		}
		return d;

	}

	private static Date splitPattern(String toParse) {
		Calendar cal;
		Date d;
		String[] splitstrings = toParse.split("-");
		cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(splitstrings[0])-1);
		cal.set(Calendar.DATE, Integer.parseInt(splitstrings[1]));
		cal.set(Calendar.YEAR, Integer.parseInt(splitstrings[2]));
		d = cal.getTime();
		return d;
	}

	public static String format(Date toFormat){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		return sdf.format(toFormat);

	}

	public static String formatTimeUntil(Date endDate){

		long diff = endDate.getTime() - new Date().getTime() ;
		
		long diffSeconds =  (1000);  
		long diffMinutes = (60 * 1000);
		long diffHours =  (60 * 60 * 1000);
		long diffDay =  (24 * 60 * 60 * 1000); //hours, minutes, seconds, millis
		long Day = diff / diffDay;
		diff = diff % diffDay;
		long Hours = diff / diffHours;
		diff = diff % diffHours;
		long Minutes = diff / diffMinutes;
		diff = diff % diffMinutes;
		long Seconds = diff / diffSeconds;
		diff = diff % diffSeconds;
		
		
		//compares today to the end date
		
		return Day +" Days "+ Hours+" Hours "+Minutes+" Minutes "+Seconds+" Seconds"; //returns .. X days y hours z min blah blah
	}

}
