package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestHotelsSearch {
	Logger Log = Logger.getLogger("TestHotelsSearch");
	@Test
	public void hotelSerch() throws InterruptedException, IOException {
		
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\log4j.properties");
		Launch l = new Launch();
		HotelSearch hs = new HotelSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		driver.findElement(hs.cookies).click();
		driver.findElement(hs.hotel).click();
		hs.selectCity(driver, prop);
		hs.chickIn(driver,prop);
		hs.chickOut(driver,prop);
		hs.noOfGuest(driver,prop);
		driver.findElement(hs.search).click();
		boolean result = hs.checkHotelName(driver, prop);
		Log.info(result);
		driver.close();
		
	}
}
