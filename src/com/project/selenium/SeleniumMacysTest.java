package com.project.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumMacysTest {
	
	@Test
	public void testMacys() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www1.macys.com/");
		driver.findElement(By.xpath("//a[@id='closeButton']")).click();
		driver.findElement(By.xpath("//input[@id='globalSearchInputField']")).sendKeys("Jeans");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='subnavSearchSubmit']")).click();
		Thread.sleep(7000);
		System.out.println("Title= "+driver.getTitle());
		System.out.println("URL = "+driver.getCurrentUrl());
		Thread.sleep(7000);
		driver.findElement(By.xpath("//img[@id='image_2351352_0_cat']")).click();
		driver.findElement(By.xpath("//li[@title='4L']")).click();
		driver.findElement(By.xpath("//button[@id='addToBagButton2351352']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//img[@id='btnCheckout']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='remove_item_36395053_3_1']")).click();
		Thread.sleep(5000);
		System.out.println("Text= "+driver.findElement(By.xpath("//div[text()='Removed from bag']")).getText());
		driver.close();
		
	}

}
