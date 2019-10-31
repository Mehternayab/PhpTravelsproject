package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestLogin {
	Logger Log = Logger.getLogger("TestLogin");
	@Test
	public void login() throws IOException, InterruptedException {
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\log4j.properties");
		Launch l = new Launch();
		Login li = new Login();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		li.log(driver,prop);
		boolean result = li.checkName(driver, prop);
		Log.info(result);
		driver.close();
	}
	

}
