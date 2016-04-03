package com.mis.market.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mis.market.pages.ItemSkuPage;

import Basic.BasicDriver;
import Basic.ExcelWorkBook;

public class ItemSkuTest extends BasicDriver{
	@BeforeClass
	public void setUp() throws Exception{
		//System.setProperty("webdriver.chrome.driver", "/Users/zhouxin/Desktop/chromedriver"); 
		driver = new FirefoxDriver();
		navigation = driver.navigate();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public static void itemSkuTest() throws InterruptedException{
		BasicDriver.open();
		BasicDriver.login();
		
		ItemSkuPage itemskupage = new ItemSkuPage(driver);
		itemskupage.insert_btn().click(); //新增商品按钮点击
		itemskupage.insertListCheck(); //check新增商品页面
		
		//从excel里取sku_id
		ExcelWorkBook excelbook = new ExcelWorkBook();
		try{
			List<String> sku_list = excelbook.readSkuId("/Users/zhouxin/Documents/workspace/mis/list.xls");
			int sku_size = sku_list.size();
			for(int i=0;i<sku_size;i++){
				String item_id = sku_list.get(i);
				itemskupage.insertSearchCheck(item_id);//check新增商品搜索
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 *check状态筛选
		 */
		for(int j=2;j>=0;j--){
			itemskupage.filterCheck(j);
		}
		itemskupage.filterStatus();//check状态筛选文案
		itemskupage.listCheck();//check商品列表数量
		
		//从excel里取name
		try{
			List<String> name_list = excelbook.readName("/Users/zhouxin/Documents/workspace/mis/list.xls");
			int name_size = name_list.size();
			for(int k=0;k<name_size;k++){
				String name = name_list.get(k);
				itemskupage.itemSearchCheck(name);//check商品列表搜索
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		/*
		 *check分类筛选
		 */
		itemskupage.category().click();//分类筛选点击
		itemskupage.moveToCategory();//鼠标移动到一级分类
		itemskupage.categoryCheck();//check二级分类筛选			
	}
	
}
