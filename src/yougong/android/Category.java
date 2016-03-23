package yougong.android;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.AndroidBasic;

public class Category extends AndroidBasic{
	
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
	public void CommodityTest() throws InterruptedException{
		wd.findElementsById("com.elianshang.yougong:id/tab_icon").get(1).click();
		//计算分类列表中分类个数
		List<WebElement> category = wd.findElementsById("com.elianshang.yougong:id/text");
		System.out.println("当前分类数为：" + category.size());
		for(int i=1;i<category.size();i++){
			wd.findElementsById("com.elianshang.yougong:id/text").get(i).click();
			//计算商品列表中商品个数
			List<WebElement> commodity = wd.findElementsById("com.elianshang.yougong:id/textLayout");
			System.out.println("当前分类中商品数为：" + commodity.size());
			for(int j=0,a=1;j<commodity.size()-1&&a<=7;j++,a++){
				//商品为0，跳出当前for循环
				if(commodity.size()==0){
					System.out.println("该分类中没有商品");
					AndroidBasic.takeScreenshots();
					break;
				}
				if(AndroidBasic.isElementExist(By.id("com.elianshang.yougong:id/net_error_btn"))){
					System.out.println("网络不好");
					//点击刷新重试
					wd.findElementById("com.elianshang.yougong:id/net_error_btn");
				}
				//打印商品名称
				String name = wd.findElementsById("com.elianshang.yougong:id/nameTextView").get(j).getText();
				System.out.print(wd.findElementsById("com.elianshang.yougong:id/nameTextView").get(j).getText() + " ");
				//打印价格
				String price = wd.findElementsById("com.elianshang.yougong:id/priceTextView").get(j).getText();
				System.out.print(wd.findElementsById("com.elianshang.yougong:id/priceTextView").get(j).getText() + " ");
				if(AndroidBasic.isElementExist(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.TextView[1]"))){
					if(AndroidBasic.isElementExist(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.TextView[2]"))){
						System.out.println("该商品为"+ wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.TextView[1]").getText() +"且售罄商品");
						break;
					}
					else{
						if(wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.TextView[1]").getText().equals("售罄")){
						System.out.println("该商品为售罄商品");	
						break;
						}
						else{
						//打印标签
						System.out.println("该商品为"+ wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.TextView[1]").getText() +"商品");
						break;
						}
					}
				}	
				else{
					String[] num = new String[4];
					for(int k=0;k<2;k++){
						wd.findElementsById("com.elianshang.yougong:id/addImageView").get(j).click();
						num[k] = wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
						System.out.print(num[k] + " ");
					}
					if(num[0].equals(num[1])){
						System.out.print("增加按钮功能可能存在问题或该商品超过最大限购量" + " ");
						AndroidBasic.takeScreenshots();
					}
					else{
						System.out.print("增加按钮功能正常" + " ");
					}
					//点击减少按钮
					wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.LinearLayout[2]/android.widget.ImageView[1]").click();
					/*判断点击一次减少按钮之后，是否还有商品数量；
					如果有就执行商品数量比对；
					如果没有，就不执行商品数量比对*/
					if(AndroidBasic.isElementExist(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))){
						if(wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText().contains("起订")){
							System.out.print("商品已经减少到0" + " ");
						}
						else{
							num[2] = wd.findElementByXPath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout["+a+"]/android.widget.LinearLayout[2]/android.widget.TextView[1]").getText();
							System.out.print(num[2] + " ");
							if(num[2].equals(num[1])){
								System.out.print("减少按钮功能可能存在问题" + " ");
								AndroidBasic.takeScreenshots();
							}
							else{
								System.out.print("减少按钮功能正常" + " ");
							}
						}
					}
					else{
						System.out.print("商品已经减少到0" + " ");
					}
				}
				//进入详情页
				wd.findElementsById("com.elianshang.yougong:id/textLayout").get(j).click();
				String pro_name = wd.findElementById("com.elianshang.yougong:id/pro_name").getText();
				String pro_price = wd.findElementById("com.elianshang.yougong:id/pro_price").getText();
				Assert.assertTrue("详情页与列表页商品名称不一致",name.equals(pro_name));
				Assert.assertTrue("详情页与列表页商品价格不一致", price.equals(pro_price));
				AndroidBasic.swipeToDown(1000);
				Thread.sleep(500);
				for(int l=0;l<7;l++){
					if(AndroidBasic.isElementsExist(By.id("com.elianshang.yougong:id/key"), l) && AndroidBasic.isElementsExist(By.id("com.elianshang.yougong:id/value"), l)){
						continue;
					}
					else{
						System.out.print("详情页商品信息显示不正常");
						AndroidBasic.takeScreenshots();
						break;
					}
				}
				System.out.println("");
				
				//返回列表页
				wd.findElementsByClassName("android.widget.ImageButton").get(0).click();
			}		
		}
	}
}
