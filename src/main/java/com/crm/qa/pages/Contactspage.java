package com.crm.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Contactspage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contactslabel;
	
//	@FindBy(name="title")
//	WebElement contacttitle;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public Contactspage() throws FileNotFoundException{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatecontactlabel() {
		return Contactslabel.isDisplayed();
	}
	
	public void selectsinglecontact(String name) {
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	//	driver.findElement(By.xpath("//a[text()='Marvel studio']//parent::td[@class='datalistrow']"
	//			+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createnewcontact (String title, String ftname, String ltname, String compname) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(compname);
		saveBtn.click();
		
	}

}
