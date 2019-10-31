package Automation1.PHPTravels;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearch {
	By hotel = By.xpath("//a[@href='#hotels']");
	By name = By.id("s2id_autogen1");
	By cookies = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By enterName = By.xpath("//div[@id='s2id_autogen1']//a[@class='select2-choice']");
	By search = By.xpath("//div[contains(@class,'col-md-2 col-xs-12 o1')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	By checkIn = By.id("checkin");
	By checkOut = By.id("checkout");
	By month = By.xpath("//div[2]//nav[1]//div[2]");
	By nextbtn = By.xpath("//div[2]//nav[1]//div[3]");
	By nextBtn = By.xpath("//body[@class='with-waypoint-sticky']/div[@id='datepickers-container']/div[2]/nav[1]/div[3]/*[1]");
	By adults = By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	By child = By.xpath("//div[contains(@class,'col 01')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	
	public void selectCity(WebDriver driver,Properties prop) {
		driver.findElement(name).click();
		driver.findElement(enterName).sendKeys(prop.getProperty("hotelname"));
		driver.findElement(By.xpath("//span[@class='select2-match'][contains(text(),'"+prop.getProperty("hotelname")+"')]")).click();
	}
	
	public void chickIn(WebDriver driver,Properties prop) throws IOException {
		driver.findElement(checkIn).click();
		driver.findElement(month).click();
		String year = driver.findElement(month).getText();
		while(!year.equalsIgnoreCase(prop.getProperty("inyear"))) {
			driver.findElement(nextbtn).click();
			year = driver.findElement(month).getText();
			System.out.println(year);
		}
		driver.findElement(By.xpath("//div[@class='datepicker--cell datepicker--cell-month'][contains(text(),'"+prop.getProperty("monthtext")+"')]")).click();
		for(int i = 1 ; i<=(7*6) ; i++) {
			String str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[1]//div[1]//div[1]//div[2]//div["+i+"]")).getText();
			if(str1.equals("1")) { 
				for(int j = i ; j<=(6*7) ; j++) {
					str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[1]//div[1]//div[1]//div[2]//div["+j+"]")).getText();
					System.out.println(str1);
					if(str1.equals(prop.getProperty("indate"))) {
						driver.findElement(By.xpath("//div[@id='datepickers-container']//div[1]//div[1]//div[1]//div[2]//div["+j+"]")).click();
						return;
					}
				}
			}
		}
	}
	public void chickOut(WebDriver driver,Properties prop) throws IOException, InterruptedException{
		driver.findElement(checkOut).click();
		driver.findElement(By.xpath("//div[2]/div[2]/nav[1]/div[2]")).click();
		String year = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();
		System.out.println(year);
		while(!year.equalsIgnoreCase(prop.getProperty("outyear"))) {
			driver.findElement(nextBtn).click();
			year = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]")).getText();
			System.out.println(year);
		}
		driver.findElement(By.xpath("//div[@class='datepicker--months datepicker--body active']//div[@class='datepicker--cell datepicker--cell-month'][contains(text(),'"+prop.getProperty("month")+"')]")).click();
		for(int i = 1 ; i<=(7*6) ; i++) {
			String str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//div[1]//div[1]//div[2]//div["+i+"]")).getText();
			if(str1.equals("1")) { 
				for(int j = i ; j<=(6*7) ; j++) {
					str1 = driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//div[1]//div[1]//div[2]//div["+j+"]")).getText();
					System.out.println(str1);
					if(str1.equals(prop.getProperty("outdate"))) {
						driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//div[1]//div[1]//div[2]//div["+j+"]")).click();
						return;
					}
				}
			}
		}
	}
	public void noOfGuest(WebDriver driver,Properties prop) {
		driver.findElement(adults).click();
		driver.findElement(child).click();
		
	}
	
	public boolean checkHotelName(WebDriver driver,Properties prop) {
		String name = driver.findElement(By.xpath("//span[@class='text-primary']")).getText();
		if(name.equalsIgnoreCase(prop.getProperty("hotelname"))) {
			System.out.println("pass");
			return true;
		}
		else {
			System.out.println("fail");
			return false;
		}
	}
}
