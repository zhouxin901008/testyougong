package lsh123.test;

import android.widget.TextView;
import Basic.test.BasicTestCase;
import Basic.test.Loginfo;

public class ForgetPasswordTest extends BasicTestCase{
	public void testForgetPassword(){
		solo.sleep(2000);
		solo.clickOnText("忘记密码?");
		solo.sleep(1000);
		assertTrue("手机号输入框默认文案不正确",solo.searchEditText("请输入手机号"));
		assertTrue("密码输入框默认文案不正确",solo.searchEditText("请输入密码"));
		assertTrue("验证码输入框默认文案不正确",solo.searchEditText("短信验证码"));
		//随机数
		int a = (int) (Math.random()*100000);
		System.out.println(a);
		solo.enterText(0, "1360116997");
		solo.enterText(1, ""+a);
		solo.enterText(2, ""+a);
		//验证清除按钮
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/phoneClear"));
		solo.enterText(0, "1360116997");
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/passwordClear"));
		solo.enterText(1, ""+a);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/codeClear"));
		solo.enterText(2, ""+a);
		solo.clickOnButton("修改密码");
		//验证手机号码格式
		assertTrue("获取的toast1不正确", solo.waitForText("请输入正确的手机号码"));
		Loginfo.writeToFile("忘记密码toast1测试通过");
		solo.sleep(500);
		solo.clearEditText(0);
		solo.enterText(0, "13601169971");
		solo.clickOnButton("修改密码");
		//验证密码格式
		assertTrue("获取的toast2不正确", solo.waitForText("密码必须是6-16位的字母或数字"));
		Loginfo.writeToFile("忘记密码toast2测试通过");
		solo.sleep(500);
		solo.clearEditText(1);
		solo.enterText(1, "00000000000000000");
		solo.clickOnButton("修改密码");
		assertTrue("获取的toast3不正确", solo.waitForText("密码必须是6-16位的字母或数字"));
		Loginfo.writeToFile("忘记密码toast3测试通过");
		solo.sleep(500);
		
		solo.clearEditText(1);
		solo.enterText(1, "000000");
		solo.clickOnButton("修改密码");
		//验证验证码格式
		assertTrue("获取的toast4不正确", solo.waitForText("验证码是6位数字"));
		Loginfo.writeToFile("忘记密码toast4测试通过");
		solo.sleep(500);
		solo.clearEditText(2);
		solo.enterText(2, "000000");
		solo.clickOnButton("修改密码");
		assertTrue("获取的toast5不正确", solo.waitForText("验证码不正确，请重试"));
		Loginfo.writeToFile("忘记密码toast5测试通过");
		solo.sleep(500);
		
		solo.clearEditText(2);
		solo.clickOnButton("获取验证码");
		solo.sleep(2000);
		String[] button = new String[2];
		for(int i=0;i<2;i++){
			TextView view = (TextView)solo.getView("com.elianshang.yougong:id/verify");
			button[i] = view.getText().toString();
			System.out.println(button[i]);
			solo.sleep(2000);
		}
		//验证获取验证码倒计时是否有变化
		assertFalse("获取验证码的倒计时没有变更",button[0].equals(button[1]));
		solo.sleep(3000);
		//信息全部填写正确，点击修改密码
		solo.clickOnButton("修改密码");
		assertTrue("获取的toast6不正确", solo.waitForText("密码修改成功"));
		Loginfo.writeToFile("忘记密码toast6测试通过");
		solo.sleep(1000);
		Loginfo.writeToFile("忘记密码模块测试通过");
		
	}
}
