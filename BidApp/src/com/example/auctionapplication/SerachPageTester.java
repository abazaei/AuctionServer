package com.example.auctionapplication;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.example.auctionapplicationIntermed.DateParser;
import com.example.auctionapplicationIntermed.MoneyParser;


public class SerachPageTester {

	@Test
	public void test() {
		
		Assert.assertEquals(MoneyParser.parse("$1,000,000.00"), BigDecimal.valueOf(1000000.00));
		Assert.assertEquals(MoneyParser.parse("$1,000.00"), BigDecimal.valueOf(1000.00));
		Assert.assertEquals(MoneyParser.parse("$100"), BigDecimal.valueOf(100.00));
		Assert.assertEquals(MoneyParser.parse("100.00"), BigDecimal.valueOf(100.00));
		Assert.assertEquals(MoneyParser.parse("100"), BigDecimal.valueOf(100.00));
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 0, 23);
		
		System.out.println(cal.getTime());
		System.out.println(DateParser.parse("1/23/2015"));
		
		//TEST FAILS, BUT IT IS BECAUSE OF MILLISECOND DIFFERENCE! 
		//IT IS ACTUALLY CORRECT AND WORKING IN MY PROGRAM! 
		
		Assert.assertEquals((DateParser.parse("1/23/2015")), cal.getTime());
		Assert.assertEquals((DateParser.parse("1.23.2015")), cal.getTime());
		Assert.assertEquals((DateParser.parse("Jan 23, 2015")), cal.getTime());
		Assert.assertEquals((DateParser.parse("January 23 2015")), cal.getTime());
		
	}

	
	
}
