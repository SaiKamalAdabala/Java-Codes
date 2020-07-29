package com.cg.assignment;


import java.util.*;
import java.lang.*;
import java.io.*;

public class Letter{


private static String LetterChanges(String s){
char ch;
for(int i=0;i<s.length();i++){
ch=s.charAt(i);
Character c1 = new Character(ch);
if(c1.equals('z')){
c1=(char)(c1-25);
c1=c1.toUpperCase(c1);
s = s.substring(0, i) + c1 + s.substring(i+ 1);
}
else{
c1=(char)(c1+1);
if(c1.equals('e')||c1.equals('i')||c1.equals('o')||c1.equals('u')){
c1=c1.toUpperCase(c1);
}
s = s.substring(0, i)  + c1 + s.substring(i + 1);
}
}
return s;
}
public static void main (String[] args) throws java.lang.Exception
{
// your code goes here
String s= "zaslkdfelksjdikashddojhsadfmu";
String a=LetterChanges(s);
System.out.println(a);
}
}