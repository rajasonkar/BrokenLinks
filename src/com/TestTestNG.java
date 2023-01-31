package com;

import org.testng.annotations.Test;

public class TestTestNG {

	
	@Test(priority =0)
	public void z()
	{
		System.out.println("priority 0");
	}
	@Test
	public void m2()
	{
		System.out.println(" no priority m2");
	}
	@Test
	public void m3()
	{
		System.out.println(" no priority m3");
	}
	@Test(priority=1)
	public void A()
	{
		System.out.println("priority 1");
	}
	@Test
	public void B()
	{
		System.out.println(" no priority B");
	}
}
