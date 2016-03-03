package Commodity;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import WebTesting.BasicDriver;

public class insertCommodity extends BasicDriver {
		@Test
		public void insertCommidity() throws InterruptedException{	
			String a[] = new String[]{"xxx商品","海鲜牌","个","KG","合格"};
			Integer b[] = new Integer[]{1231231231,5,30,6,};
			BasicDriver.open();
			//登录
			BasicDriver.sendKeys(By.id("loginChildName"), "QAtest");
			BasicDriver.sendKeys(By.id("loginUserName"), "QAtest");
			WebElement lsh = driver.findElement(By.id("loginPassword"));
			lsh.sendKeys(new String[] {"123456"});
			lsh.submit();
			Thread.sleep(1000);
			BasicDriver.click(By.linkText("商品管理"));
			BasicDriver.click(By.linkText("新增商品"));
			//选择商品分类
			Select select1 = new Select(driver.findElements(By.tagName("select")).get(1));
			select1.selectByVisibleText("干果蜜饯");
			Thread.sleep(1000);
			Select select2 = new Select(driver.findElements(By.tagName("select")).get(3));
			select2.selectByVisibleText("炒货");
			/*
			BasicDriver.click(By.xpath("//option[@value='10059']"));
			Thread.sleep(1000);
			BasicDriver.click(By.xpath("//option[@value='1001700']"));
			*/
			Assert.assertEquals(driver.findElement(By.className("choose-result")).getText(), "干果蜜饯 >> 干果蜜饯类 >> 炒货");
			BasicDriver.click(By.id("itemNewAction"));
			//填写商品基本信息
			BasicDriver.sendKeys(By.name("name"),a[0]);
			BasicDriver.sendKeys(By.name("brand"),a[1]);
			BasicDriver.click(By.xpath("//input[@value='2']"));
			BasicDriver.sendKeys(By.name("barcode"),""+b[0]);
			BasicDriver.click(By.xpath("//option[@value='20']"));
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='pack_desc']"),a[2]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='sales_length']"),""+b[1]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='sales_height']"),""+b[1]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='sales_width']"),""+b[1]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='spec_num']"),""+b[2]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='spec_unit']"),a[3]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='pack_num']"),""+b[2]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='pack_length']"),""+b[3]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='pack_width']"),""+b[3]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='pack_height']"),""+b[3]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='shelf_life']"),""+b[3]);
			BasicDriver.click(By.xpath("//option[@value='010']"));
			BasicDriver.click(By.xpath("//option[@value='冷藏']"));
			BasicDriver.click(By.xpath("//option[@value='0']"));
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='grade']"),""+a[4]);
			driver.findElements(By.className("file")).get(0).sendKeys("/Users/zhouxin/Desktop/1.jpg");
			driver.findElements(By.className("file")).get(1).sendKeys("/Users/zhouxin/Desktop/2.jpg");
			driver.findElements(By.className("file")).get(2).sendKeys("/Users/zhouxin/Desktop/3.jpg");
			Thread.sleep(1000);
			BasicDriver.click(By.xpath("//button[@class='btn btn-primary action-publish']"));
			Thread.sleep(1000);
			//回答问题
			//BasicDriver.click(By.id("dealer"));
			BasicDriver.click(By.id("is_patent"));
			BasicDriver.click(By.id("is_patent_licensing"));
			BasicDriver.sendKeys(By.id("venderCount"), "1");
			BasicDriver.click(By.xpath("//button[@class='submit btn btn-primary btn-lg']"));
			BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div[2]/div[5]/div/div/div[3]/button[1]"));
			Thread.sleep(1000);
			//填写供货信息
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='purchase_price']"),""+b[1]);
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='selling_price']"),""+b[1]);
			driver.findElement(By.xpath("//input[@data-property-name='selling_date']")).sendKeys("2015-12-12");;
			BasicDriver.sendKeys(By.xpath("//input[@data-property-name='labelName']"),a[1]);
			BasicDriver.click(By.xpath("//input[@value='1']"));
			BasicDriver.click(By.xpath("//button[@class='btn btn-primary action-publish']"));
			Thread.sleep(1000);
			//关联证照
			ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.className("operations"));
			System.out.println(list.size());
			for(int n=0;n<list.size();n++){
				while(driver.findElements(By.xpath("//a[@class='operations']")).get(n).getText().contentEquals("提交")){
				BasicDriver.click(By.linkText("提交"));
				Thread.sleep(1000);
				if(	BasicDriver.isElementExist(By.xpath("/html/body/div[3]/div[2]/div[2]/a"))){
					BasicDriver.click(By.xpath("/html/body/div[3]/div[2]/div[2]/a"));
					BasicDriver.click(By.className("list-radio"));
					BasicDriver.click(By.xpath("//button[@class='btn btn-primary btn-lg submit']"));
				}
				else{
					if(driver.findElement(By.className("certify-container certify-form")).getText().contentEquals("专利授权许可合同")){
						String filePath = "/Users/zhouxin/Desktop/1.jpg";
						driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div/form/input[2]")).sendKeys(filePath);
					}
					String filePath = "/Users/zhouxin/Desktop/123.jpg";
					driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div/div/div[4]/div/div[2]/div/form/input[2]")).sendKeys(filePath);
				}
				Thread.sleep(1000);
			}
			
		}
		BasicDriver.click(By.xpath("//button[@class='finish btn btn-primary']"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div/div[3]/button[1]")).click();		
	}
		
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
		
}
