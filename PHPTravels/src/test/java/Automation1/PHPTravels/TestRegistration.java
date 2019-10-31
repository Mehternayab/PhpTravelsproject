package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestRegistration {
	Logger Log = Logger.getLogger("TestRegistration");
	@Test
	public void registration() throws InterruptedException, IOException {
		
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\log4j.properties");
		Launch l = new Launch();
		Registration r = new Registration();
		Properties prop = l.pro();
		WebDriver driver = l.getDriver();
		driver.get(prop.getProperty("url"));
		driver.findElement(l.MyAccount).click();
		driver.findElement(l.signup).click();
		r.getFirstname(driver).sendKeys(prop.getProperty("firstname"));
		r.getLastname(driver).sendKeys(prop.getProperty("leastname"));
		r.getMobile(driver).sendKeys(prop.getProperty("mobile"));
		r.getEmail(driver).sendKeys(prop.getProperty("Email"));
		r.getPassword(driver).sendKeys(prop.getProperty("password"));
		r.getCpassword(driver).sendKeys(prop.getProperty("cpassword"));
		System.out.println(prop.getProperty("Email"));
		r.getSubmit(driver).click();
		boolean result = r.check(driver,prop);
		Log.info(result);
		driver.close();
	}

}
