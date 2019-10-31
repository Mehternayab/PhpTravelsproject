package Automation1.PHPTravels;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FlightSearch {
	By flight = By.xpath("//a[@href='#flights']");
	By cookies = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By toLocation = By.xpath("//div[@id='s2id_location_from']");
	By tLocation = By.xpath("//div[@id='s2id_location_from']//a[@class='select2-choice']");
	By fromLocation = By.xpath("//div[@id='s2id_location_to']");
	By fLocation = By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']");
	By oneway = By.xpath("//label[contains(text(),'One Way')]");
	By search = By.xpath("//div[2]/div[4]/button[1]");
	By departure = By.xpath("//input[@id='FlightsDateStart']");
	By month = By.xpath("//div[7]//nav[1]//div[2]");
	By nextbtn = By.xpath("//div[7]//nav[1]//div[3]");
	By Economy = By.xpath("//span[contains(text(),'Economy')]");
	By madult = By.xpath("//div[@id='flights']//div[contains(@class,'row gap-5')]//div[1]//div[1]//div[2]//div[1]//span[3]//button[1]");
	By mchildren = By.xpath("//div[@id='flights']//div[contains(@class,'row gap-10 mb-15 align-items-end')]//div[2]//div[1]//div[2]//div[1]//span[3]//button[1]");
	By minfant = By.xpath("//div[contains(@class,'col-md-3 col-xs-12')]//div[3]//div[1]//div[2]//div[1]//span[3]//button[1]");
	
	public void toLocation(WebDriver driver,Properties prop) throws InterruptedException {
		driver.findElement(toLocation).click();
		driver.findElement(tLocation).sendKeys(prop.getProperty("fromlocation"));
		Thread.sleep(2000);
		driver.findElement(tLocation).sendKeys(Keys.ENTER);
		
	}
	
	public void fromLocation(WebDriver driver,Properties prop) throws InterruptedException {
		driver.findElement(fromLocation).click();
		driver.findElement(fLocation).sendKeys(prop.getProperty("tolocation"));
		Thread.sleep(2000);
		driver.findElement(fLocation).sendKeys(Keys.ENTER);
		
	}
	public void departure(WebDriver driver,Properties prop) {
		driver.findElement(departure).click();
		driver.findElement(month).click();
		String year = driver.findElement(month).getText();
		while(!year.equalsIgnoreCase(prop.getProperty("inyear"))) {
			driver.findElement(nextbtn).click();
			year = driver.findElement(month).getText();
			System.out.println(year);
		}
		driver.findElement(By.xpath("//div[@data-month='"+prop.getProperty("monthno")+"']")).click();
		for(int i = 1 ; i<=(7*6) ; i++) {
			String str1 = driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+i+"]")).getText();
			if(str1.equals("1")) {
				for(int j = i ; j<=(6*7) ; j++) {
					str1 = driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+j+"]")).getText();
					System.out.println(str1);
					if(str1.equals(prop.getProperty("indate"))) {
						driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+j+"]")).click();
						return;
					}
				}
			}
		}
	}

	public void guests(WebDriver driver,Properties prop) throws InterruptedException {
		int n = Integer.parseInt(prop.getProperty("adult"));
		for(int i=0 ; i < n-1 ; i++ ) {
		driver.findElement(madult).click();
		}
		driver.findElement(mchildren).click();
		driver.findElement(minfant).click();
	}
	
	public boolean ckeckFlightResult(WebDriver driver,Properties prop) {
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(prop.getProperty("title"))) {
			System.out.println("pass");
			return true;
		}
		else {
			System.out.println("fail");
			return false;
		}
	}
}
