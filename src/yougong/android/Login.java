package yougong.android;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.AndroidBasic;
import Basic.ExcelWorkBook;

public class Login extends AndroidBasic{	
	
	@BeforeClass
	public void setUp() throws Exception{
		AndroidBasic.prepareAndroidForAppium();
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
		//初始化ExcelWorkBook Class
		ExcelWorkBook excelbook=new ExcelWorkBook();
		try{
			//把取出的username放在userlist集合里面
			List<String> userList=excelbook.readUsername("/Users/zhouxin/Documents/workspace/yougong/users.xls");
			//把取出的password放在passlist集合里面
			List<String> passList=excelbook.readPassword("/Users/zhouxin/Documents/workspace/yougong/users.xls");
			int usersize = userList.size();
			int passwordsize = passList.size();
			for(int i=0,j=0;i<usersize&&j<passwordsize;i++,j++){
				//从list中取cellphone，填写到cellphone输入框中
				String phone=userList.get(i);
				cellphone.sendKeys(phone);
				//从list中取password，填写到password输入框中
				String pass=passList.get(j);
				password.sendKeys(pass);
				//点击登录
				wd.findElementById("com.elianshang.yougong:id/login").click();
				if(wd.findElementByClassName("android.widget.TextView").getText().equals("登录")){
					System.out.println("手机号:" + phone + ",密码:"+ pass + ",登录失败");
					AndroidBasic.takeScreenshots();
					clearText(cellphoneText);
					clearText(passwordText);
				}  
				else{
					System.out.println("手机号:" + phone + ",密码:"+ pass + ",登录成功");
				}
			}		
		}
		catch(Exception e){
			e.printStackTrace();
			}
		}
}