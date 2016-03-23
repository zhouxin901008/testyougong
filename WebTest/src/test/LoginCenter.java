package test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.ExcelWorkBook;

public class LoginCenter{
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		private String url="qa.dev.lsh123.com";
		String sourceFile="/Users/zhouxin/Downloads/生鲜测试点完整版5.xlsx";
		@BeforeClass
		public void testBefore(){
		//设置firefox浏览器
		}
		@Test
		public void login() throws Exception{
		//初始化ExcelWorkBook Class
		ExcelWorkBook excelbook=new ExcelWorkBook();
		//进入到你的测试界面
		navigation.to(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try{
			//把取出的username放在userlist集合里面
			List<String> userList=excelbook.readUsername(sourceFile);
			//把取出的password放在passlist集合里面
			List<String> passList=excelbook.readPassword(sourceFile);
			//把取出来的值，输入到界面的输入框中
			int usersize=userList.size();
			for(int i=0;i<usersize ;i++){
				//通过css定位到username输入框
				WebElement username=driver.findElement(By.cssSelector("input[name=\"j_username\"]"));
				//通过css定位到password输入框
				WebElement password=driver.findElement(By.cssSelector("input[name=\"j_password\"]"));
				//通过xpath定位登录按钮
				WebElement submit=driver.findElement(By.xpath("//button//span[contains(text(),'登录')]"));
				//清除username输入框的内容
				username.clear();
				//把list中数据一个一个的取出来
				String name=userList.get(i);
				//然后填写到username输入框
				username.sendKeys(name);
				for(int j=0;j<passList.size();j++){
					password.clear();
					String pass=passList.get(j);
					password.sendKeys(pass);
				}
				//点击登录按钮
				submit.click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				//通过xpath定位登出按钮
				WebElement logoutButton=driver.findElement(By.xpath("//button//span[contains(text(),'登出')]"));
				logoutButton.click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}