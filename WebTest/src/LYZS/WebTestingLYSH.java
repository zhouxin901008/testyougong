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

public class WebTestingLYSH {
  @Test
  public void LYSH() throws InterruptedException {
	  	String b[] = new String[]{"【QA联营招标测试】01.09回归test1"};
	  	WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		System.out.println("联营采购方审核报名测试流程开始");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方审核报名测试流程开始");
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
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[5]/div[1]/ul/li/table/tbody/tr/td[6]/a[2]")).click();
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[1]);
		System.out.println("查看审核状态:" + driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div[4]/ul/li/table/tbody/tr/td[3]/span")).getText());
		WebLog.writeToFile((dateFormat.format(date) + " " + "查看审核状态”:" + driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div[4]/ul/li/table/tbody/tr/td[3]/span")).getText()));
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[1]/div[2]/div[4]/ul/li/table/tbody/tr[1]/td[4]/a[1]")).click();
		Thread.sleep(1000);
		System.out.println("审核状态变为:" + driver.findElement(By.xpath("//span[@class='status-approve']")).getText());
		WebLog.writeToFile((dateFormat.format(date) + " " + "审核状态变为:" + driver.findElement(By.xpath("//span[@class='status-approve']")).getText()));
		System.out.println("联营采购方审核报名测试流程结束");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方审核报名测试流程结束");
		WebLog.writeToFile("———————————————————————————————————————————————————————————————————————");
		driver.quit();
  }
}
