package com;

public class TestInnerClass {
/////1. nested inner class
	/*class inner
	{
	  void m1()
	  {
		  System.out.println("inner");
	  }  
	}
	public static void main(String args[])
	{
		System.out.println("10");
		TestInnerClass.inner n = new TestInnerClass().new inner();
		n.m1();
		
	}*/
	//2.gives error for main method in inner class that it should be static
/*	public  class inner2{
		public static void main(String args[])
		{
			System.out.println("10");
			
			//n.m1();
			
		}
	}*/
	//4.when top level and inner class both are public 
/*	public  class inner3{
		public  void m2()
		{
			System.out.println("10");	
		}
	}
	public static void main(String args[])
	{
		//System.out.println("10");
		TestInnerClass.inner3 n = new TestInnerClass().new inner3();
		n.m2();
		
	}
*/
	//method local inner class
	 void outerMethod() { 
	        System.out.println("inside outerMethod"); 
	        // Inner class is local to outerMethod() 
	        class Inner { 
	            void innerMethod() { 
	                System.out.println("inside innerMethod"); 
	            } 
	        } 
	        Inner y = new Inner(); 
	        y.innerMethod(); 
	    } 
	 public static void main(String args[])
		{
			//System.out.println("10");
		TestInnerClass t = new TestInnerClass();
		t.outerMethod();
			
		}
}
//3.there cannot be two public class in single class but it is possible in inner class
/*public class TestClass{
	
}*/
