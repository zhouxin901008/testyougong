package yougong.android;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.AndroidBasic;
import io.appium.java_client.android.AndroidDriver;

public class My extends AndroidBasic{	
	
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
	public void mytest() throws InterruptedException {
		wd.findElementsById("com.elianshang.yougong:id/tab_icon").get(3).click();
		//检验全部订单入口文案
		Assert.assertTrue("“全部订单”入口文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[2]/android.widget.TextView[1]").getText().equals("全部订单"));
		//进入我的订单页面
		wd.findElementsByClassName("android.widget.RelativeLayout").get(2).click();
		Assert.assertTrue("“我的订单”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("我的订单"));
		Assert.assertTrue("订单价格为空",wd.findElementById("com.elianshang.yougong:id/order_item_total_price").getText()!=null);
		Assert.assertTrue("下单时间为空",wd.findElementById("com.elianshang.yougong:id/order_item_time").getText()!=null);
		Assert.assertTrue("货到付款文案异常",wd.findElementByXPath("//android.widget.RelativeLayout[2]/android.widget.TextView[1]").getText().equals("货到付款"));

		if(AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/order_item_state_cancel")) 
				|| wd.findElementById("com.elianshang.yougong:id/order_item_state_text").getText().equals("待收货")
				|| wd.findElementById("com.elianshang.yougong:id/order_item_state_text").getText().equals("已完成")
				|| wd.findElementById("com.elianshang.yougong:id/order_item_state_text").getText().equals("已取消")){
			//进入订单详情
			wd.findElementById("com.elianshang.yougong:id/order_item_main").click();
			Assert.assertTrue("“订单详情”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("订单详情"));
			String status = wd.findElementById("com.elianshang.yougong:id/order_detail_state_value").getText();
			switch(status){
			case "待发货":
				Assert.assertTrue("订单状态与取消订单按钮对应不上",AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/order_cancel_btn")));
				Assert.assertTrue("取消订单按钮文案异常",wd.findElementById("com.elianshang.yougong:id/order_cancel_btn").getText().equals("取消订单"));
				System.out.println("该订单状态为“待发货”");
				break;
			case "待收货":
				AndroidBasic.swipeToDown(1000);
				Assert.assertTrue("订单状态与支付按钮对应不上",AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/footer_pay_btn")));
				Assert.assertTrue("支付按钮文案异常",wd.findElementById("com.elianshang.yougong:id/footer_pay_btn").getText().equals("确定收货并支付"));
				System.out.println("该订单状态为“待收货”");
				break;
			case "已取消":
				Assert.assertTrue("订单状态与再次购买按钮对应不上",AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/order_rebuy_btn")));
				Assert.assertTrue("再次购买按钮文案异常",wd.findElementById("com.elianshang.yougong:id/order_rebuy_btn").getText().equals("再次购买"));
				System.out.println("该订单状态为“已取消”");
				break;
			case "已完成":
				Assert.assertTrue("订单状态与再次购买按钮对应不上",AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/order_rebuy_btn")));
				Assert.assertTrue("再次购买按钮文案异常",wd.findElementById("com.elianshang.yougong:id/order_rebuy_btn").getText().equals("再次购买"));
				System.out.println("该订单状态为“已完成”");
				break;
			default:
				System.out.println("订单状态异常");
				AndroidBasic.takeScreenshots();
			}
		}
		else{
			System.out.println("订单状态文案异常");
			AndroidBasic.takeScreenshots();
		}
		Assert.assertTrue("订单号异常",wd.findElementById("com.elianshang.yougong:id/order_detail_orderid").getText().contains("订单号："));
		Assert.assertTrue("下单时间为空",wd.findElementById("com.elianshang.yougong:id/order_detail_time")!=null);
		Assert.assertTrue("下单地址为空",wd.findElementById("com.elianshang.yougong:id/header_address")!=null);
		Assert.assertTrue("支付方式为空",wd.findElementById("com.elianshang.yougong:id/paytype_show_layout")!=null);
		Assert.assertTrue("配送详情按钮文案异常",wd.findElementById("com.elianshang.yougong:id/order_list_item_more_expand").getText().equals("查看详情"));
		wd.findElementById("com.elianshang.yougong:id/order_list_item_more_expand").click();
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		AndroidBasic.swipeToDown(1000);
		
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		
		//检验地址管理入口文案
		Assert.assertTrue("“地址管理”入口文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[3]/android.widget.TextView[1]").getText().equals("地址管理"));
		//进入地址管理页面
		wd.findElementsByClassName("android.widget.RelativeLayout").get(3).click();
		Assert.assertTrue("“地址管理”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("选择收货地址"));
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		
		//检验地址管理入口文案
		Assert.assertTrue("“优惠券”入口文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[4]/android.widget.TextView[1]").getText().equals("优惠券"));
		//进入地址管理页面
		wd.findElementsByClassName("android.widget.RelativeLayout").get(4).click();
		Assert.assertTrue("“优惠券”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("优惠券"));
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		
		//检验链商客服入口文案
		Assert.assertTrue("“链商客服”文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[5]/android.widget.TextView[1]").getText().equals("链商客服"));
		//点击链商客服
		wd.findElementsByClassName("android.widget.RelativeLayout").get(5).click();
		Assert.assertTrue("“地址管理”页面标题有问题",wd.findElementById("android:id/message").getText().equals("确认需要拨打客服电话(400-999-0328)"));
		Assert.assertTrue("“确认”按钮文案异常",wd.findElementById("android:id/button1").getText().equals("确认"));
		Assert.assertTrue("“取消”按钮文案异常",wd.findElementById("android:id/button2").getText().equals("取消"));
		wd.findElementById("android:id/button2").click();
		
		//检验意见反馈入口文案
		Assert.assertTrue("“意见反馈”文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[6]/android.widget.TextView[1]").getText().equals("意见反馈"));
		//进入意见反馈页面
		wd.findElementsByClassName("android.widget.RelativeLayout").get(6).click();
		Assert.assertTrue("“意见反馈”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("意见反馈"));
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		
		//检验检查更新文案
		Assert.assertTrue("“检查更新”文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[7]/android.widget.TextView[1]").getText().equals("检查更新"));
		//点击检查更新
		wd.findElementsByClassName("android.widget.RelativeLayout").get(7).click();
		
		//检验关于链商入口文案
		Assert.assertTrue("“关于链商”文案有问题",wd.findElementByXPath("//android.widget.RelativeLayout[8]/android.widget.TextView[1]").getText().equals("关于链商"));
		//进入关于链商页面
		wd.findElementsByClassName("android.widget.RelativeLayout").get(8).click();
		Assert.assertTrue("“关于链商”页面标题有问题",wd.findElementsByClassName("android.widget.TextView").get(0).getText().equals("关于"));
	
		wd.findElementByXPath("//android.view.View[1]/android.widget.ImageButton[1]").click();
		
		
		
	}
}