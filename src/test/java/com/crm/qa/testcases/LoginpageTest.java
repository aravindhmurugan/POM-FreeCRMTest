package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginpageTest extends TestBase{
	
	Loginpage loginpage;
	Homepage homepage;
	
	public LoginpageTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws FileNotFoundException {
		initialization();
		loginpage = new Loginpage();
		
	}
	
	@Test(priority=1)
	public void crmtitletest() {
		String title = loginpage.validatetitle();
		Assert.assertEquals(title,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogotest() {
		Boolean flag = loginpage.validatecrmlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void crmsignUptest() {
		Boolean flag1 = loginpage.validateSignUp();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority=4)
	public void logintest() throws FileNotFoundException, InterruptedException {
	loginpage.login(prop.getProperty("un"), prop.getProperty("pwd"));
	
	}
	
	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}
	
	
	
	
	
	

}
