package ZYZS;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import WebTesting.BasicDriver;

public class WebTestingZYSH extends BasicDriver{
	@Test
  	public void ZYSH() throws InterruptedException {
		BasicDriver.open();
		Thread.sleep(1000);
		BasicDriver.sendKeys(By.id("loginChildName"), "admin");
		BasicDriver.sendKeys(By.id("loginUserName"), "wumart");
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		BasicDriver.click(By.linkText("我的自营招商项目"));
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		Thread.sleep(1000);
		//验证项目状态
		Assert.assertEquals(driver.findElement(By.className("proj-state")).getText(),"竞价：1家报名 0家报价");
		BasicDriver.click(By.xpath("//a[2][@class='operations']"));
		BasicDriver.windows(1);
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYSH1.jpg");
		/*
		//验证表单信息
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[1]")).getText(),"QAqa");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[2]")).getText(),"503739");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[3]")).getText(),"配送");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[4]")).getText(),"允许");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[5]")).getText(),"8");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[6]")).getText(),"待审核");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr/td[7]")).getText(),"审核");
		*/
		BasicDriver.click(By.linkText("审核"));
		//进入商品审核页
		BasicDriver.windows(2);
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYSH2.jpg");
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary act-submit']"));
		BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[2]/button[1]"));
		//进入设置初始报价页
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYSH3.jpg");
		driver.findElement(By.name("value")).clear();
		BasicDriver.sendKeys(By.name("value"), "1500");
		for(int i=1;i<5;i++){
			BasicDriver.click(By.xpath("//tbody/tr["+i+"]/td[6]/select/option[@value='205-002']"));
			driver.findElement(By.xpath("//tbody/tr["+i+"]/td[7]/input[@class='form-control']")).clear();
			BasicDriver.sendKeys(By.xpath("//tbody/tr["+i+"]/td[7]/input[@class='form-control']"), "20"+i);
		}
		for(int j=5;j<9;j++){
			BasicDriver.click(By.xpath("//tbody/tr["+j+"]/td[6]/select/option[@value='205-005']"));
			driver.findElement(By.xpath("//tbody/tr["+j+"]/td[7]/input[@class='form-control']")).clear();
			BasicDriver.sendKeys(By.xpath("//tbody/tr["+j+"]/td[7]/input[@class='form-control']"), "30"+j);
			}
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary act-submit']"));
		BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div/div[2]/button[1]"));
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYSH4.jpg");
	}
	@AfterTest
  	public void afterTest() {
		driver.quit();
  }

}
