package lsh123.test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Basic.test.BasicTestCase;

public class InsertAddressTest extends BasicTestCase{
	public void testInsertAddress(){
		solo.sleep(4000);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/tab_icon",3));
		solo.clickOnText("地址管理");
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/add_address"));
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
						if ("name".equals(detail.getNodeName())){
							//输出name
							System.out.println("name: " + detail.getTextContent());
							solo.enterText(0, (detail.getTextContent()));
						}
						else if ("cellphone".equals(detail.getNodeName())){ 
							//输出cellphone
							System.out.println("cellphone: " + detail.getTextContent());
							solo.enterText(1, (detail.getTextContent()));
						}
						else if ("market".equals(detail.getNodeName())){
							//输出market
							System.out.println("market: " + detail.getTextContent());
							solo.enterText(2, (detail.getTextContent()));
						}
						else if ("phone".equals(detail.getNodeName())){
							//输出Invitation_code
							System.out.println("phone: " + detail.getTextContent());
							solo.enterText(3, (detail.getTextContent()));
							//选择所在区域
							solo.clickOnView(solo.getView("com.elianshang.yougong:id/area"));
							solo.drag(1000,1000,1000,200,13);
							solo.sleep(1000);
							solo.clickOnButton("确定");
						}
						else if ("address".equals(detail.getNodeName())){
							//输出address
							System.out.println("address: " + detail.getTextContent());
							solo.enterText(4, (detail.getTextContent()));				
						}
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}
}
