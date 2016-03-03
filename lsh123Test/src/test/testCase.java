package test;

import android.widget.TextView;
import Basic.test.Basic;
import Basic.test.BasicTestCase;

public class testCase extends BasicTestCase{

	public void testCommodity(){
		solo.sleep(4000);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/tab_icon",1));
		solo.sleep(2000);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/text",6));
		solo.sleep(1000);
		/*
		TextView name = (TextView)solo.getView("com.elianshang.yougong:id/nameTextView",3);
		System.out.println(name.getText());
		TextView a = (TextView)solo.getView("com.elianshang.yougong:id/tagTextView",3);
			if(a.getText().equals("特价")){
				System.out.println(name.getText()+"为：特价商品");
			}
			else if(a.getText().equals("满减")){
				System.out.println(name.getText()+"为：满减商品");
			}
			else if(a.getText().equals("热销")){
				System.out.println(name.getText()+"为：热销商品");
			}
			else if(a.getText().equals("新品")){
				System.out.println(name.getText()+"为：新品");
			}
			else{
				System.out.println(name.getText()+"为：普通商品");
			}
		
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/addImageView",4));
		*/
		/*
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/tab_icon",2));
		solo.sleep(1000);
		solo.clickLongOnView(solo.getView("com.elianshang.yougong:id/productLayout"));
		solo.clickOnButton("确认");
		solo.sleep(2000);
		*/	
	}
}
