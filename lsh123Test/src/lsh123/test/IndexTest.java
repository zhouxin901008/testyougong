package lsh123.test;

import android.widget.TextView;
import Basic.test.BasicTestCase;


public class IndexTest extends BasicTestCase{
	public void testIndex(){
		solo.sleep(4000);
		//下拉刷新
		solo.drag(300,300,700,1000,10);
		solo.sleep(2000);
		//品类推荐
		for(int i=0;i<8;i++){
			solo.clickOnView(solo.getView("com.elianshang.yougong:id/image",i));
			solo.sleep(1000);
			solo.goBack();
			solo.sleep(1000);
		}
		//单品推荐
		for(int j=0;j<4;j++){
			solo.clickOnView(solo.getView("com.elianshang.yougong:id/imageview",j));
			if(solo.waitForText("亲，您的手机网络不太流畅哦",1,1000,false,true)){
				solo.sleep(1000);
				System.out.println("网络异常");
				solo.clickOnView(solo.getView("com.elianshang.yougong:id/net_error_btn"));
			}
			else if(solo.waitForText("活动",1,1000,false,true)){
				solo.sleep(1000);
				System.out.println("活动页面");			
			}
			else if(solo.waitForText("公告",1,1000,false,true)){
				solo.sleep(1000);
				System.out.println("公告页面");		
			}
			else {
				solo.sleep(1000);
				System.out.println("单品页面");
				if(solo.waitForText("暂无数据！",1,1000,false,true)){
					 System.out.println("商品详情数据有问题");
				}
				else{
					System.out.println("检测1");
					TextView view1 = (TextView)solo.getView("com.elianshang.yougong:id/pro_name");
					System.out.println(view1.getText());
					assertNotNull("商品名称为空",view1.getText());
					System.out.println("检测2");
					TextView view2 = (TextView)solo.getView("com.elianshang.yougong:id/pro_price");
					System.out.println(view2.getText());
					assertNotNull("商品价格为空",view2.getText());
					System.out.println("检测3");
					//验证商品信息
					assertTrue("信息可能不正确",solo.searchText("商品信息"));
					try{
						TextView v1 = (TextView)solo.getView("com.elianshang.yougong:id/pro_detail_brand_value");
						assertNotNull("该商品品牌为空",v1.getText());
						TextView v2 = (TextView)solo.getView("com.elianshang.yougong:id/pro_detail_from_value");
						assertNotNull("该商品产地为空",v2.getText());
						TextView v3 = (TextView)solo.getView("com.elianshang.yougong:id/pro_detail_rank_value");
						assertNotNull("该商品规格为空",v3.getText());
						TextView v4 = (TextView)solo.getView("com.elianshang.yougong:id/pro_detail_validity_day_value");
						assertNotNull("该商品保质期为空",v4.getText());
						TextView v5 = (TextView)solo.getView("com.elianshang.yougong:id/pro_detail_store_condition_value");
						assertNotNull("该商品存储条件为空",v5.getText());
					}catch(Exception e){
						System.out.println("该商品信息部分数据异常");
					}
				}
			}
			solo.goBack();
			solo.sleep(1000);
			solo.drag(300,300,1000,800,13);
			solo.sleep(1000);
		}
	}
}
