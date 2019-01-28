package com.utils.excelutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Creating_Reading_Writing_File 
{
	public static void main(String args[]) throws IOException
	{
        File fs=new File("C:\\Users\\mohit\\Desktop\\test.txt");
        fs.createNewFile();
        // Write the file
        
        FileWriter w=new FileWriter("C:\\Users\\mohit\\Desktop\\test.txt");
        BufferedWriter out=new BufferedWriter(w);
        out.write("hello we are writing in a file");
        out.append(" test");
        out.newLine();
        out.write("Prime file");
        out.flush();
        
        //Reader
        FileReader r=new FileReader("C:\\Users\\mohit\\Desktop\\test.txt");
        BufferedReader br=new BufferedReader(r);
        String s="";
        while((s=br.readLine())!=null)
        {
        	System.out.println(s);
        }
        
	}
}
