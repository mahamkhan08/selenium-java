package net.voicemod.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.voicemod.qa.base.TestBase;

public class VoiceChangerPage extends TestBase{
	


	@FindBy(xpath="//button[contains(text(),'GET VOICEMOD FREE')]")
	WebElement getBtn;
	
	@FindBy(xpath="//img[contains(@id,'logo')]")
	WebElement voiceLogo;
	
	//Initializing the Page Objects:
	public VoiceChangerPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateVoiceChangerPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateVoiceImage(){
		return voiceLogo.isDisplayed();
	}
	

	
}
