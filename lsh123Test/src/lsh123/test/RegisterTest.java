package lsh123.test;

import com.robotium.solo.Solo;

import android.view.View;
import android.widget.TextView;
import Basic.test.BasicTestCase;
import Basic.test.Loginfo;

public class RegisterTest extends BasicTestCase{
	public void testRegister(){
		solo.sleep(2000);
		solo.clickOnButton("注册");
		solo.enterText(0, "1360116997");
		solo.enterText(1, "123");
		solo.enterText(2, "链商超市");
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/area"));
		solo.drag(1000,1000,1000,200,13);
		//View view1 = solo.getView("com.elianshang.yougong:id/region");
		//solo.scrollViewToSide(view1,Solo.UP,3);
		solo.sleep(1000);
		
		solo.clickOnButton("确定");
		solo.enterText(4, "上地三街信息大厦B座");
		//solo.enterText(5, "13466640320");
		solo.clickOnButton("下一步");
		//验证手机号码格式
		assertTrue("获取的toast1不正确", solo.waitForText("请输入正确的手机号码"));
		Loginfo.writeToFile("注册toast1测试通过");
		
		solo.clearEditText(0);
		solo.enterText(0, "13601169971");
		solo.clickOnButton("下一步");
		solo.sleep(1000);
		
		//设置密码页面
		assertTrue("密码输入框默认文案不正确",solo.searchEditText("请输入密码"));
		assertTrue("验证码输入框默认文案不正确",solo.searchEditText("短信验证码"));
		//随机数
		int a = (int) (Math.random()*100000);
		System.out.println(a);
		solo.enterText(0, ""+a);
		solo.enterText(1, ""+a);
		//验证清除按钮
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/passwordClear"));
		solo.enterText(0, ""+a);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/codeClear"));
		solo.enterText(1, ""+a);
		solo.clickOnButton("注册");
		//验证密码格式
		assertTrue("获取的toast2不正确", solo.waitForText("密码必须是6-16位的字母或数字"));
		Loginfo.writeToFile("注册toast2测试通过");
		solo.sleep(500);
		
		solo.clearEditText(0);
		solo.enterText(0, "000000");
		solo.clickOnButton("注册");
		//验证验证码格式
		assertTrue("获取的toast3不正确", solo.waitForText("验证码是6位数字"));
		Loginfo.writeToFile("注册toast3测试通过");
		solo.sleep(500);
		solo.clearEditText(1);
		solo.enterText(1, "000000");
		solo.clickOnButton("注册");
		solo.sleep(1000);
		assertTrue("获取的toast4不正确", solo.waitForText("验证码不正确,请重试"));
		Loginfo.writeToFile("注册toast4测试通过");
		solo.sleep(500);
		
		solo.clearEditText(1);
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
		solo.clickOnButton("注册");
		solo.sleep(4000);
		//assertFalse("没有直接进入首页，邀请码功能可能有问题",solo.searchText("注册信息已提交"));
		assertTrue("审核文案可能不正确",solo.searchText("注册信息已提交"));
		Loginfo.writeToFile("注册审核页面测试通过");
		solo.clickOnButton("知道了");
		
		//登录刚刚注册的账号
		solo.clearEditText(0);
		solo.enterText(0, "13601169971");
		solo.enterText(1, "000000");
		solo.clickOnButton("登录");
		assertTrue("审核文案可能不正确",solo.searchText("您的账号正在审核中,审核通过后,工作人员会在三个工作日内联系您"));
		Loginfo.writeToFile("注册审核toast测试通过");
		solo.clickOnButton("知道了");
		solo.sleep(1000);
		Loginfo.writeToFile("注册模块测试通过");

	}
}
