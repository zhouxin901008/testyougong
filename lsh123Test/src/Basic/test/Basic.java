package Basic.test;

import android.widget.TextView;

public class Basic extends BasicTestCase{
	public static void assertequals(int n){
		TextView view=null;
		view = (TextView)solo.getView("com.elianshang.yougong:id/numTextView",n);
		String a[] = new String[2];
		String b[] = new String[2];
		for(int i=0;i<2;i++){
			a[i]=view.getText().toString();
			solo.clickOnView(solo.getView("com.elianshang.yougong:id/addImageView",n));
			solo.sleep(1000);
			if(solo.waitForText("超出最大限购量了",1,1000,false,true)){
				System.out.println("该商品超过最大限购量了，不能再添加更多该商品到购物车");
			}
			if(solo.waitForText("请输入关键词...",1,300,false,true)){
				solo.goBack();
				solo.goBack();
			}
		}
		System.out.println(a[0]);
		System.out.println(a[1]);
		if(a[0].equals(a[1])){
			System.out.println("两数相等，该商品已售罄");
		}
		else{
			System.out.println("两数不相等，测试通过");
		}
		for(int j=0;j<2;j++){
			b[j]=view.getText().toString();
			solo.clickOnView(solo.getView("com.elianshang.yougong:id/subtractImageView",n));
			solo.sleep(1000);
			if(solo.waitForText("请输入关键词...",1,300,false,true)){
				solo.goBack();
				solo.goBack();
			}
		}
		System.out.println(b[1]);
		System.out.println(a[1]);
		if(b[1].equals(a[1])){
			System.out.println("两数相等，测试通过");
		}
		else{
			System.out.println("两数不相等，减少按钮可能有异常");
		}

	} 
	
	public static boolean isViewExist(String id){
		try{
			solo.getView(id);
			return true;
		}catch(Exception e){
			return false;
		}
		
		
	}

}
