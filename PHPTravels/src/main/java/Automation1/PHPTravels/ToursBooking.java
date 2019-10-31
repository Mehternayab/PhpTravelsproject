package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToursBooking {
	By book = By.xpath("//button[@class='btn btn-secondary btn-block mt-20 btn-action btn-lg loader']");
	By firstname = By.xpath("//input[@placeholder='First Name']");
	By lastname = By.xpath("//input[@placeholder='Last Name']");
	By Email = By.xpath("//div[@class='col-md-5 col-xs-12']//input[@placeholder='Email']");
	By cEmail = By.xpath("//input[@placeholder='Confirm Email']");
	By submit = By.xpath("//button[@name='guest']");
	By contact = By.xpath("//input[@placeholder='Contact Number']");
	By address = By.xpath("//input[@placeholder='Address']");
	
	public void toursbooking(WebDriver driver,Properties prop) throws InterruptedException {
		driver.findElement(book).click();
		driver.findElement(firstname).click();
		driver.findElement(firstname).sendKeys(prop.getProperty("firstname"));
		driver.findElement(lastname).click();
		driver.findElement(lastname).sendKeys(prop.getProperty("leastname"));
		driver.findElement(Email).click();
		driver.findElement(Email).sendKeys(prop.getProperty("Email"));
		driver.findElement(cEmail).click();
		driver.findElement(cEmail).sendKeys(prop.getProperty("Email"));
		driver.findElement(contact).click();
		driver.findElement(contact).sendKeys(prop.getProperty("mobile"));
		driver.findElement(address).click();
		driver.findElement(address).sendKeys(prop.getProperty("address"));
		driver.findElement(By.xpath("//a[@class='select2-choice']")).click();
		driver.findElement(By.xpath("//a[@class='select2-choice']")).sendKeys("india");
		driver.findElement(By.xpath("//a[@class='select2-choice']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']//div[@class='select2-result-label']")).click();
		driver.findElement(submit).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']//button[@data-module='tours']"))).click();
		driver.switchTo().alert().accept();
		
	}
}
