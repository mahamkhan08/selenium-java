package net.voicemod.qa.testcases;

import net.voicemod.qa.pages.SoundBoardPage;
import net.voicemod.qa.pages.VoiceChangerPage;
import net.voicemod.qa.util.DownloadUitl;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.voicemod.qa.base.TestBase;
import net.voicemod.qa.pages.HomePage;
import net.voicemod.qa.util.TestUtil;

import java.io.File;

import static net.voicemod.qa.util.DownloadUitl.getDownloadedDocumentName;
import static net.voicemod.qa.util.DownloadUitl.isFileDownloaded_Ext;
import static org.junit.Assert.assertTrue;

public class HomePageTest extends TestBase {
	SoundBoardPage sbPage;
	HomePage homePage;

	VoiceChangerPage vcPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();

		vcPage = new VoiceChangerPage();
		sbPage = new SoundBoardPage();
		homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Free Real Time Voice Changer & Modulator - Voicemod","Home page title not matched");
	}

	@Test(priority=2)
	public void verifyButtonClick() {
		homePage.clickOnButtonLink();
		System.out.println("Button clicked");

	}
	@Test(priority=3)
	public void verifyDownloadWithFileName() {
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
		String dlpath=prop.getProperty("downloadpath");


		driver.get(prop.getProperty("downloadurl"));
		driver.findElement(By.linkText("GET VOICEMOD FREE")).click();
		String file_dled= getDownloadedDocumentName(dlpath,".exe");
		//wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));

		//homePage.clickOnButtonLink();
		org.junit.Assert.assertTrue("Failed to download Expected document", DownloadUitl.isFileDownloaded(dlpath, file_dled));
	}

	@Test(priority=4)
	public void verifyDownloadWithFileExtension() {
		homePage.clickOnButtonLink();
		org.junit.Assert.assertTrue("Failed to download document which has extension .exe",
				isFileDownloaded_Ext(prop.getProperty("downloadpath"), ".exe"));
	}

	@Test(priority=5)
	public void verifyExpectedFileName() {
		homePage.clickOnButtonLink();
		File getLatestFile = DownloadUitl.getLatestFilefromDir(prop.getProperty("downloadpath"));
		String fileName = getLatestFile.getName();
		org.junit.Assert.assertTrue("Downloaded file name is not matching with expected file name", fileName.equals(prop.getProperty("filetodl")));
	}






	@Test(priority=3)
	public void verifySoundBoardLinkTest(){
		sbPage = homePage.clickOnSoundboardLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
