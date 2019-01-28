package com.utils.excelutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ReadPropertyFile 
{
   public static void main(String args[])
   {
	   Properties pr=new Properties();
	   try {
		FileInputStream fs=new FileInputStream("./Config/Employee.properties");
		try {
			pr.load(fs);
			Set<Object> key=pr.keySet();
			Iterator<Object> itr=key.iterator();
			while(itr.hasNext())
			{
				String prty=(String)itr.next();
				System.out.println(prty+": value :"+ pr.get(prty));
			}
			Set<String> name=pr.stringPropertyNames();
			for(String s:pr.stringPropertyNames())
			{
				System.out.println("Value of "+s+":"+pr.get(s));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
