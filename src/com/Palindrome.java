package com;

public class Palindrome {
public static void main(String args[])
{
	 int palindrome =123;
     
     if(isPalindrome(palindrome)){
         System.out.println("Number : " + palindrome + " is a palindrome");
     }else{
         System.out.println("Number : " + palindrome + " is not a palindrome");
     }       
     
}

public static boolean isPalindrome(int number) {
    int palindrome = number; // copied number into variable
    int reverse = 0;

    while (palindrome != 0) {
        int remainder = palindrome % 10;
        System.out.println("remm:"+remainder);
        reverse = reverse * 10 + remainder;
        palindrome = palindrome / 10;
        System.out.println("test :"+palindrome);
    }
System.out.println("reverse:"+reverse);
    // if original and reverse of number is equal means
    // number is palindrome in Java
    if (number == reverse) {
        return true;
    }
    return false;
}
}
