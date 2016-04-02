package com.mis.market.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ItemSkuPage{
	private WebElement element = null;
	private WebDriver driver = null;

	public ItemSkuPage(WebDriver driver){
		this.driver = driver; 
	}
	//添加商品按钮
	public WebElement insert_btn(){
		element = driver.findElement(By.linkText("添加商品"));
		return element;
	}
	//检查商品列表
	public void insertListCheck() throws InterruptedException{
		Assert.assertTrue("添加商品页面有问题", driver.findElement(By.className("crumb")).getText().equals("全部商品列表"));
		Thread.sleep(1000);
	}
	//添加商品搜索检查
	public void insertSearchCheck(String item_id) throws InterruptedException{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(item_id);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(item_id,driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/table/tbody/tr/td[1]")).getText());
		driver.navigate().back();
		driver.navigate().back();
	}
	//商品列表筛选
	public WebElement filter(int n) throws InterruptedException{
		element = driver.findElement(By.xpath("//li[@data-value="+n+"]"));
		Thread.sleep(1000);
		return element;
	}
	//商品列表筛选文案检查
	public void filterCheck(){
		Assert.assertTrue("'所有'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='0']")).getText().contains("所有"));
		Assert.assertTrue("'新建'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='1']")).getText().contains("新建"));
		Assert.assertTrue("'已编辑'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='2']")).getText().contains("已编辑"));
	}
	//商品列表商品数量检查
	public void listCheck(){
		List<WebElement> item_list= driver.findElements(By.linkText("查看"));
		Assert.assertEquals(12,item_list.size());
	}
	//商品列表搜索检查
	public void itemSearchCheck(String name) throws InterruptedException{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(name,driver.findElement(By.className("wrap")).getText());
		driver.findElement(By.linkText("查看")).click();
		Thread.sleep(1000);
		Assert.assertEquals(name,driver.findElement(By.xpath("//h1[@class='title']")).getText());
	}
}
