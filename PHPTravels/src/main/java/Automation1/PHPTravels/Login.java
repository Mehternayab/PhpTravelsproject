package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	By myaccount = By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']");
	By login = By.xpath("//a[@class='dropdown-item active tr']");
	By Email = By.xpath("//input[@placeholder='Email']");
	By pass = By.xpath("//input[@placeholder='Password']");
	By loginbtn = By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");
	
	public void log(WebDriver driver, Properties prop) {
		driver.findElement(myaccount).click();
		driver.findElement(login).click();
		driver.findElement(Email).click();
		driver.findElement(Email).sendKeys(prop.getProperty("Email")); 
		driver.findElement(pass).click();
		driver.findElement(pass).sendKeys(prop.getProperty("password"));
		driver.findElement(loginbtn).click();
	}
	public boolean checkName(WebDriver driver,Properties prop) {
		String name = driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
		if(name.equals("Hi, "+prop.getProperty("fullname"))) {
			System.out.println("pass");
			return true;
		}
		else {
			System.out.println("fail");
			return false;
		}
	}
}
