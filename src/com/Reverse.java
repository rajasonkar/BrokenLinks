package com;

public class Reverse {
	static String s ;
	public static void main(String args[])
	{
		
		int x =153;
		String str = Integer.toString(x);
		for(int i = str.length()-1;i>=0;i--)
		{
			if(i==(str.length()-1))
			s = ""+str.charAt(i);
			else
				s= (s+str.charAt(i));
		}
	//	str =str.replace(str.charAt(index), newChar)
		System.out.println(s);
		int n =153;
		int reverse =0;
		while(n != 0)
	    {
	      reverse = reverse * 10;
	      reverse = reverse + n%10;
	      n = n/10;
	    }

	    System.out.println("Reverse of the number is " + reverse);
	}
}
