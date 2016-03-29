package CommodityManagement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basic.BasicDriver;

public class Items extends BasicDriver{
	@BeforeClass
	public void setUp() throws Exception{
		driver = new FirefoxDriver();
		navigation = driver.navigate();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void itemstest() throws InterruptedException{
		BasicDriver.open();
		BasicDriver.login();
		//全部商品
		driver.findElement(By.linkText("添加商品")).click();
		Assert.assertTrue("添加商品页面有问题", driver.findElement(By.className("crumb")).getText().equals("全部商品列表"));
		navigation.back();
		Assert.assertTrue("全部商品页面'所有'筛选有问题", driver.findElement(By.xpath("//li[@data-value='0']")).getText().contains("所有"));
		Assert.assertTrue("全部商品页面'已编辑'筛选有问题", driver.findElement(By.xpath("//li[@data-value='2']")).getText().contains("已编辑"));
		driver.findElement(By.xpath("//li[@data-value='2']")).click();
		Assert.assertTrue("全部商品页面'新建'筛选有问题", driver.findElement(By.xpath("//li[@data-value='1']")).getText().contains("新建"));
		driver.findElement(By.xpath("//li[@data-value='1']")).click();
		driver.findElement(By.xpath("//li[@data-value='0']")).click();
		Thread.sleep(500);
		List<WebElement> sku_list = driver.findElements(By.linkText("查看"));
		Assert.assertEquals(12, sku_list.size());
		
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
