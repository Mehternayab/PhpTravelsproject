package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestFlightSearch {
	Logger Log = Logger.getLogger("TestFlightSearch");
	@Test
	public void flightSearch() throws IOException, InterruptedException {
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\log4j.properties");
		Launch l = new Launch();
		FlightSearch fs = new FlightSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.findElement(fs.cookies).click();
		driver.findElement(fs.flight).click();
		Thread.sleep(1000);
		fs.toLocation(driver,prop);
		fs.fromLocation(driver,prop);
		fs.departure(driver, prop);
		driver.findElement(fs.Economy).click();
		driver.findElement(fs.oneway).click();
		fs.guests(driver,prop);
		driver.findElement(fs.search).click();
		boolean result = fs.ckeckFlightResult(driver, prop);
		Log.info(result);
		driver.close();
	}
	
}