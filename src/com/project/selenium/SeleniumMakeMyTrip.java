package com.project.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class SeleniumMakeMyTrip {

	@Test
	public void testMakeMyTrip() throws InterruptedException
	{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//li[@class='all_menuListitem hide_us']")).click();
	String pw=driver.getWindowHandle();
	System.out.println("parent window handle: "+pw);
	driver.findElement(By.xpath("//a[@rel='#allMenu_domhldData']")).click();
	Set<String> allWindow  = driver.getWindowHandles();
	String prevWindow=" ";
	for(String window: allWindow)
	{
		if(window.equals(pw)==false)
		{
			System.out.println("child window handle value : "+ window);
			prevWindow=window;
			driver.switchTo().window(window);
			break;
		}
	}
	driver.findElement(By.xpath("//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")).sendKeys("jaipur");
	//Thread.sleep(3000);
	//driver.findElement(By.xpath("//input[@class='typeahead-dep-city input-md form-control field-transparent tt-input']")).
	//driver.findElement(By.xpath("//span[@class='tt-suggestions']/div/p/strong")).click();
	driver.findElement(By.xpath("//a[@id='submit-btn-holiday']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'148')]/following-sibling::a[@class='flR button view_detls']")).click();
	driver.findElement(By.xpath("//a[@class='flR button view_detls pkgViewDetailLink' and @href='/holidays/india/package?id=24812&depCityId=3769&intid=inspire_Packageview']")).click();
	driver.findElement(By.xpath("//div[@class='viewDetail_overlay view_overlay_added']/div[@class='viewDetails']/a[@class='tip_ovr_close_icon flR']")).click();
	Set<String> allWin = driver.getWindowHandles();
	for(String str:allWin)
	{
		if(str.equals(prevWindow)==false && str.equals(pw)==false)
		{
			driver.switchTo().window(str);
			System.out.println("last window handle :"+str);
			break;
		}
	}
	driver.findElement(By.xpath("//div[@id='sidebar_fix']/div/div/p/a")).click();
	driver.findElement(By.xpath("//div[@id='rateDate_overlay']/a")).click();
	driver.close();
	driver.switchTo().window(prevWindow);
	driver.close();
	driver.switchTo().window(pw);
	System.out.println("Url : "+driver.getCurrentUrl());
	driver.close();
	//Thread.sleep(5000);
	//driver.close();
	}
	
}
