package com;

public class ReverseAString {
public static void main(String args[])
{
String str = "My first java program";
StringBuilder sb = new StringBuilder(str);
sb=sb.reverse();
System.out.println(sb);

 
int l = str.length();
for(int i=l-1;i>=0;i--)
{
System.out.print(str.charAt(i));

}
System.out.println("");
String str1 = str.replaceAll("a", "1");
System.out.println(str1);
System.out.println(str1.replace("1", "2"));
int x=3;
if(x==3);
	x++;
System.out.println(x);
}
}
