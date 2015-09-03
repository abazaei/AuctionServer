package com.example.auctionapplicationIntermed;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MoneyParser {
	public static BigDecimal parse (String parsestring){
		
		BigDecimal newval = null;
		
		Pattern patternex = Pattern.compile("\\$?(([0-9]\\d{0,}((,\\d{3})*)?(\\.\\d{1,2})?))");
		System.out.println(parsestring);
		if(Pattern.matches(patternex.pattern(), parsestring))
		{
			parsestring = parsestring.replaceAll(patternex.pattern(), "$1");
			parsestring = parsestring.replaceAll(",", "");
			parsestring = parsestring.replaceAll("null", "");
			newval = BigDecimal.valueOf(Double.valueOf(parsestring));
			
		}
		else
			System.out.println("Error In MoneyParser");
		//		\$?(([1-9]\d{0,2}(,\d{3})*(\.\d\d)?)|(([1-9]\d*)?\d))
		
		return newval;
	}
	public static String format (BigDecimal formatbd){
		
		DecimalFormat df = new DecimalFormat("###,###.00");
		
		
		return df.format(formatbd);
	}
}
