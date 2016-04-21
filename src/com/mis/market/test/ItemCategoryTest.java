package com.mis.market.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mis.market.pages.ItemCategoryPage;

import Basic.BasicDriver;

public class ItemCategoryTest extends BasicDriver{
	public ItemCategoryTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

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
		System.out.println("ItemCategory页面测试结束");
	}
	
	@Test
	public static void itemCategoryTest() throws Exception{
		BasicDriver.open();
		BasicDriver.login();
		
		ItemCategoryPage icp = new ItemCategoryPage(driver);
		icp.category_btn().click();//进入品类管理页面
		//check筛选
		icp.filterCheck(2);
		icp.filterCheck(0);
		icp.filterCheck(-1);
		
		icp.insert_btn().click();//添加一级分类
		icp.cancel_btn().click();//取消
		icp.view_btn().click();//查看一级分类
		icp.insert_btn().click();//添加二级分类
		icp.cancel_btn().click();//取消
		icp.edit_btn().click();//编辑一级分类
		icp.cancel_btn().click();//取消
		
		icp.view_btn().click();//查看二级分类
		icp.edit_btn().click();//编辑二级分类
		icp.cancel_btn().click();//取消
		
	}
}
