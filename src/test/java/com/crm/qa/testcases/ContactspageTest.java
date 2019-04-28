package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class ContactspageTest extends TestBase{
	
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;
	TestUtil testutil;
	
	String sheetName = "contacts";

	public ContactspageTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginpage = new Loginpage();
		homepage = new Homepage();
		contactspage = new Contactspage();	
		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		testutil.switchtoframemain();
		contactspage = homepage.clickoncontactslink();
	}
	
	@Test(priority = 1)
	public void contactslabeltest() {
		boolean flag4 = contactspage.validatecontactlabel();
		Assert.assertTrue(flag4);
		
	}
	
	@Test(priority=2)
	public void selectonecontact() {
	
	driver.findElement(By.xpath("//a[text()='Marvel studio']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	contactspage.selectsinglecontact("vetri vel");
	}
	
	@Test(priority=3)
	public void selectmultiplecontact() {
		contactspage.selectsinglecontact("Marvel studio");
		contactspage.selectsinglecontact("vetri vel");
	}
	
	@DataProvider
	public Object[][] getCRMdata() throws InvalidFormatException {
 //   	Object data[][] = testutil.gettestdata(sheetName);
		Object data[][] = TestUtil.gettestdata(sheetName);
		return data;	
	}
	
	@Test(priority=4, dataProvider="getCRMdata")
	public void createnewcontactmain(String title, String firstname, String lastname, String company) throws FileNotFoundException {
		homepage.clickonnewcontacts();
		contactspage.createnewcontact(title, firstname, lastname, company);
	}
	
	@Test(priority=3)
	public void selectcontact() throws FileNotFoundException {
		homepage.clickonnewcontacts();
		contactspage.createnewcontact("Mr.", "Tom", "Peter", "Google");
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText("Mr.");
	}
	
	@AfterMethod
 		public void tearDown() {
		driver.quit();
	}

}
