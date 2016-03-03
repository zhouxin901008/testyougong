package lsh123.test;

import Basic.test.BasicTestCase;
import Basic.test.Loginfo;

public class LoginTest extends BasicTestCase{
	public void testlogin(){
		solo.sleep(1000);
		solo.clearEditText(0);
		assertTrue("手机号输入框默认文案不正确",solo.searchEditText("请输入手机号"));
		assertTrue("密码输入框默认文案不正确",solo.searchEditText("请输入密码"));
		//随机数
		int a = (int) (Math.random()*100000);
		int b = (int) (Math.random()*100000000);
		System.out.println(a);
		System.out.println(b);
		//手机号格式不正确
		solo.clearEditText(0);
		solo.enterText(0, "1346664032");
		solo.enterText(1, ""+a);
		//验证清除按钮
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/phoneClear"));
		solo.enterText(0, "1346664032");
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/passwordClear"));
		solo.enterText(1, ""+a);
		solo.clickOnButton("登录");
		assertTrue("获取的toast1不正确", solo.waitForText("请输入正确的手机号码"));
		Loginfo.writeToFile("登录toast1测试通过");
		
		//密码格式不正确
		solo.clearEditText(0);
		solo.enterText(0, "13466640320");
		solo.clickOnButton("登录");
		assertTrue("获取的toast2不正确", solo.waitForText("密码必须是6-16位的字母或数字"));
		solo.sleep(1000);
		Loginfo.writeToFile("登录toast2测试通过");
		
		//密码格式不正确
		solo.clearEditText(1);
		solo.enterText(1, "00000000000000000000");
		solo.clickOnButton("登录");
		assertTrue("获取的toast3不正确", solo.waitForText("密码必须是6-16位的字母或数字"));
		solo.sleep(1000);
		Loginfo.writeToFile("登录toast3测试通过");
		
		//密码格式正确，但内容错误
		solo.clearEditText(1);
		solo.enterText(1, ""+b);
		solo.clickOnButton("登录");
		assertTrue("获取的toast4不正确", solo.waitForText("账户或者密码错误,请重新登录"));
		solo.sleep(1000);
		Loginfo.writeToFile("登录toast4测试通过");
		
		//密码正确
		solo.clearEditText(1);
		solo.enterText(1, "000000");
		solo.clickOnButton("登录");
		solo.sleep(1000);
		Loginfo.writeToFile("登录模块测试通过");
	}

}
