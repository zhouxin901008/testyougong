package Basic;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.apache.commons.io.FileUtils;


public class BasicDriver{
	
	public static WebDriver driver = new FirefoxDriver();
	public static Navigation navigation = driver.navigate();	
	

	//启动浏览器进入指定网址，最大化浏览器
	public static void open() throws InterruptedException{
		navigation.to("http://dev.market-mis.dev.lsh123.com");
		driver.manage().window().maximize();
		
	}
	//登录
	public static void login() throws InterruptedException{
		driver.findElement(By.name("email")).sendKeys("admin@lsh123.com");
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("654321");
		password.submit();
		Thread.sleep(1000);
	}
	
	//判断元素是否存在
	public static boolean isElementExist(By by){  
	    try{
	    	driver.findElement(by);
	    	return true;
	    }catch(Exception e){
	        return false;  
	    }                   
	      
	} 
	
	//屏幕截图
	public static void takeScreenshots(String path){
	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//窗口切换
	public static void windows(int i){
		String[] handles = new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[i]);
	}
	
	//时间方法
	public static String time(){
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	//输入文案
	public static void sendKeys(By by,String keys){	
		driver.findElement(by).sendKeys(keys);
	}
	
	//点击
	public static void click(By by){	
		WebElement c = driver.findElement(by);
		if(c!=null){
			c.click();
		}
		else
			Assert.fail("没有找到该元素");
	}


	//获得某元素的文本描述信息
	public static String getElementText(By by){
		try{
			return driver.findElement(by).getText();
		}catch(NoSuchElementException e){
			return "Text does not exist!";	
		}
	}
	
    /*
     *** 某些元素由于属于某个iframe的需要先定义到frame然后再在此frame里边查找该元素
     *** 此方法适合定位文本链接型元素
     */
	public static void frame(By by,String text){
	    	WebElement element = driver.switchTo().frame(text).findElement(by);
	    	element.click();
	}
	
	 /*
     *** 某些元素由于属于某个iframe的需要先定义到frame然后再在此frame里边查找该元素
     *** 此方法适合定位文本输入框型元素
     */
	public static void frameElementSendKey(By by,String text){
			WebElement element = driver.switchTo().frame(text).findElement(by);
			element.sendKeys(text);
	}

	
	
}
