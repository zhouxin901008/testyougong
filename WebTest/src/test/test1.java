package test;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import WebTesting.BasicDriver;
	
public class test1{
	
	public static void main(String args[]){
		System.getProperties().setProperty("webdriver.chrome.driver", "/Users/zhouxin/Desktop/chromedriver");
	    WebDriver driver = new ChromeDriver();
	    Navigation navigation = driver.navigate();
	    navigation.to("http://baidu.com");
	    driver.findElement(By.id("kw")).sendKeys("111");
	    System.out.println(driver.findElement(By.xpath("//html")).getAttribute("outerHTML"));
			DecimalFormat df = new DecimalFormat("#.00");
			double a = 100.1111111;
			String c = df.format(a);
			System.out.println(c);
			int d = (int) (Math.random()*100000);
			System.out.println(d);
			ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.className("UIACollectionCell"));
		/*		
		String[] a = {"4","2","3"};
		System.out.println(a[2]);
		System.out.println(a[0]);
		String[] b = new String[]{"5","7","9"};
		System.out.println(b[2]);
		System.out.println(b[0]);
		*/
		
	}
}
