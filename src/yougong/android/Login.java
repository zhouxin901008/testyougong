package yougong.android;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.AndroidBasic;
import io.appium.java_client.android.AndroidDriver;

public class Login extends AndroidBasic{	
	
	@BeforeClass
	public void setUp() throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "SM_G9250");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "04157df47a9d263a");
		capabilities.setCapability("Package", "com.elianshang.yougong");
		capabilities.setCapability("Activity", "com.elianshang.yougong.ui.activity.WelcomeActivity");
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		wd = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		wd.quit();
	}
	
	@Test
	public void logintest() {
		wd.findElementsById("com.elianshang.yougong:id/tab_icon").get(3).click();
		wd.findElementById("com.elianshang.yougong:id/logoutTextView").click();
		WebElement cellphone = wd.findElementById("com.elianshang.yougong:id/phone");
		WebElement password = wd.findElementById("com.elianshang.yougong:id/password");
		cellphone.click();
		String cellphoneText = cellphone.getAttribute("text");
		String passwordText = cellphone.getAttribute("text");
		if(cellphone.getText()!="请输入手机号"){
			clearText(cellphoneText);
		}
        cellphone.sendKeys("13466640320");
        int a = (int) (Math.random()*100000);
        password.sendKeys(""+a);
        wd.findElementById("com.elianshang.yougong:id/login").click();
        //waitForElement(By.partialLinkText("账户或者密码错误,请重新登录"),4,wd);
        if(wd.findElementByClassName("android.widget.TextView").getText().equals("登录")){
        	System.out.println("登录失败");
        	AndroidBasic.takeScreenshots();
        }
        clearText(passwordText);
        password.sendKeys("000000");
        wd.findElementById("com.elianshang.yougong:id/login").click();
        if(wd.findElementByClassName("android.widget.TextView").getText().equals("我的")){
        	System.out.println("登录成功");
        }
	}

}