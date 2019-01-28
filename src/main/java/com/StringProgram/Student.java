package com.StringProgram;

import java.util.ArrayList;
import java.util.Collections;

public class Student 
{
  String name;
  int id;
  Student(String name,int id)
  {
    this.id=id;
    this.name=name;
  }
  public int getID()
  {
	  return id;
  }
  public String getName()
  {
	  return name;
  }
  public String toString()
  {
	  return this.id+" :"+this.name;
  }
  public static void main(String args[])
  {
	  ArrayList<Student> studentlist=new ArrayList<Student>();
	  studentlist.add(new Student("Mohit",101));
	  studentlist.add(new Student("Raj",95));
	  studentlist.add(new Student("Rohan",110));
	  Collections.sort(studentlist,new SortById());
	  for(int i=0;i<studentlist.size();i++)
	  {
		  System.out.println(studentlist.get(i));
	  }
  }
}
