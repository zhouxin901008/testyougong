package LYZS;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.Test;

import WebTesting.WebLog;


public class WebTestingLYFB {
@Test
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public void LYFB() throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app");
		CharSequence a[] = new CharSequence[]{"120","15","240","1200","700","1000"};
		String b[] = new String[]{"【QA联营招标测试】01.09回归test1","【QA联营招标测试】01.09回归test1，填写招商说明要大于10个字"};
		WebDriver driver = new FirefoxDriver();
		Navigation navigation = driver.navigate();
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateFormat.format(date);
		System.out.println("联营采购方发标测试流程开始");
		WebLog.writeToFile(dateFormat.format(date) + " " + "联营采购方发标测试流程开始");
		//最大化浏览器
		driver.manage().window().maximize();
		navigation.to("http://dev.lsh123.com/bidding");
		Thread.sleep(1000);
		//输出网页标题
		String title = driver.getTitle();
		System.out.println("已登录:" + title);
		//输出URL
		System.out.println("检查是否为跳转到："+"http://dev.lsh123.com/bidding".equals(driver.getCurrentUrl()));
		driver.findElement(By.id("loginChildName")).sendKeys(new String[] {"admin"});
		driver.findElement(By.id("loginUserName")).sendKeys(new String[] {"wumart"});
		WebElement lsh = driver.findElement(By.id("loginPassword"));
		lsh.sendKeys(new String[] {"123456"});
		lsh.submit();
		Thread.sleep(1000);
		driver.findElement(By.linkText("我的联营招商项目")).click();
		System.out.println("是否进入“招商项目管理页面”:" + "招商项目管理－链商".equals(driver.getTitle()));
		Thread.sleep(1000);
		driver.findElement(By.linkText("新增招商项目")).click();
		System.out.println("是否进入“填写招商项目页面”:" + "填写招商项目－链商".equals(driver.getTitle()));
		WebLog.writeToFile(dateFormat.format(date) + " " + "进入页面:" + driver.getTitle());
		Thread.sleep(1000);
		//选择联营招商
		driver.findElement(By.xpath("//input[@value = '3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("title")).sendKeys(b[0]);
		driver.findElement(By.xpath("//textarea")).sendKeys(b[1]);
				
		//含税销售额、销售额折扣率、含税促销服务费
		driver.findElement(By.xpath("//select/option[@value='2']")).click();
		driver.findElement(By.xpath("//input[@data-id = '1001']")).sendKeys(a[0]);
		
		driver.findElement(By.xpath("//input[@data-id = '1002']")).sendKeys(a[1]);
		driver.findElement(By.xpath("//input[@data-id = '1004']")).sendKeys(a[2]);
		//设定目标值
		driver.findElement(By.xpath("//input[@data-id = '3001']")).sendKeys(a[3]);
		driver.findElement(By.xpath("//input[@data-id = '3002']")).sendKeys(a[4]);
		driver.findElement(By.xpath("//input[@data-id = '3004']")).sendKeys(a[5]);
		
		/*
		//未税销售额（显示销售额折扣率和费比）		
		driver.findElement(By.xpath("//select/option[@value='3']")).click();
		driver.findElement(By.xpath("//input[@data-id = '1001']")).sendKeys(new String[] {"120"});
		//设定目标值
		driver.findElement(By.xpath("//input[@data-id = '3001']")).sendKeys(new String[] {"1000"});
		driver.findElement(By.xpath("//input[@data-id = '3002']")).sendKeys(new String[] {"999"});
		driver.findElement(By.xpath("//input[@data-id = '3004']")).sendKeys(new String[] {"1001"});
		*/
		
		//选择铺位分类
		driver.findElement(By.xpath("//select/option[@value='U10,U02']")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("purchaseBegin")).sendKeys(new String[] {"2016-02-01"});
		driver.findElement(By.id("purchaseBegin")).click();
		driver.findElement(By.id("purchaseEnd")).sendKeys(new String[] {"2016-02-18"});
		driver.findElement(By.id("purchaseEnd")).click();
		driver.findElement(By.id("timeSite")).sendKeys(new String[] {"2016-02-20"});
		driver.findElement(By.id("timeSite")).click();
	
		driver.findElement(By.xpath("//input[@value='保存并预览']")).click();
		System.out.println("进入页面:" + driver.getTitle());
		WebLog.writeToFile(dateFormat.format(date) + " " + "进入页面:" + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.id("negotiation")).click();
		driver.findElement(By.cssSelector("#invitePreview > div.priview-buttons.text-center > button.btn.btn-primary.btn-lg.publish")).click();
		Thread.sleep(1000);
		System.out.println("弹出提示“确认发布招商计划？”："+driver.findElement(By.cssSelector("html body.modal-open div.l-container div#invitePreview.mod-invite-preview.form-horizontal div#inviteModal.modal.fade.in div.modal-dialog.modal-sm div.modal-content div.modal-header h4.modal-title")).getText().contains("确认发布招商计划？"));
		driver.findElement(By.cssSelector("html body.modal-open div.l-container div#invitePreview.mod-invite-preview.form-horizontal div#inviteModal.modal.fade.in div.modal-dialog.modal-sm div.modal-content div.modal-footer button.btn.btn-primary.submit")).click();
		//driver.switchTo().alert().accept();
		//关闭浏览器
		System.out.println("联营采购方发标流程测试结束");
		WebLog.writeToFile(dateFormat.format(date)+" "+"联营采购方发标流程测试结束");
		WebLog.writeToFile("———————————————————————————————————————————————————————————————————————");
		driver.quit();
				
	}

}