package net.voicemod.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.voicemod.qa.base.TestBase;

public class SoundBoardPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Voice changer for PC')]")
	WebElement voiceChangerLink;

	@FindBy(xpath = "//a[contains(text(),'Soundboard')]")
	WebElement soundBoardLink;


	@FindBy(xpath = "//a[contains(text(),'Voicelab')]")
	WebElement voiceLabLink;

	@FindBy(xpath = "//a[contains(text(),'GET VOICEMOD FREE')]")
	WebElement buttonLink;


	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public SoundBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	

	

	
	

}
