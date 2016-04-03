package com.mis.market.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mis.market.pages.ItemSalePage;

import Basic.BasicDriver;

public class ItemSaleTest extends BasicDriver{
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
	public void itemSaleTest() throws InterruptedException{
		BasicDriver.open();
		BasicDriver.login();
		ItemSalePage itemsalepage = new ItemSalePage(driver);
		itemsalepage.sale_btn().click(); //销售管理按钮
		itemsalepage.filter(1).click(); //筛选按钮点击
		itemsalepage.filter(3).click();
		itemsalepage.filter(2).click();
		itemsalepage.filter(4).click();
		itemsalepage.filterCheck();//筛选检查
		itemsalepage.listCheck();//列表数量检查
	}
}
