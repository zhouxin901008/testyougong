package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.common.base.Verify;


public class practicetest {
	public static void main(String[] args) throws InterruptedException {
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		FirefoxDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		driver.manage().window().maximize();
		navigation.to("http://qa.lsh123.com/bidding");
		Thread.sleep(1000);
		/*
		WebElement move = driver.findElement(By.id("loginChildName"));
		Actions action = new Actions(driver);
		//模拟左键点击
		action.moveToElement(move).click().perform();
		//模拟tab操作
		action.sendKeys(Keys.TAB);
		//模拟右键点击
		action.moveToElement(move).contextClick().perform();
		System.out.println("123");
		WebLog.writeToFile(dateFormat.format(date)+" "+driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date)+" "+"4567777");
		
		driver.findElement(By.id("loginChildName")).sendKeys(new String[] {"admin"});
		driver.findElement(By.id("loginUserName")).sendKeys(new String[] {"wumart"});
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		driver.findElement(By.linkText("我的联营招商项目")).click();
		driver.findElement(By.id("searchTitle")).sendKeys(new String[] {"【QA联营招标测试】11.5test1"});
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[5]/div[1]/ul/li/table/tbody/tr/td[6]/a[1]")).click();
		Thread.sleep(2000); 
		//driver.findElement(By.cssSelector("a[2]")).click();
		driver.switchTo().frame("st-content-iframe");
		//driver.switchTo().defaultContent();
		driver.findElement(By.linkText("查看招商结果公告")).click();
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		for(int a=0;a<handles.length;a++)
			System.out.println(handles[a]);
		driver.switchTo().window(handles[1]);
		//进入招商结果公告页面
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + driver.getTitle());		
		System.out.println("联营采购方查看报名评议测试流程结束");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方查看报名评议测试流程结束");
		//断言练习
		driver.switchTo().frame("st-content-iframe");
		Assert.assertEquals("【QA联营招标测试】11.5test1 入选公示",driver.getTitle());
		Verify.verify(driver.findElement(By.xpath("/html/body/div/h3")).getText().contains("【QA联营招标测试】11.5test1招商结果公告"),"公告标题错误");
		Assert.assertFalse(driver.getTitle().isEmpty(),"title为空");
		Assert.assertTrue(driver.getTitle().contains("【QA联营招标测试】11.5test1 入选公示"), "title文案错误");
		*/
		driver.findElement(By.id("loginChildName")).sendKeys(new String[] {"admin"});
		driver.findElement(By.id("loginUserName")).sendKeys(new String[] {"wumart"});
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		driver.findElement(By.linkText("我的自营招商项目")).click();
		driver.findElement(By.id("searchTitle")).sendKeys(new String[] {"U98U98U98U98U98U98U98U98"});
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[1][@class='operations']")).click();
		if(driver.findElement(By.xpath("//button[@class='btn set-end btn-primary']")).getText().contains("开始")){
			driver.findElement(By.xpath("//button[@class='btn set-end btn-primary']")).click();
			driver.findElement(By.xpath("//input[@class='minutes form-control']")).sendKeys("5");
			driver.findElement(By.cssSelector("html body.modal-open div.l-flow-con.l-flow-con-fold.clearfix div.l-right-con.l-right-con-expanded div#signupList.mod-signup-list div.modal.fade.modal-set-end.in div.modal-dialog div.modal-content div.modal-footer button.btn.btn-primary.confirm")).click();
			Thread.sleep(1000);
			/*
			WebElement time1 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t1 = time1.getText();
			WebElement time2 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t2 = time2.getText();
			Thread.sleep(5000);
			WebElement time3 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t3 = time3.getText();
			//System.out.println(t1);
			//System.out.println(t2);
			//Thread.sleep(5000);
			//System.out.println(t3);
			Assert.assertNotEquals(t2,t1,"出现错误，获取的时间一样");
			*/
			
			//数组判断抓取两次时间，查看取到的时间是否不同
			String[] time = new String[2];
			for(int i=0;i<2;i++){
				time[i] = driver.findElement(By.xpath("//div[@class='count-item  count']")).getText();
				System.out.println(time[i]);
				Thread.sleep(5000);
				}
			Assert.assertNotEquals(time[0],time[1],"出现错误，获取的时间一样");
			System.out.println("两次获取的时间不一样，测试通过");
			}
		else {
			driver.findElement(By.xpath("//button[@class='btn set-pause btn-primary']")).click();
			driver.findElement(By.cssSelector("html body.modal-open div.l-flow-con.l-flow-con-fold.clearfix div.l-right-con.l-right-con-expanded div#signupList.mod-signup-list div.modal.fade.modal-set-pause.in div.modal-dialog div.modal-content div.modal-footer button.btn.btn-primary.confirm")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn set-end btn-primary']")).click();
			driver.findElement(By.xpath("//input[@class='minutes form-control']")).sendKeys("5");
			driver.findElement(By.cssSelector("html body.modal-open div.l-flow-con.l-flow-con-fold.clearfix div.l-right-con.l-right-con-expanded div#signupList.mod-signup-list div.modal.fade.modal-set-end.in div.modal-dialog div.modal-content div.modal-footer button.btn.btn-primary.confirm")).click();
			Thread.sleep(1000);
			WebElement time1 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t1 = time1.getText();
			WebElement time2 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t2 = time2.getText();
			Thread.sleep(5000);
			WebElement time3 = driver.findElement(By.xpath("//div[@class='count-item  count']"));
			String t3 = time3.getText();
			//System.out.println(t1);
			//System.out.println(t2);
			//Thread.sleep(5000);
			//System.out.println(t3);
			Assert.assertNotEquals(t3,t1,"出现错误，获取的时间一样");
			
		
		}
		
	}
}
