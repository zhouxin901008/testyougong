package yougong.ios;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import Basic.iOSBasic;
import io.appium.java_client.ios.IOSDriver;

public class CommodityTest extends iOSBasic{	
	@Before
	public void setUp() throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 5");
		capabilities.setCapability("platformVersion", "7.0.4");
		capabilities.setCapability("platformName", "iOS");
		//capabilities.setCapability("browserName", "safari");
		capabilities.setCapability("app", "com.lianshang.Market");
		wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
	
	@Test
	public void test() throws Exception {
		if(wd.findElementByClassName("UIAStaticText").getText().equals("登录")){
			//输入手机号
			System.out.println(wd.findElementByClassName("UIATextField").getText());
			wd.findElementByClassName("UIATextField").sendKeys("13466640320");
			System.out.println(wd.findElementByClassName("UIATextField").getText());
			//输入密码
			System.out.println(wd.findElementByClassName("UIASecureTextField").getText());
			wd.findElementByClassName("UIASecureTextField").sendKeys("000000");
			System.out.println(wd.findElementByClassName("UIASecureTextField").getText());
			wd.findElement(By.name("完成")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[20]")).click();
			Thread.sleep(3000);
			Assert.assertEquals("链商优供",wd.findElementByClassName("UIAStaticText").getText());
			System.out.println("已进入首页，登录测试通过");
			Thread.sleep(2000);		
		}
		wd.findElementByAccessibilityId("分类").click();
		//获取所有品类数量
		List<WebElement> TableCell = wd.findElementsByClassName("UIATableCell");
		System.out.println("所有品类数量为："+TableCell.size());
		int i=1;
		while(i<TableCell.size()){
			//获取一页的商品数量
			List<WebElement> CollectionCell = wd.findElementsByClassName("UIACollectionCell");
			System.out.println("每一页的商品数量为："+CollectionCell.size());
			for(int j=0,m=1;j<CollectionCell.size()&&m<=CollectionCell.size();j++,m++){
				//测试增加按钮功能
				String quantities1 = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText();
				System.out.println(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText());
				wd.findElementsByAccessibilityId("add icon").get(j).click();
				String quantities2 = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText();
				System.out.println(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText());
				if(quantities1.equals(quantities2)){
					System.out.println("增加至购物车的按钮没有生效");
				}
				//测试减少按钮功能
				wd.findElementsByAccessibilityId("subtract icon").get(j).click();
				String quantities3 = wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText();
				System.out.println(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell["+m+"]/UIAStaticText[3]").getText());
				if(quantities3.equals(quantities2)){
					System.out.println("减少至购物车的按钮没有生效");
				}
				//进入商品详情页
				wd.findElementsByClassName("UIACollectionCell").get(j).click();
				System.out.println(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText());
				iOSBasic.swipeToDown(500);
				if(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText().contains("满减")
						||wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText().contains("特价")){
					for(int a=0;a<10;a++){
						iOSBasic.findElementsByClassName("UIATableCell", a);
					}
				}
				else{
					for(int a=0;a<9;a++){
						iOSBasic.findElementsByClassName("UIATableCell", a);
					}
				}
				wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
				//滑动列表，iphone5第三个商品无法展示全
				int width = wd.manage().window().getSize().width;
				int height = wd.manage().window().getSize().height;
				wd.swipe(width*1/2, height*4/5, width*1/2, height*2/5, 1000);
				if(j==9){
					Thread.sleep(1000);
					iOSBasic.swipeToDown(500);
					List<WebElement> CollectionCell2 = wd.findElementsByClassName("UIACollectionCell");
					for(int k=10;k<CollectionCell2.size();k++){
						wd.findElementsByClassName("UIACollectionCell").get(k).click();
						System.out.println(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText());
						iOSBasic.swipeToDown(500);
						//验证详情页是否缺少商品信息
						if(wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText().contains("满减")
								||wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").getText().contains("特价")){							
							for(int b=0;b<10;b++){
								iOSBasic.findElementsByClassName("UIATableCell", b);
							}
						}
						else{
							for(int b=0;b<9;b++){
								iOSBasic.findElementsByClassName("UIATableCell", b);
							}
						}
						wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
						Thread.sleep(1000);
					}
				}
			}
			wd.findElementsByClassName("UIATableCell").get(i).click();
			i++;
		}
		/*
		List<WebElement> focus =  wd.findElementsByClassName("");
		//滑动焦点图
		for(int i=0;i<focus.size();i++){
			int width = wd.manage().window().getSize().width;
			int height = wd.manage().window().getSize().height;
			wd.swipe(width*3/4, height*1/4, width*1/4, height*1/4, 1000);
		}
		*/
		//wd.lockScreen(5);

	}
	
}
