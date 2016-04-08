package com.mis.market.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MisHomecatPage {
	private WebElement element = null;
	private WebDriver driver = null;
	
	public MisHomecatPage(WebDriver driver){
		this.driver = driver; 
	}
	
	//mis模块
	public WebElement mis() throws InterruptedException{
		element = driver.findElements(By.xpath("//div[@class='title']")).get(5);
		Thread.sleep(1000);
		return element;
	}
	
	//品类推荐
	public WebElement homecat(){
		element = driver.findElement(By.linkText("- 品类推荐"));
		return element;
	}
	
	//check品类推荐list
	public WebElement homecatCheck(String name){
		List<WebElement> list = driver.findElements(By.name("cat_name"));
		for(WebElement element:list){
			if(element.getAttribute("value").equals(name)){
				//System.out.println("存在名称为：" + name + " 的品类");
				return element;
			}
		}
		System.out.println("不存在名称为：" + name + " 的品类");
		return null;
	}
	
	//添加
	public WebElement homecatInsert(){
		element = driver.findElement(By.xpath("//button[@class='add btn btn-primary btn-lg']"));
		return element;
	}
}
