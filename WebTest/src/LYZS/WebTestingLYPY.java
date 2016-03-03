package LYZS;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebTesting.WebLog;

public class WebTestingLYPY {
  @Test
  public void LYPY() throws InterruptedException {
	  	String b[] = new String[]{"【QA联营招标测试】01.09回归test1"};
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		System.out.println("联营采购方查看报名评议测试流程开始");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方查看报名评议测试流程开始");
		//最大化浏览器
		driver.manage().window().maximize();
		navigation.to("http://dev.lsh123.com/bidding");
		Thread.sleep(1000);
		driver.findElement(By.id("loginChildName")).sendKeys(new String[] {"admin"});
		driver.findElement(By.id("loginUserName")).sendKeys(new String[] {"wumart"});
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		driver.findElement(By.linkText("我的联营招商项目")).click();
		driver.findElement(By.id("searchTitle")).sendKeys(b[0]);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[5]/div[1]/ul/li/table/tbody/tr/td[6]/a[1]")).click();
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + "进入页面:" + driver.getTitle());
		//报价未结束
		//查看报价
		if(driver.findElement(By.xpath("//div[@class='count-item  count']")).getText().contains("-- : -- : --")){
			driver.findElement(By.xpath("//button[@class='btn set-end btn-primary']")).click();
			driver.findElement(By.xpath("//input[@class='minutes form-control']")).sendKeys("1");
			driver.findElement(By.cssSelector("html body.modal-open div.l-flow-con.l-flow-con-fold.clearfix div.l-right-con.l-right-con-expanded div#signupList.mod-signup-list div.modal.fade.modal-set-end.in div.modal-dialog div.modal-content div.modal-footer button.btn.btn-primary.confirm")).click();
			//数组判断抓取两次时间，查看取到的时间是否不同
			String[] time = new String[2];
			for(int i=0;i<2;i++){
				time[i] = driver.findElement(By.xpath("//div[@class='count-item  count']")).getText();
				System.out.println(time[i]);
				Thread.sleep(5000);
				}
			Assert.assertNotEquals(time[0],time[1],"出现错误，获取的时间一样");
			System.out.println("两次获取的时间不一样，测试通过");
			Thread.sleep(60000);
			System.out.println("查看报价状态:" + driver.findElement(By.xpath("//div[@class='bid-end count']")).getText());
			WebLog.writeToFile(dateFormat.format(date) + " " + "查看报价状态:" + driver.findElement(By.xpath("//div[@class='bid-end count']")).getText());	
			Assert.assertEquals("报价已结束", driver.findElement(By.xpath("//div[@class='bid-end count']")).getText());
			driver.findElement(By.xpath("//a[@class='btn evaluate btn-primary btn-sm']")).click();
			//进入评议页面
			System.out.println("进入页面:" + driver.getTitle());
			WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
			System.out.println(driver.findElement(By.xpath("//span[@class='item']")).getText());
			WebLog.writeToFile(dateFormat.format(date) + " " + driver.findElement(By.xpath("//span[@class='item']")).getText());
			driver.findElement(By.xpath("//a[@class='btn btn-primary success']")).click();
			
		}
		//报价已经结束
		else {
			//直接进入评议页面
			System.out.println("查看报价状态:" + driver.findElement(By.xpath("//div[@class='bid-end count']")).getText());
			WebLog.writeToFile(dateFormat.format(date) + " " + "查看报价状态:" + driver.findElement(By.xpath("//div[@class='bid-end count']")).getText());	
			System.out.println(driver.findElement(By.xpath("//span[@class='item']")).getText());
			WebLog.writeToFile(dateFormat.format(date) + " " + driver.findElement(By.xpath("//span[@class='item']")).getText());	
			driver.findElement(By.xpath("//a[@class='btn btn-primary success']")).click();
			
		}
		//进入评议预览页面
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//span[@class='item']")).getText());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.findElement(By.xpath("//span[@class='item']")).getText());
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary success']")).click();
		//提交评议结果后跳转到列表页，重新搜索标题，后续操作由VP审核
		Thread.sleep(2000);
		driver.findElement(By.id("searchTitle")).sendKeys(b[0]);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		driver.findElement(By.xpath("//a[@class='operations']")).click();
		//进入评议审核页面
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//span[@class='item']")).getText());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.findElement(By.xpath("//span[@class='item']")).getText());
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[1]/div[2]/div/div[1]/a[2]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary agree']")).click();
		//提交评议审核后跳转到列表页，重新搜索标题，后续操作由VP确认审核
		driver.findElement(By.id("searchTitle")).sendKeys(b[0]);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		driver.findElement(By.xpath("//a[@class='operations']")).click();
		//进入发布审核页面
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//span[@class='item']")).getText());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.findElement(By.xpath("//span[@class='item']")).getText());
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[1]/div[2]/div/div[1]/a[2]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary approve']")).click();
		//进入招商结果页面
		Thread.sleep(1000);
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
		driver.switchTo().frame("st-content-iframe");
		driver.findElement(By.linkText("查看招商结果公告")).click();
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[1]);
		//进入招商结果公告页面
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());
		Assert.assertEquals(b[0] + " " + "入选公示",driver.getTitle());
		System.out.println("联营采购方查看报名评议测试流程结束");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方查看报名评议测试流程结束");
		//driver.quit();
		
  }
}
