package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomepageTest extends TestBase {
	TestUtil testutil;
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;
	
	public HomepageTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws FileNotFoundException, InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginpage = new Loginpage();
		homepage = new Homepage();
		contactspage = new Contactspage();
		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("pwd"));
	}
	
	@Test(priority=1)
		public void homepagetitletest() {
		String hometitle = homepage.validatehomepagetitle();
		Assert.assertEquals(hometitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void userlabeltest() {
//		driver.switchTo().frame("mainpanel");
		testutil.switchtoframemain();
		boolean flag2 = homepage.validateuserlabel();
		Assert.assertTrue(flag2);
	}
	
	@Test(priority=3)
	public void newcontacttest() throws FileNotFoundException {
//	driver.switchTo().frame("mainpanel");
 testutil.switchtoframemain();
		contactspage = homepage.clickonnewcontacts();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
