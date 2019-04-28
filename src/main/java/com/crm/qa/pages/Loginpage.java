package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement passsword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	public Loginpage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}
	
	public String validatetitle() {
		
	return driver.getTitle();
	
	}	
	
	public boolean validatecrmlogo() {
		
		return crmlogo.isDisplayed();
		
	}	
	
	public boolean validateSignUp() {
		
		return SignUpBtn.isDisplayed();
	}
	
	public Homepage login(String un, String pwd) throws FileNotFoundException, InterruptedException {
		username.sendKeys(un);
		passsword.sendKeys(pwd);
		
Thread.sleep(7000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		loginbtn.click();
		return new Homepage ();
	
	}
	
	
}
