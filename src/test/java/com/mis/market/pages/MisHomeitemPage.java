package com.mis.market.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MisHomeitemPage {
	private WebElement element = null;
	private WebDriver driver = null;
	
	public MisHomeitemPage(WebDriver driver){
		this.driver = driver; 
	}
	
	//mis模块
	public WebElement mis() throws InterruptedException{
		element = driver.findElements(By.xpath("//div[@class='title']")).get(6);
		Thread.sleep(1000);
		return element;
	}
			
	//品类推荐
	public WebElement homeitem(){
		element = driver.findElement(By.linkText("- 单品推荐"));
		return element;
	}
	
}