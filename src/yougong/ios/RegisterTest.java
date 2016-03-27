package yougong.ios;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Basic.iOSBasic;

public class RegisterTest extends iOSBasic{	
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
	public void testRegister() throws Exception {
		wd.findElementByName("注册").click();
		/*wd.findElementByName("是").click();
		if(Basic.isElementExist(By.name("好"))){
			wd.findElement(By.name("好")).click();
		}
		Assert.assertTrue(wd.findElement(By.name("注册")).isDisplayed());
		*/
		Element element = null;
		//可以使用绝对路劲
		File f = new File("data.xml");
		//documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		try {
			//返回documentBuilderFactory对象
			dbf = DocumentBuilderFactory.newInstance();
			//返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
			db = dbf.newDocumentBuilder();
			//得到一个DOM并返回给document对象
			Document dt = db.parse(f);
			//得到一个elment根元素
			element = dt.getDocumentElement();
			//获得根节点
			System.out.println(element.getNodeName());
			//获得根元素下的子节点
			NodeList childNodes = element.getChildNodes();
			//遍历这些子节点
			for (int i=0;i<childNodes.getLength();i++) {
				//获得每个对应位置i的结点
				Node node1 = childNodes.item(i);
				if ("Userinfo".equals(node1.getNodeName())) {
					//输出节点名称"Userinfo"
					System.out.println(node1.getNodeName()+":");
					//获得<Accounts>下的节点
					NodeList nodeDetail = node1.getChildNodes();
					//遍历<Accounts>下的节点
					for (int j=0;j<nodeDetail.getLength();j++) {
						//获得<Accounts>元素每一个节点
						Node detail = nodeDetail.item(j);
						if ("cellphone".equals(detail.getNodeName())){ 
							//输出cellphone
							System.out.println("cellphone: " + detail.getTextContent());
							wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]").sendKeys(detail.getTextContent());
							wd.findElement(By.name("完成")).click();
						}
						else if ("name".equals(detail.getNodeName())){ 
							//输出name
							System.out.println("name: " + detail.getTextContent());
							wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]").sendKeys(detail.getTextContent());
							wd.findElement(By.name("完成")).click();
						}
						else if ("market".equals(detail.getNodeName())){
							//输出market
							System.out.println("market: " + detail.getTextContent());
							wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIATextField[1]").sendKeys(detail.getTextContent());
							wd.findElement(By.name("完成")).click();
							//选择所在区域
							wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIATextField[1]")).click();	
							//获取屏幕大小并滑动控件
							int width = wd.manage().window().getSize().width;
							int height = wd.manage().window().getSize().height;
							wd.swipe(width*6/7, height*9/10, width*6/7, height*8/10, 1000);
							wd.findElement(By.name("确定")).click();
						}
						else if ("address".equals(detail.getNodeName())){
							//输出address
							System.out.println("address: " + detail.getTextContent());
							wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]").sendKeys(detail.getTextContent());
							wd.findElement(By.name("完成")).click();
						}
						else if ("Invitation_code".equals(detail.getNodeName())){
							//输出Invitation_code
							System.out.println("Invitation_code: " + detail.getTextContent());
							wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIATextField[1]").sendKeys(detail.getTextContent());
							wd.findElement(By.name("完成")).click();
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		wd.findElement(By.name("下一步"));
		Thread.sleep(2000);
		wd.lockScreen(5);
	}

}
