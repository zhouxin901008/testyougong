package ZYZS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import WebTesting.BasicDriver;

public class WebTestingZYPY extends BasicDriver{
	@Test
	public void ZYPY() throws InterruptedException {
		BasicDriver.open();
		Thread.sleep(1000);
		//登录
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
		BasicDriver.click(By.xpath("//a[1][@class='operations']"));
		//进入查看报价页
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY1.jpg");
		if(driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getText().contentEquals("开启")){
			BasicDriver.click(By.xpath("//button[@class='btn btn-primary']"));
			BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div/div[7]/div/div/div[4]/button[1]"));
			Thread.sleep(1000);
		}
		Assert.assertEquals(driver.findElement(By.xpath("//button[@class='btn set-end btn-primary']")).getText(),"开始");
		BasicDriver.click(By.xpath("//button[@class='btn set-end btn-primary']"));
		BasicDriver.sendKeys(By.xpath("//input[@class='minutes form-control']"),"1");
		BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div/div[6]/div/div/div[4]/button[1]"));
		Thread.sleep(60000);
		Assert.assertEquals(driver.findElement(By.xpath("//button[@class='btn set-pause btn-primary']")).getText(),"暂停");
		//数组判断抓取两次时间，查看取到的时间是否不同
		String[] time = new String[2];
		for(int i=0;i<2;i++){
			time[i] = driver.findElement(By.xpath("//div[@class='count-item  count']")).getText();
			System.out.println(time[i]);
			Thread.sleep(5000);
			}
		Assert.assertNotEquals(time[0],time[1],"出现错误，获取的时间一样");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='bid-end count']")).getText(), "报价已结束");
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY2.jpg");
		if(driver.findElement(By.xpath("//div[@class='bid-end count']")).getText()=="报价已结束"){
			//点击评议按钮
			BasicDriver.click(By.xpath("//a[@class='btn evaluate btn-primary btn-sm']"));
		}
		//进入评议页
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY3.jpg");
		BasicDriver.click(By.linkText("评议全部商品"));
		//选择入选组
		BasicDriver.click(By.xpath("//tbody/tr[1]/td[1]/select/option[@value='-1']"));
		BasicDriver.click(By.xpath("//tbody/tr[2]/td[1]/select/option[@value='1']"));
		BasicDriver.click(By.xpath("//tbody/tr[4]/td[1]/select/option[@value='3']"));
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='btn btn-primary success']")).getText(),"提交评议审核");
		BasicDriver.click(By.xpath("//a[@class='btn btn-primary success']"));
		//进入评议预览页
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY4.jpg");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='btn btn-primary']")).getText(),"提交评议审核");
		BasicDriver.click(By.xpath("//a[@class='btn btn-primary']"));
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary success']"));
		Thread.sleep(1000);
		
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.className("proj-state")).getText(),"评议审核中");
		BasicDriver.click(By.xpath("//a[1][@class='operations']"));
		Thread.sleep(1000);
		//进入评议审核页
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY5.jpg");
		Assert.assertEquals(driver.findElements(By.cssSelector("a.btn.btn-primary")).get(1).getText(),"审核通过");
		driver.findElements(By.cssSelector("a.btn.btn-primary")).get(1).click();
		BasicDriver.sendKeys(By.name("approve_detail"), "QA评议审核test通过");
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary agree']"));
		Thread.sleep(1000);
		
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.className("proj-state")).getText(),"发布审核中");
		BasicDriver.click(By.xpath("//a[1][@class='operations']"));
		Thread.sleep(1000);
		//进入发布审核页
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY6.jpg");
		Assert.assertEquals(driver.findElements(By.cssSelector("a.btn.btn-primary")).get(1).getText(), "通过并发布结果");
		driver.findElements(By.cssSelector("a.btn.btn-primary")).get(1).click();
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary approve']"));
		Thread.sleep(1000);
		
		BasicDriver.sendKeys(By.id("searchTitle"), ""+ZYtest.title());
		BasicDriver.click(By.xpath("//button[@class='btn btn-primary submit']"));
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.className("proj-state")).getText(),"成功招商");
		BasicDriver.click(By.xpath("//a[1][@class='operations']"));
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY7.jpg");
		BasicDriver.frame(By.linkText("查看招商结果公告"),"st-content-iframe");
		BasicDriver.windows(1);
		Assert.assertEquals(ZYtest.title() + " " + "入选公示",driver.getTitle());
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYPY8.jpg");
		System.out.println("自营招商测试结束");
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
