package ZYZS;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import WebTesting.BasicDriver;


public class WebTestingZYBM extends BasicDriver{
	@Test
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public void ZYBM() throws InterruptedException {
		BasicDriver.open();
		//登录
		BasicDriver.sendKeys(By.id("loginChildName"), "QAtest");
		BasicDriver.sendKeys(By.id("loginUserName"), "QAtest");
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		BasicDriver.click(By.linkText("招商管理"));
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		Thread.sleep(1000);
		BasicDriver.click(By.linkText("[北京]"+ZYtest.title()));
		BasicDriver.windows(1);
		//报名
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBM1.jpg");
		BasicDriver.click(By.xpath("//input[@name='agreement_id']"));
		BasicDriver.click(By.xpath("//button[@name='bidding_id']"));
		Thread.sleep(1000);
		//点击报价
		BasicDriver.click(By.xpath("//a[@class='btn btn-primary btn-lg']"));
		BasicDriver.windows(2);
		Thread.sleep(1000);
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBM2.jpg");
		BasicDriver.click(By.linkText("新增报价商品"));
		Thread.sleep(1000);
		//选择商品并输出选中的商品名
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBM3.jpg");
		driver.findElements(By.xpath("//input[@class='items']")).get(0).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[1]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(18).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[19]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(32).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[33]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(33).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[33]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(34).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[35]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(35).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[36]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(36).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[37]/td[2]")).get(0).getText());
		driver.findElements(By.xpath("//input[@class='items']")).get(37).click();
		System.out.println(driver.findElements(By.xpath("//tbody/tr[38]/td[2]")).get(0).getText());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit-btn']"));
		Thread.sleep(1000);
		//验证审核状态
		Assert.assertEquals(driver.findElement(By.className("total-status")).getText(),"当前状态：待提交");
		//选择供货信息
		BasicDriver.click(By.xpath("//option[@value='503739']"));
		BasicDriver.click(By.xpath("//option[@value='1']"));
		BasicDriver.click(By.xpath("//option[@value='2']"));
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYBM4.jpg");
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit-btn']"));
	}
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
}