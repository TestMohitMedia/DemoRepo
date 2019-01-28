package com.StringProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DateFormat 
{
	public void extractDate(String convertdate) throws ParseException
	{
		Calendar cal=new GregorianCalendar();
		
		SimpleDateFormat format=new SimpleDateFormat("DD/MM/yyyy");
		Date date=format.parse(convertdate);
		cal.setTime(date);
		String day=new SimpleDateFormat("dd").format(date);
		String month=new SimpleDateFormat("MM").format(date);
		int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		System.out.println("Day: "+day+": Month: "+month+": year :"+ year);
		int mon=cal.get(Calendar.MONTH);
		System.out.println(mon);
	}
	public void set()
	{
		Set<Integer> str=new TreeSet<Integer>();
		str.add(3);
		str.add(12);
		str.add(1);
		Iterator<Integer> itr=str.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	public static void main(String args[]) throws ParseException
	{
		DateFormat df=new DateFormat();
		df.set();
	}
	

}
