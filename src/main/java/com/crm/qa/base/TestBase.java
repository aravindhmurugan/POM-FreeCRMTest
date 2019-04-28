package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws FileNotFoundException {
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\Selenium\\Workspace\\FreeCRMTest\\src\\main\\"
					+ "java\\com\\crm\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		public static void initialization() throws FileNotFoundException{
			String browsername = prop.getProperty("browser");
			
			if(browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "E:/My Backups/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browsername.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "E:/My Backups/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			e_driver=new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}
		
	}

