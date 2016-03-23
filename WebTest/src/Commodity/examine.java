package Commodity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import WebTesting.BasicDriver;


public class examine extends BasicDriver{
	@Test
	public void examining() throws InterruptedException, IOException{
		String a[] = new String[]{"海鲜肥牛"};
		//进入审核网站
		BasicDriver.open2();
		//登录
		BasicDriver.sendKeys(By.id("loginChildName"), "admin");
		WebElement lsh1 = driver.findElement(By.id("loginPassword"));
		lsh1.sendKeys(new String[] {"123456"});
		lsh1.submit();
		BasicDriver.click(By.linkText("商品信息审核"));
		BasicDriver.sendKeys(By.name("q"), a[0]);
		BasicDriver.click(By.xpath("//button[@search-key='word']"));
		Thread.sleep(1000);
		System.out.println("搜索到的商品为:" + driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/ul/li/table/tbody/tr/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/ul/li/table/tbody/tr/td[3]")).getText(),a[0]);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/123.jpg");
		System.out.print("测试通过");
	}
	@AfterTest
	public void tearDown(){
		driver.quit();		
	}
}
