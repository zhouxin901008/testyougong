package ZYZS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import WebTesting.BasicDriver;

public class WebTestingZYBJ extends BasicDriver {
	@Test
	public void ZYBJ() throws InterruptedException {
		BasicDriver.open();
		//登录
		BasicDriver.sendKeys(By.id("loginChildName"), "QAtest");
		BasicDriver.sendKeys(By.id("loginUserName"), "QAtest");
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		BasicDriver.click(By.linkText("招商管理"));
		BasicDriver.click(By.linkText("已报名自营招商项目"));
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		BasicDriver.click(By.xpath("//a[@class='operations']"));
		//进入报价页
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBJ1.jpg");
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(0).clear();
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(0).sendKeys("410");
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(4).clear();
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(4).sendKeys("210.6");
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(6).clear();
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(6).sendKeys("137.77");
		driver.findElement(By.xpath("//button[@class='btn btn-primary bid-btn first-bid']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default confirm btn-lg']")).click();
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBJ2.jpg");
		/*
		//二次报价
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(0).clear();
		driver.findElements(By.xpath("//input[@data-key='1004']")).get(0).sendKeys("500");
		driver.findElement(By.xpath("//button[@class='btn btn-primary bid-btn first-bid']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default confirm btn-lg']")).click();
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBJ3.jpg");
		*/
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
