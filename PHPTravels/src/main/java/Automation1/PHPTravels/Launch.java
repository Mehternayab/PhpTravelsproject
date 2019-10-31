package Automation1.PHPTravels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Launch {
	
	By dropdown = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']");
	By signup = By.xpath("//a[@class='dropdown-item tr']");
	By MyAccount = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']");
	
	public Properties pro() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Online Test\\git\\PhpProject\\PHPTravels\\src\\main\\java\\Automation1\\PHPTravels\\data.properties");
		prop.load(fis);
		return prop;
	}
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Online Test\\Desktop\\Mehter Nayab\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		return driver;
	} 
	
}
