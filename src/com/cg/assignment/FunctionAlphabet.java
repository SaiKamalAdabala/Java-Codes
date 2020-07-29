package com.cg.assignment;

import java.util.Arrays;
import java.util.Scanner;



public class FunctionAlphabet {

	
		 String AlphabetSoup(String str) { 
			  
			    char[] ch = new char[str.length()];

			  // store every letter in character array

			  for (int i = 0; i < str.length(); i++) {
			   ch[i] = str.charAt(i);

			  }
			    
			  Arrays.sort(ch);
			  String str1 ="";
			  for (int i = 0; i < str.length(); i++) {
			
			   str1= str1+ ch[i];

			  }
			   return str1;
			       

			    
			  } 
			 


		  public static void main (String[] args) {  
		    // keep this function call here     
		    Scanner  s = new Scanner(System.in);
		    FunctionAlphabet c = new FunctionAlphabet();
		    String value=s.nextLine();
		    if(value.matches("^[a-zA-Z]*$"))
		    {
		    System.out.print(c.AlphabetSoup(value));
		    }
		    else {
		    	System.out.println("Invalid string");
		    }
		    
		    s.close(); 
		  }   
		 
	}

