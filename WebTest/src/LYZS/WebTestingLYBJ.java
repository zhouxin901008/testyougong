package LYZS;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import WebTesting.BasicDriver;
import WebTesting.WebLog;

public class WebTestingLYBJ {
  @Test
  public static void LYBJ() throws InterruptedException {
	  	Double a[] = new Double[]{500.5,85.3,600.3};
	  	String b[] = new String[]{"【QA联营招标测试】01.09回归test1"};
	  	WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		System.out.println("联营报价测试流程开始");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营报价测试流程开始");
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
		driver.findElement(By.linkText("已报名联营招商项目")).click();
		driver.findElement(By.id("searchTitle")).sendKeys(b[0]);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div/ul/li/table/tbody/tr/td[6]/a")).click();
		driver.findElement(By.id("pass")).sendKeys("883459");
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/button[2]")).click();
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + "进入页面:" + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='select-all']")).click();
		driver.findElement(By.xpath("//input[@data-key='1001']")).clear();
		driver.findElement(By.xpath("//input[@data-key='1001']")).sendKeys(""+a[0]);
		driver.findElement(By.xpath("//input[@data-key='1002']")).clear();
		driver.findElement(By.xpath("//input[@data-key='1002']")).sendKeys(""+a[1]);
		driver.findElement(By.xpath("//input[@data-key='1004']")).clear();
		driver.findElement(By.xpath("//input[@data-key='1004']")).sendKeys(""+a[2]);
		//输出预估入选含税销售折扣额
		System.out.println(LYCalculate.hszk(a[1],a[2]));
		driver.findElement(By.xpath("//button[@class='btn btn-primary bid-btn']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default confirm btn-lg']")).click();
		System.out.println("联营供应商报价测试流程结束");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营供应商报价测试流程结束");
		WebLog.writeToFile("———————————————————————————————————————————————————————————————————————");
		driver.quit();
		
	
  }
}
