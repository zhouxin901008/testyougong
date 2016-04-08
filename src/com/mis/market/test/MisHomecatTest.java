package com.mis.market.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mis.market.pages.MisHomecatPage;

import Basic.BasicDriver;

public class MisHomecatTest extends BasicDriver{
	public MisHomecatTest() throws IOException {
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
		System.out.println("MisHomecat页面测试结束");
	}
	
	@Test
	public static void itemSkuTest() throws Exception{
		BasicDriver.open();
		BasicDriver.login();
		
		MisHomecatPage homecatpage = new MisHomecatPage(driver);
		homecatpage.mis().click();//展开mis
		homecatpage.homecat().click();//定位到品类推荐
		homecatpage.homecatCheck("333333");//check列表中有该id的品类
		
		homecatpage.homecatInsert().click();//添加
		
	}
}
