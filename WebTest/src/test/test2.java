package test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import WebTesting.BasicDriver;

public class test2 extends BasicDriver{
		public static void main(String[] args) throws InterruptedException{
			BasicDriver.open();
			//登录
			BasicDriver.sendKeys(By.id("loginChildName"), "QAtest");
			BasicDriver.sendKeys(By.id("loginUserName"), "QAtest");
			WebElement lsh = driver.findElement(By.id("loginPassword"));
			lsh.sendKeys(new String[] {"123456"});
			lsh.submit();
			Thread.sleep(1000);
			BasicDriver.click(By.linkText("商品管理"));
			BasicDriver.click(By.linkText("商品列表"));
			Thread.sleep(1000);
			driver.findElements(By.linkText("编辑")).get(2).click();
			BasicDriver.windows(1);
			Thread.sleep(1000);
				//关联证照
			//List<WebElement> list =  driver.findElements(By.className("operations"));
			ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.className("operations"));
			System.out.println(list.size());
			for(int n=0;n<list.size();n++){
				while(driver.findElements(By.xpath("//a[@class='operations']")).get(n).getText().contentEquals("提交")){
					BasicDriver.click(By.linkText("提交"));
				if(BasicDriver.isElementExist(By.xpath("/html/body/div[3]/div[2]/div[2]/a"))){
					BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div[2]/a"));
					BasicDriver.click(By.className("list-radio"));
					BasicDriver.click(By.xpath("//button[@class='btn btn-primary btn-lg submit']"));
				}
				else{
					if(driver.findElement(By.xpath("//div[@class='certify-container certify-form']")).getText().contentEquals("绿色食品证书")){
						String filePath = "/Users/zhouxin/Desktop/123.jpg";
						driver.findElement(By.xpath("//*[@id='certifyForm']/div[2]/div/div/div[4]/div/div[2]/div/form/input[2]")).sendKeys(filePath);
					}
					String filePath = "/Users/zhouxin/Desktop/123.jpg";
					driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/form/input[2]")).sendKeys(filePath);
				}
				Thread.sleep(1000);
			}
		}
		BasicDriver.click(By.xpath("//button[@class='finish btn btn-primary']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div/div[3]/button[1]")).click();
		driver.close();
		}
}
