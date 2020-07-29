package com.cg.assignment;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hello World";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			System.out.print(str.charAt(i));
		}
	}

}