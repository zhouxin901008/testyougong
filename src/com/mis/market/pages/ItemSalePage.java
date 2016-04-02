package com.mis.market.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ItemSalePage{
		private WebElement element = null;
		private WebDriver driver = null;
		
		public ItemSalePage(WebDriver driver){
			this.driver = driver; 
		}
		//销售管理按钮
		public WebElement sale_btn() throws InterruptedException{
			element = driver.findElement(By.linkText("销售管理"));
			Thread.sleep(1000);
			return element;
		}
		//筛选
		public WebElement filter(int n) throws InterruptedException{
			element = driver.findElement(By.xpath("//li[@data-value="+n+"]"));
			Thread.sleep(1000);
			return element;
		}
		//筛选文案检查
		public void filterCheck(){
			Assert.assertTrue("'所有'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='0']")).getText().contains("所有"));
			Assert.assertTrue("'新建'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='1']")).getText().contains("新建"));	
			Assert.assertTrue("'下架'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='3']")).getText().contains("下架"));		
			Assert.assertTrue("'上架'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='2']")).getText().contains("上架"));			
			Assert.assertTrue("'价格异常'筛选文案错误", driver.findElement(By.xpath("//li[@data-value='4']")).getText().contains("价格异常"));
		}
		//销售列表数量检查
		public void listCheck(){
			List<WebElement> sale_list= driver.findElements(By.linkText("查看"));
			Assert.assertEquals(12,sale_list.size());
		}
		
		
		
		
		
		
}