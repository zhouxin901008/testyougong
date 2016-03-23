package Basic;


import java.io.File;
import java.io.IOException;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class iOSBasic {
	public static IOSDriver wd;
		//判断元素是否存在
		public static boolean isElementExist(By by){  
		    try{
		    	wd.findElement(by);
		    	return true;
		    }catch(Exception e){
		        return false;  
		    }                         
		}
		
		//抓toast
		public static WebElement waitForElement(By by, int timeout, WebDriver driver) {
		    WebDriverWait wait = new WebDriverWait(driver, timeout);
		    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		    return element;
		  }
		
		//判断ClassName是否存在
		public static boolean findElementsByClassName(String classname,int a){  	
			try{
				wd.findElementsByClassName(classname).get(a);
				return true;
			}catch(Exception e){
				System.out.println("此商品的商品信息中缺少部分数据");
				iOSBasic.takeScreenshots();
				return false;			
			}                         
		}
		
		//截图存放到本地
		public static void takeScreenshots(){
			File screen = wd.getScreenshotAs(OutputType.FILE);
			File screenFile = new File("/Users/zhouxin/Desktop");
			try {
				FileUtils.copyFile(screen, screenFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//滑动屏幕
		 public static void swipeToUp(IOSDriver wd, int during){
			 int width = wd.manage().window().getSize().width;
			 int height = wd.manage().window().getSize().height;
		     wd.swipe(width*1/2, height*1/4, width*1/2, height*3/4, during);
		 }
		 public static void swipeToDown(int during){
			 int width = wd.manage().window().getSize().width;
			 int height = wd.manage().window().getSize().height;
			 wd.swipe(width*1/2, height*3/4, width*1/2, height*1/4, during);
		 }
		 public static void swipeToLeft(IOSDriver wd, int during){
		     int width = wd.manage().window().getSize().width;
		     int height = wd.manage().window().getSize().height;
		     wd.swipe(width*1/4, height*1/2, width*3/4, height*1/2, during);
		 }
		 public static void swipeToRight(IOSDriver wd, int during){
			 int width = wd.manage().window().getSize().width;
			 int height = wd.manage().window().getSize().height;
			 wd.swipe(width*3/4, height*1/2, width*1/4, height*1/2, during);
		 }
		 
		//水平拖动控件
		 public void swipeView(String Name,int moveX,int duration){
			 int startX=wd.findElementByName(Name).getLocation().getX();
		     System.out.println("当前对象的X坐标"+startX);
		     int startY=wd.findElementByName(Name).getLocation().getY();
		     System.out.println("当前对象的Y坐标"+startY);
		     int toX = startX+moveX;
		     int toY = startY;
		     wd.swipe(startX,startY,toX,toY,duration);
		     /*int startX1=wd.findElementByName(Name).getLocation().getX();
		     System.out.println(toX+"+"+startX1);
		     while (startX1!=toX){
		       	wd.swipe(startX1,startY,toX,toY,duration);
		       	int startX11=wd.findElementByName(Name).getLocation().getX();
		     	startX1=startX11;
		     	}*/
		 }
}