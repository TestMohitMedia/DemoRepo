package com.StringProgram;

public class StringProgram 
{
   /*Created By: Mohit
   Feature: Reverse the String through Reccursion
   Updated Time: 30 Nov 2018*/
   static String  name="Mohit Verma";
   static String reverse="";
   public String returnStringReccursion(String str)
   {
	   if(str.length()<=1)
	   {
		  return str;
	   }
	   return reverse+=str.charAt(str.length()-1)+returnStringReccursion(str.substring(0,str.length()-1));
   }
   public void reverseString(String str)
   {
	   String[] string=str.split("\\s");
	   for(int i=0;i<string.length;i++)
	   {
		   for (int j=string[i].length()-1;j>=0;j--)
		   {
			   System.out.print(string[i].charAt(j));
		   }
		   System.out.print(" ");
	   }
   }
   public void printSpiral()
   {
	   int[][] data=new int[2][2];
	   for(int i=0;i<3;i++)
	   {
		   for(int j=0;j<3;j++)
		   {
			   data[i][j]=1+i+j;
		   }
	   }
	   int[][] test=new int[2][2];
	   int rowStart=0;
	   int colStart=0;
	   int rowLen=data.length-1;
	   int colLen=data.length-1;
	   for(int i=colStart;i<=colLen;i++)
	   {
		   test[rowStart][i]=data[rowStart][i];
	   }
	   for(int i=rowStart+1;i<=rowLen;i++)
	   {
		   test[i][colLen]=data[i][colLen]; 
	   }
	   for(int i=colLen-1;i>=colLen;i--)
	   {
		   test[rowLen][i]=data[rowLen][i]; 
	   }
	   for(int i=rowLen-1;i>rowStart+1;i--)
	   {
		   test[i][colStart]=data[i][colStart]; 
	   }
	   rowStart++;
	   colStart++;
	   rowLen--;
	   colLen--;
	   
   }
   public void checkPrimeNo(int Number)
   {
	   Boolean flag=false;
	   for(int i=2;i<=Number/2;i++)
		   if(Number%i==0)
		   {
			   flag=true;
	           break;
		   }
	   if(flag)
		   System.out.println("Number is not prime.");
	   else
		   System.out.println("Number is prime.");
   }
   public static void main(String args[])
   {
	   System.out.println("***********String Program**********");
	   StringProgram strprog=new StringProgram();
	   strprog.checkPrimeNo(17);
	   /*System.out.println(strprog.returnStringReccursion(name));
	   String[] name1=name.split("\\s");
	   System.out.println(name1.length+": "+name1[0]+": "+ name1[1]);*/
   }
}
