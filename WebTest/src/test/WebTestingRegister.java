package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;

import WebTesting.WebLog;


public class WebTestingRegister {

@Test
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public void Register() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		navigation.to("http://qa.lsh123.com/bidding");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("注册")).click();
		Thread.sleep(2000);
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[1]);
		driver.manage().window().maximize();
		driver.findElement(By.id("registerName")).sendKeys(new String[] {"123"});
		driver.switchTo().window(handles[0]).close();
		WebLog.writeToFile(dateFormat.format(date)+" "+"注册页面测试结束");
		driver.quit();
		}
	}
