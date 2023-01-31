package com;

public class PrintTriangle {
public static void main(String args[])
{
/*for(int i=0;i<5;i++)
{
	for(int j=0;j<=i;j++)
	{
		System.out.print("* ");
	}
	System.out.println("");
}*/	
/*for(int i=5;i>0;i--)
{
	for(int k=0;k<i;k++){
		System.out.print(" ");
	}
	for(int j=5;j>=i;j--)
	{
		System.out.print("* ");
	}
	System.out.println("");
}*/	

int n=5;
for(int i=1;i<=n;i++)
{
	for(int k=n;k>i;k--){
		System.out.print(" ");
	}
	for(int j=1;j<=i;j++)
	{
		System.out.print("*");
	}
	System.out.println("");
}
}
}