package Abhi.pack.selenium;

import org.testng.annotations.Test;

public class DemoPriorityTest {
	
	@Test(priority=1)
	public void testMethod1()
	{
		System.out.println("Test Method1 with priority one");
	}
	@Test(priority=-1)
	public void testMethod2()
	{
		System.out.println("Test Method2 with priority minus 1");
	}
	@Test()
	public void testMethod3()
	{
		System.out.println("Test Method3 with priority zero");
	}
	@Test(priority=-1)
	public void testMethod4()
	{
		System.out.println("Test Method4 with priority minus 1");
	}
	@Test(priority=1)
	public void testMethod5()
	{
		System.out.println("Test Method5 with priority one");
	}
	@Test(priority=0)
	public void testMethod6()
	{
		System.out.println("Test Method6 with priority zer0");
	}
	@Test
	public void testMethod7()
	{
		System.out.println("Test Method7 with priority default");
	}
	@Test
	public void testMethod8()
	{
		System.out.println("Test Method8 with priority default");
	}

}
