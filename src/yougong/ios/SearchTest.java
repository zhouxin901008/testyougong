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

public class SearchTest extends iOSBasic{
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
			wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]").click();
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
					if ("Search".equals(node1.getNodeName())) {
						//输出节点名称"Search"
						System.out.println(node1.getNodeName()+":");
						//获得<Lianshang>下的节点
						NodeList nodeDetail = node1.getChildNodes();
						//遍历<Lianshang>下的节点
						for (int j=0;j<nodeDetail.getLength();j++) {
							//获得<Lianshang>元素每一个节点
							Node detail = nodeDetail.item(j);
							if ("commodity1".equals(detail.getNodeName())){ 
								//输出commodity1
								System.out.println("commodity1: " + detail.getTextContent());
								wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]").sendKeys(detail.getTextContent());
								wd.findElement(By.name("搜索")).click();
								wd.findElementByAccessibilityId("清除文本").click();
							}
							else if ("commodity2".equals(detail.getNodeName())){ 
								//输出commodity2
								System.out.println("commodity2: " + detail.getTextContent());
								wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]").sendKeys(detail.getTextContent());
								wd.findElement(By.name("搜索")).click();
								wd.findElementByAccessibilityId("清除文本").click();
							}
							else if ("commodity3".equals(detail.getNodeName())){
								//输出commodity3
								System.out.println("commodity3: " + detail.getTextContent());
								wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]").sendKeys(detail.getTextContent());
								wd.findElement(By.name("搜索")).click();
								wd.findElementByAccessibilityId("清除文本").click();
							}
							else if ("commodity4".equals(detail.getNodeName())){
								//输出commodity4
								System.out.println("commodity4: " + detail.getTextContent());
								wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]").sendKeys(detail.getTextContent());
								wd.findElement(By.name("搜索")).click();
								wd.findElementByAccessibilityId("清除文本").click();
							}
							else if ("commodity5".equals(detail.getNodeName())){
								//输出commodity5
								System.out.println("commodity5: " + detail.getTextContent());
								wd.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIASearchBar[1]").sendKeys(detail.getTextContent());
								wd.findElement(By.name("搜索")).click();
								wd.findElementByAccessibilityId("清除文本").click();
							}
						}
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
			wd.lockScreen(5);
		}
}
