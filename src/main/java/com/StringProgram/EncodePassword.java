package com.StringProgram;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodePassword
{
   public static void main(String args[])
   {
	   String mypassword="testqa@12345";
	   byte[] message=mypassword.getBytes(StandardCharsets.UTF_8);
	   String encoded=Base64.getEncoder().encodeToString(message);
	   System.out.println(encoded);
	   
	   
	   byte[] decoded=Base64.getDecoder().decode(encoded);
	   String s=new String(decoded,StandardCharsets.UTF_8);
	   System.out.println(s);
   }
}
