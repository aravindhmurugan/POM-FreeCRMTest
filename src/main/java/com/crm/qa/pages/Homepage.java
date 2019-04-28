package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
	@FindBy(xpath="//tr//td[contains(text(),'User: Aravindh Murugan')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Taskslink;
	
	public Homepage() throws FileNotFoundException{
		PageFactory.initElements(driver, this);
	}
	
	public String validatehomepagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateuserlabel() {
		return usernamelabel.isDisplayed();
	}
	
	public Contactspage clickonnewcontacts() throws FileNotFoundException {
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactslink.click();
		return new Contactspage();
	}
	
	public Taskspage clickontaskslink() {
		Taskslink.click();
		return new Taskspage();
	}

	public Dealspage clickondealslink() {
		Dealslink.click();
		return new Dealspage();
	}
	
	public Contactspage clickoncontactslink() throws FileNotFoundException {
		contactslink.click();
		return new Contactspage();
	}
}
