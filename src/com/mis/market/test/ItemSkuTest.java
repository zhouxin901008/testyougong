package com.mis.market.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mis.market.pages.ItemSkuPage;

import Basic.BasicDriver;

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
		itemskupage.insertSearchCheck("100388");//check新增商品搜索
		navigation.back();
		navigation.back();
		itemskupage.filter(2).click(); //筛选按钮点击
		itemskupage.filter(1).click();
		itemskupage.filter(0).click();
		itemskupage.filterCheck(); //检查筛选文案
		itemskupage.listCheck();//检查商品列表数量
		itemskupage.itemSearchCheck("统一芒果多2L/瓶");//商品列表搜索检查	
	}
	
}
