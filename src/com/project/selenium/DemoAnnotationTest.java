package com.project.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoAnnotationTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite method in DemoAnnotationTest");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite method in DemoAnnotationTest");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass method in DemoAnnotationTest");
	}
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("afterClass method in DemoAnnotationTest");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest method in DemoAnnotationTest");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest method in DemoAnnotationTest");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod method in DemoAnnotationTest");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod method in DemoAnnotationTest");
	}
	@Test
	public void testMethod2()
	{
		System.out.println("testMethod2 method in DemoAnnotationTest");
	}
	@Test
	public void testMethod()
	{
		System.out.println("testMethod method in DemoAnnotationTest");
	}
	
}
