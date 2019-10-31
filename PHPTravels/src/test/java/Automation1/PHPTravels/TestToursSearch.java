package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestToursSearch {
	Logger Log = Logger.getLogger("TestLogin");
	@Test
	public void ToursSearch() throws  InterruptedException, IOException {
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\log4j.properties");
		Launch l = new Launch();
		ToursSearch ts = new ToursSearch();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		driver.findElement(ts.cookies).click();
		ts.search(driver);
		ts.selectCity(driver, prop);
		ts.date(driver, prop);
		ts.Guests(driver);
		ts.tourtype(driver);
		driver.findElement(ts.submit).click();
		boolean result = ts.checkToursName(driver, prop);
		Log.info(result);
		driver.close();
		
	}
}