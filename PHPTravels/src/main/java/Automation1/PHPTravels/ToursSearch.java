package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToursSearch {
	By city_name = By.xpath("//span[contains(text(),'Search by Listing or City Name')]");
	By toursbtn = By.xpath("//a[@href='#tours']");
	By cookies = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By chickin = By.xpath("//input[@id='DateTours']");
	By month = By.xpath("//div[6]//nav[1]//div[2]");
	By nextbtn = By.xpath("//div[6]//nav[1]//div[3]");
	By adults = By.xpath("//div[contains(@class,'col-md-12')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	By submit = By.xpath("//div[contains(@class,'ftab-inner menu-horizontal-content')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	
	public void search(WebDriver driver) throws InterruptedException {
		driver.findElement(toursbtn).click();
	}
	
	public void selectCity(WebDriver driver,Properties prop) {
		driver.findElement(city_name).click();
		driver.findElement(By.xpath("//div[contains(text(),'"+prop.getProperty("tourname")+"')]")).click();
	}
	
	public void date(WebDriver driver,Properties prop) {
		driver.findElement(chickin).click();
		driver.findElement(month).click();
		String year = driver.findElement(month).getText();
		while(!year.equalsIgnoreCase(prop.getProperty("inyear"))) {
			driver.findElement(nextbtn).click();
			year = driver.findElement(month).getText();
			System.out.println(year);
		}
		driver.findElement(By.xpath("//div[@data-month='"+prop.getProperty("monthno")+"']")).click();
		for(int i = 1 ; i<=(7*6) ; i++) {
			String str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[6]//div[2]//div["+i+"]")).getText();
			if(str1.equals("1")) {
				for(int j = i ; j<=(6*7) ; j++) {
					str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[6]//div[2]//div["+j+"]")).getText();
					System.out.println(str1);
					if(str1.equals(prop.getProperty("indate"))) {
						driver.findElement(By.xpath("//div[@id='datepickers-container']//div[6]//div[2]//div["+j+"]")).click();
						return;
					}
				}
			}
		}
	}
	
	public void Guests(WebDriver driver) {
		driver.findElement(adults).click();
		 
	}
	
	public void tourtype(WebDriver driver) {
		driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Holidays')]")).click();
	}
	
	public boolean checkToursName(WebDriver driver,Properties prop) {
		String name = driver.findElement(By.xpath("//h2[@id='detail-content-sticky-nav-00']")).getText();
		if(name.equalsIgnoreCase(prop.getProperty("tourname"))) {
			System.out.println("pass");
			return true;
		}
		else {
			System.out.println("fail");
			return false;
		}
	}
}
