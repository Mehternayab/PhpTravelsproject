package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
	

	private By submit = By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']");
	private By lastname = By.xpath("//input[@placeholder='Last Name']");
	private By firstname = By.xpath("//input[@placeholder='First Name']");
	private By mobile = By.xpath("//input[@placeholder='Mobile Number']");
	private By Email = By.xpath("//input[@placeholder='Email']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By cpassword = By.xpath("//input[@placeholder='Confirm Password']");
	
	public WebElement getFirstname(WebDriver driver) throws IOException {
		return driver.findElement(firstname);
	}
	
	public WebElement getLastname(WebDriver driver) throws IOException {
		return driver.findElement(lastname);
	}
	
	public WebElement getMobile(WebDriver driver) throws IOException {
		return driver.findElement(mobile);
	}
	
	public WebElement getEmail(WebDriver driver) throws IOException {
		return driver.findElement(Email);
	}
	
	public WebElement getPassword(WebDriver driver) throws IOException {
		return driver.findElement(password);
	}
	
	public WebElement getCpassword(WebDriver driver) throws IOException {
		return driver.findElement(cpassword);
	}
	
	public WebElement getSubmit(WebDriver driver) throws IOException {
		return driver.findElement(submit);
	}
	
	public boolean check(WebDriver driver,Properties prop) throws IOException {
		String str = (String)driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
		System.out.println(str);
		System.out.println("Hi, "+prop.getProperty("fullname"));
		if(str.equals("Hi, "+prop.getProperty("fullname"))) { 
			System.out.println("pass");
			return true;
		}
		else {
			System.out.println("fail");
			return false;
		}
	}
	
}
