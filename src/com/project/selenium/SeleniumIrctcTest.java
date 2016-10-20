package com.project.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumIrctcTest {
	
	@Parameters("browser")
	@Test
	public void testIRCTC(String browser) throws InterruptedException
	{
		WebDriver driver=null;
		if(browser.contains("firefox")){
		 driver = new FirefoxDriver();
		}
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		String pw=driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Flight Tickets']")).click();
		Set<String> windowHandle=driver.getWindowHandles();
		for(String window:windowHandle)
		{
			if(!window.equals(pw))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("air"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='onewayradio']//input[@name='tripType']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//div[@class='roundtripradio']//input[@name='tripType']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='origin']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Jaipur");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='departDate']/following-sibling::img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//a[text()='23']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='noOfAdult']")));
		select.selectByIndex(1);
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfChild']")));
		select.selectByIndex(1);
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfInfant']")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//div[@id='showdometic']/div[@class='srchbtn']")).click();
		List<WebElement> list = driver.findElements(By.className("onewayflightinfo"));
		Assert.assertTrue(list.size()>0 && list.size()<100);
		System.out.println("Total no of flights: "+list.size());
		System.out.println("first element: "+list);
		driver.close();
		driver.switchTo().window(pw);
		driver.close();
	}
	
	@Test
	public void testIRCTC2() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		String pw=driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='bluemenu']/ul/li[5]/a")).click();
		Set<String> windowHandle=driver.getWindowHandles();
		for(String window:windowHandle)
		{
			if(!window.equals(pw))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("air"));
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='onewayradio']//input[@name='tripType']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//div[@class='roundtripradio']//input[@name='tripType']")).isSelected());
		
		driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='origin']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Jaipur");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[@id='where']/div[4]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//tr[2]/td[4]/a")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='noOfAdult']")));
		select.selectByIndex(1);
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfChild']")));
		select.selectByIndex(1);
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfInfant']")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//div[@id='showdometic']/div[@class='srchbtn']")).click();
		List<WebElement> list = driver.findElements(By.className("onewayflightinfo"));
		Assert.assertTrue(list.size()>0 && list.size()<100);
		System.out.println("Total no of flights: "+list.size());
		System.out.println("first element: "+list);
		driver.close();
		driver.switchTo().window(pw);
		driver.close();
	}

}
