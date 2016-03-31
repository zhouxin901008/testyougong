package com.market.mis.pages;

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
		itemskupage.insert_Commodity_btn().click(); //新增商品按钮点击
		itemskupage.CommodityListCheck(); //check新增商品页面
		itemskupage.insert_Commodity_search("100388");
		itemskupage.insert_Commodity_search_btn().click();
		itemskupage.insertCommodityListCheck();
		navigation.back();
		navigation.back();
		itemskupage.filter(2).click(); //筛选按钮点击
		itemskupage.filter(1).click();
		itemskupage.filter(0).click();
		itemskupage.filterCheck(); //检查筛选文案
		itemskupage.listItemCheck();//检查商品列表数量
		itemskupage.list_item_btn(0).click();//商品列表查看按钮
		
		
		//销售管理
		driver.findElement(By.linkText("销售管理")).click();
		Assert.assertTrue("销售管理页面'所有'筛选有问题", driver.findElement(By.xpath("//li[@data-value='0']")).getText().contains("所有"));
		Assert.assertTrue("销售管理页面'新建'筛选有问题", driver.findElement(By.xpath("//li[@data-value='1']")).getText().contains("新建"));
		driver.findElement(By.xpath("//li[@data-value='1']")).click();
		Assert.assertTrue("销售管理页面'下架'筛选有问题", driver.findElement(By.xpath("//li[@data-value='3']")).getText().contains("下架"));
		driver.findElement(By.xpath("//li[@data-value='3']")).click();
		Assert.assertTrue("销售管理页面'上架'筛选有问题", driver.findElement(By.xpath("//li[@data-value='2']")).getText().contains("上架"));
		driver.findElement(By.xpath("//li[@data-value='2']")).click();
		Assert.assertTrue("销售管理页面'价格异常'筛选有问题", driver.findElement(By.xpath("//li[@data-value='4']")).getText().contains("价格异常"));
		driver.findElement(By.xpath("//li[@data-value='4']")).click();
		driver.findElement(By.xpath("//li[@data-value='0']")).click();
		Thread.sleep(500);
		List<WebElement> sale_list = driver.findElements(By.linkText("查看"));
		Assert.assertEquals(12, sale_list.size());
	}
	
}
