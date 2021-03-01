package net.voicemod.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import net.voicemod.qa.util.TestUtil;
import net.voicemod.qa.util.WebEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.voicemod.qa.util.TestUtil.getFileFromResourceAsStream;
import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/net/voicemod"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FirefoxProfile firefoxProfile() throws Exception {

		String downloadPath = prop.getProperty("downloadpath");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("browser.download.dir",downloadPath);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/x-msdownload");



		return profile;
	}
	
	public static void initialization() throws Exception {
		String browserName = prop.getProperty("browser");

		String pathToFFDriver = prop.getProperty("webdriverpath");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "\\resources\\windows\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", pathToFFDriver);
			FirefoxOptions opt = new FirefoxOptions();
			opt.setProfile(firefoxProfile());
			driver = new FirefoxDriver(opt);

		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
