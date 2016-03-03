package ZYZS;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import WebTesting.BasicDriver;


public class WebTestingZYFB extends BasicDriver{
@Test
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public void ZYFB() throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app");
		//设置项目名称，招商标题
		String x[] = new String[]{"QA自营回归测试QA自营回归，字数要大于多少字"};
		//设置未税促销服务费目标总额、未税促销服务费步长
		String y[] = new String[]{"3000","5"};
		BasicDriver.open();
		//登录
		BasicDriver.sendKeys(By.id("loginChildName"), "admin");
		BasicDriver.sendKeys(By.id("loginUserName"), "wumart");
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYFB1.jpg");
		//进入新增招商项目页面
		BasicDriver.click(By.linkText("新增招商项目"));
		//验证页面标题是否为“填写招商项目－链商”
		//Assert.assertEquals(driver.getTitle(),"填写招商项目－链商");
		//验证文案“招商类型”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(0).getText(),"*招商类型");
		//选择自营招商
		driver.findElement(By.xpath("//input[@value = '1']")).click();
		//验证招商项目文案是否为“自营招商”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(1).getText(), " 自营招商");
		Thread.sleep(1000);
		//验证文案“项目名称”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(4).getText(),"*项目名称");
		BasicDriver.sendKeys(By.id("title"),""+ZYtest.title());
		//验证文案“招商分类”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(5).getText(),"*招商分类");
		BasicDriver.click(By.xpath("//option[@value ='U91' ]"));
		//验证文案“平台分类”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(11).getText(),"*平台分类");
		BasicDriver.click(By.xpath("//option[@value ='10006' ]"));
		//验证文案“招商资源分配”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(12).getText(),"*招商资源分配");
		BasicDriver.click(By.xpath("//option[@value ='U0-U4' ]"));
		//验证文案“项目说明”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(13).getText(),"*招商说明");
		BasicDriver.sendKeys(By.xpath("//textarea"),x[0]);
		//验证文案“合同时间”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(14).getText(),"*合同时间");
		//填写合同时间、预计招商会时间
		BasicDriver.sendKeys(By.id("purchaseBegin"),"2016-01-18");
		BasicDriver.click(By.id("purchaseBegin"));
		BasicDriver.sendKeys(By.id("purchaseEnd"),"2016-01-20");
		BasicDriver.click(By.id("purchaseEnd"));
		//验证文案“预计招商会时间”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(16).getText(),"*预计招商会时间");
		BasicDriver.sendKeys(By.id("timeSite"),"2016-01-23");
		BasicDriver.click(By.id("timeSite"));
		//验证文案“计划入选数：”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(20).getText(),"计划入选数：");
		//三级资源分配预估入选组
		for(int i=0;i<5;i++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='205-002']/td/input[@data-id= "+i+"]")).sendKeys(new String[] {"6"});
			}
		for(int j=0;j<5;j++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='205-005']/td/input[@data-id="+j+"]")).sendKeys(new String[] {"6"});
			}
		for(int k=0;k<5;k++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='205-001']/td/input[@data-id="+k+"]")).sendKeys(new String[] {"6"});
			}
		for(int l=0;l<5;l++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='734-001']/td/input[@data-id="+l+"]")).sendKeys(new String[] {"6"});
			}
		for(int m=0;m<5;m++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='204-001']/td/input[@data-id="+m+"]")).sendKeys(new String[] {"8"});
			}
		for(int n=0;n<5;n++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='204-003']/td/input[@data-id="+n+"]")).sendKeys(new String[] {"7"});
			}
		for(int a=0;a<5;a++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='204-002']/td/input[@data-id="+a+"]")).sendKeys(new String[] {"8"});
			}
		for(int b=0;b<5;b++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='204-005']/td/input[@data-id="+b+"]")).sendKeys(new String[] {"10"});
			}
		for(int c=0;c<5;c++){
			driver.findElement(By.xpath("//tbody/tr[@data-id='204-004']/td/input[@data-id="+c+"]")).sendKeys(new String[] {"8"});
			}
		//验证文案“竞争排位”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(21).getText(),"*竞争排位");
		driver.findElement(By.xpath("//option[@value ='3' ]")).click();
		//验证文案“未税促销服务费目标总额”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(22).getText(),"未税促销服务费目标总额");
		driver.findElement(By.xpath("//input[@data-id = '3004']")).sendKeys(y[0]);
		//验证文案“未税促销服务费步长”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(23).getText(),"未税促销服务费步长");
		driver.findElement(By.xpath("//input[@data-id = '1004']")).clear();
		driver.findElement(By.xpath("//input[@data-id = '1004']")).sendKeys(y[1]);
		//验证文案“联系人”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(24).getText(),"*联系人");
		//验证文案“联系手机”
		//Assert.assertEquals(driver.findElements(By.xpath("//label")).get(25).getText(),"*联系手机");
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYFB2.jpg");
		driver.findElement(By.xpath("//input[@value='保存并预览']")).click();
		Thread.sleep(1000);
		
		BasicDriver.takeScreenshots("/Users/zhouxin/Desktop/ZYFB3.jpg");
		/*
		//验证页面标题是否为“预览XXX项目－链商”
		Assert.assertEquals(driver.getTitle(), "预览"+ZYtest.title()+"项目-链商");
		//招商项目名称
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(0).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(3).getText());
		//招商分类
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(1).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(5).getText());
		//平台分类
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(2).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(7).getText());
		//招商类型
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(3).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(9).getText());
		//招商说明
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(4).getText() + "  ");
		System.out.println(driver.findElement(By.xpath("//div[@class='description']")).getText());
		//合同时间
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(5).getText() + "  ");
		System.out.print(driver.findElements(By.xpath("//span")).get(12).getText());
		System.out.print(driver.findElements(By.xpath("//span")).get(13).getText());
		System.out.print(driver.findElements(By.xpath("//span")).get(14).getText());
		System.out.println(driver.findElements(By.xpath("//span")).get(15).getText());
		//预计招商会时间
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(6).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(17).getText());
		//计划入选数
		System.out.println(driver.findElements(By.xpath("//span[@class='preview-title']")).get(7).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='resource-alloc']")).getText());
		//竞争排位
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(8).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(20).getText());
		//未税促销服务费总额
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(9).getText() + "  ");
		System.out.print(driver.findElements(By.xpath("//span")).get(22).getText());
		System.out.println(driver.findElements(By.xpath("//span")).get(23).getText());
		//未税促销服务费步长
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(10).getText() + "  ");
		System.out.print(driver.findElements(By.xpath("//span")).get(25).getText());
		System.out.println(driver.findElements(By.xpath("//span")).get(26).getText());
		//联系人
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(11).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(28).getText());
		//联系手机
		System.out.print(driver.findElements(By.xpath("//span[@class='preview-title']")).get(12).getText() + "  ");
		System.out.println(driver.findElements(By.xpath("//span")).get(30).getText());
		*/
		driver.findElement(By.id("negotiation")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg publish']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary submit']")).click();
		//driver.switchTo().alert().accept();
		
	}
@AfterTest
	public void afterTest(){
		driver.quit();
	}

}