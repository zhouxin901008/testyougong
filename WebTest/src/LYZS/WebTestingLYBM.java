package LYZS;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import WebTesting.WebLog;

public class WebTestingLYBM {
  @Test
  public void LYBJ() throws InterruptedException {
	  	String b[] = new String[]{"【QA联营招标测试】01.09回归test1"};
	  	WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		System.out.println("联营供应商报名测试流程开始");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营供应商报名测试流程开始");
		//最大化浏览器
		driver.manage().window().maximize();
		navigation.to("http://dev.lsh123.com/bidding");
		Thread.sleep(1000);
		driver.findElement(By.id("loginChildName")).sendKeys(new String[] {"QAtest"});
		driver.findElement(By.id("loginUserName")).sendKeys(new String[] {"QAtest"});
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		driver.findElement(By.linkText("招商管理")).click();
		driver.findElement(By.linkText("所有联营招商项目")).click();
		driver.findElement(By.id("searchTitle")).sendKeys(b[0]);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[2]/div[2]/ul/li/table/tbody/tr/td[1]/a")).click();
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[1]);
		driver.findElement(By.xpath("//input[@value='4063982820518717431,4383175584595159517,4030487540629746887']")).click();
		driver.findElement(By.xpath("//button[@name='bidding_id']")).click();
		Thread.sleep(1000);
		System.out.println("报名状态是否变为“待审核”:" + driver.findElement(By.cssSelector("html body div.l-flow-con.clearfix div.l-right-con div#tenderView.mod-tender-view div.action-panel")).getText().contains("待审核"));
		WebLog.writeToFile(dateFormat.format(date) + " " + "报名状态是否变为“待审核”:" + driver.findElement(By.cssSelector("html body div.l-flow-con.clearfix div.l-right-con div#tenderView.mod-tender-view div.action-panel")).getText().contains("待审核"));
		System.out.println("联营供应商报名测试流程结束");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营供应商报名测试流程结束" );
		WebLog.writeToFile("———————————————————————————————————————————————————————————————————————");
		driver.quit();	
  }
}
