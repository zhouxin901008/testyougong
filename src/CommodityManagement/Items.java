package CommodityManagement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Basic.BasicDriver;

public class Items extends BasicDriver{
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void itemstest() throws InterruptedException{
		BasicDriver.open();
		BasicDriver.login();
	}
}
