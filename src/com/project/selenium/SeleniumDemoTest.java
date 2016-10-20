package com.project.selenium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

public class SeleniumDemoTest {
	
	@Test
	public void testGoogle() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.google.co.in/?gfe_rd=cr&ei=80L3V86HKq3T8gfP04aQCg&gws_rd=ssl");
	//WebElement googleSearchField = driver.findElement(By.xpath("//input[@id='lst-ib']"));
	driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("discovery");
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@value='Search']")).click();
	Thread.sleep(3000);
	Random num = new Random();
	int number= num.nextInt(6)+5;
	//String number=num.toString();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy@MM@dd_HH-mm-ss");
	Date date = new Date();
	String format= dateFormat.format(date);
	System.out.println(dateFormat.format(date));
	System.out.println("Random Numbers: "+number);
	File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File("E:\\Myfile"+format+".png"));
	driver.navigate().back();
	driver.navigate().to("https://www.youtube.com/watch?v=D1tVa1CIgAk");
	Actions action = new Actions(driver);
	action.sendKeys(Keys.F5).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.tagName("body")).sendKeys(Keys.F6);
	action.sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(3000);
	System.out.println("Current URL"+driver.getCurrentUrl());
	Thread.sleep(3000);
	driver.navigate().forward();
	Thread.sleep(3000);
	driver.navigate().refresh();
	driver.close();
	}

}
