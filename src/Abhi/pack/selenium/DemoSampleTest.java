package Abhi.pack.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoSampleTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite method in DemoSampleTest");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite method in DemoSampleTest");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass method in DemoSampleTest");
	}
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("afterClass method in DemoSampleTest");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest method in DemoSampleTest");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest method in DemoSampleTest");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod method in DemoSampleTest");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod method in DemoSampleTest");
	}
	@Test
	public void testMethod()
	{
		System.out.println("testMethod method in DemoSampleTest");
	}
	@Test
	public void testMethod2()
	{
		System.out.println("testMethod2 method in DemoSampleTest");
	}
	
}
