package lsh123.test;


import java.util.ArrayList;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import Basic.test.Basic;
import Basic.test.BasicTestCase;
import Basic.test.Loginfo;
	
public class CommodityTest extends BasicTestCase{
	public void testCommodity(){
		solo.sleep(4000);
		solo.clickOnView(solo.getView("com.elianshang.yougong:id/tab_icon",1));
		solo.sleep(1000);
		for(int n=0;n<5;n++){
			solo.clickOnView(solo.getView("com.elianshang.yougong:id/text",n));
			TextView category = (TextView)solo.getView("com.elianshang.yougong:id/text",n);
			System.out.println("当前品类为："+category.getText());
			Loginfo.writeToFile("当前品类为："+category.getText().toString());
			for(int k=0;k<5;k++){
				//获取列表中的view
				View view = solo.getView("com.elianshang.yougong:id/recyclerView");
				ArrayList<RelativeLayout> Relativelist = solo.getCurrentViews(RelativeLayout.class,view);
				int list=(Relativelist.size()-1)/2;
				int m=1;
				while(m<(list-1)){	
					if(solo.waitForText("暂无数据！",1,1000,false,true)){
						System.out.println("分类列表数据有问题");
						Loginfo.writeToFile("分类列表数据有问题");
						break;
					}
					else{
						//验证增加到购物车和减少商品后数量是否相等
						Basic.assertequals(m);
						TextView name = (TextView)solo.getView("com.elianshang.yougong:id/nameTextView",m);
						TextView tag = (TextView)solo.getView("com.elianshang.yougong:id/tagTextView",m);
						if(tag.getText().equals("特价")){
							System.out.println(name.getText()+"(特价商品)");
							Loginfo.writeToFile(""+name.getText()+"(特价商品)");
						}
						else if(tag.getText().equals("满减")){
							System.out.println(name.getText()+"(满减商品)");
							Loginfo.writeToFile(""+name.getText()+"(满减商品)");
						}
						else if(tag.getText().equals("热销")){
							System.out.println(name.getText()+"(热销商品)");
							Loginfo.writeToFile(""+name.getText()+"(热销商品)");
						}
						else if(tag.getText().equals("新品")){
							System.out.println(name.getText()+"(新品)");
							Loginfo.writeToFile(""+name.getText()+"(新品)");
						}
						else{
							System.out.println(name.getText());
							Loginfo.writeToFile(""+name.getText());
						}
						//点击进入详情页
						solo.clickOnView(solo.getView("com.elianshang.yougong:id/nameTextView",m));
						System.out.println("商品详情页");
						solo.sleep(1000);
						if(solo.waitForText("暂无数据！",1,1000,false,true)){
							System.out.println("商品详情数据有问题");
							Loginfo.writeToFile("商品详情数据有问题");
						}
						else{
							solo.drag(700,700,900,450,1);
							if(solo.waitForText("满减",1,500,true,true)||solo.waitForText("特价",1,500,true,true)){
								TextView detailTag = (TextView)solo.getView("com.elianshang.yougong:id/promotion_title");
								if(detailTag.getText().equals("满减")){
									System.out.println("该商品在满减活动中");
									Loginfo.writeToFile("该商品在满减活动中");
									TextView promotionDetail = (TextView)solo.getView("com.elianshang.yougong:id/promotion_detail");
									System.out.println("活动名称："+promotionDetail.getText());
									Loginfo.writeToFile("活动名称："+promotionDetail.getText());
									solo.clickOnView(solo.getView("com.elianshang.yougong:id/promotion_title"));
									solo.sleep(500);
									solo.goBack();
								}
								if(detailTag.getText().equals("特价")){
									System.out.println("该商品在特价活动中");
									Loginfo.writeToFile("该商品在特价活动中");
									TextView promotionDetail = (TextView)solo.getView("com.elianshang.yougong:id/promotion_detail");
									System.out.println("活动名称："+promotionDetail.getText());
									Loginfo.writeToFile("活动名称："+promotionDetail.getText());
									solo.clickOnView(solo.getView("com.elianshang.yougong:id/promotion_title"));
									solo.sleep(500);
									solo.goBack();
								}
							}		
							TextView view1 = (TextView)solo.getView("com.elianshang.yougong:id/pro_name");
							System.out.println(view1.getText());
							assertNotNull("商品名称为空",view1.getText());
							TextView view2 = (TextView)solo.getView("com.elianshang.yougong:id/pro_price");
							System.out.println(view2.getText());
							assertNotNull("商品价格为空",view2.getText());
							//验证商品信息
							assertTrue("商品信息文案可能不正确",solo.searchText("商品信息"));
							if(solo.searchText("分类")&&solo.searchText("国条码")&&solo.searchText("品牌")&&solo.searchText("产地")&&solo.searchText("规格")&&solo.searchText("保质期")&&solo.searchText("存储条件")){
								System.out.println("商品信息完整，测试通过");
							}
							else{
								System.out.println("商品信息不完成，该商品为:"+view1.getText());
								Loginfo.writeToFile("商品信息不完成，该商品为:"+view1.getText());
							}
							//验证商品详情页按钮
							TextView v = (TextView)solo.getView("com.elianshang.yougong:id/numTextView");
							String a[] = new String[2];
							String b[] = new String[2];
							for(int i=0;i<2;i++){
								a[i]=v.getText().toString();
								solo.clickOnView(solo.getView("com.elianshang.yougong:id/addImageView"));
								solo.sleep(1000);
								if(solo.waitForText("超出最大限购量了",1,1000,false,true)){
									System.out.println("该商品超过最大限购量了，不能再添加更多该商品到购物车");
								}
							}
							System.out.println(a[0]);
							System.out.println(a[1]);
							if(a[0].equals(a[1])){
								System.out.println("该商品已售罄，商品名为："+view1.getText());
								Loginfo.writeToFile("该商品已售罄，商品名为："+view1.getText());
							}
							else{
								System.out.println("两数不相等，测试通过");
								
							}
							for(int j=0;j<2;j++){
								b[j]=v.getText().toString();
								solo.clickOnView(solo.getView("com.elianshang.yougong:id/subtractImageView"));
								solo.sleep(1000);
							}
							System.out.println(b[1]);
							System.out.println(a[1]);
							if(b[1].equals(a[1])){
								System.out.println("两数相等，测试通过");
							}
							else{
								System.out.println("两数不相等，减少按钮可能有异常"+view1.getText());
								Loginfo.writeToFile("两数不相等，减少按钮可能有异常"+view1.getText());
							}
						}
						solo.goBack();
						solo.sleep(1000);				
					}
					if(solo.waitForText("没有数据了",1,1000,false,true)){
						solo.scrollUp();
						break;
					}
					m++;						
				}
				solo.drag(1000,1000,1000,200,15);
				solo.scrollToTop();
			}
		}
	}
}



