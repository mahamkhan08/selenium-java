package net.voicemod.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.voicemod.qa.base.TestBase;

public class HomePage extends TestBase {

		@FindBy(xpath = "//a[contains(text(),'Voice changer for PC')]")
	WebElement voiceChangerLink;
	
	@FindBy(xpath = "//a[contains(text(),'Soundboard')]")
	WebElement soundBoardLink;


	@FindBy(xpath = "//a[contains(text(),'Voicelab')]")
	WebElement voiceLabLink;
	@FindBy(how = How.CLASS_NAME, using = "voicemod-button")
	WebElement buttonLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}





	public SoundBoardPage clickOnSoundboardLink(){
		soundBoardLink.click();
		return new SoundBoardPage();
	}
	
	public VoiceLabPage clickOnVoiceLabLink(){
		voiceLabLink.click();
		return new VoiceLabPage();
	}
	
	public VoiceChangerPage clickOnVoiceChangerLink(){
		voiceChangerLink.click();
		return new VoiceChangerPage();
	}
	
	public void clickOnButtonLink(){
		Actions act = new Actions(driver);
		act.click(buttonLink);
		Action action  = act.build();
		action.perform();



		
	}


	
	
	
	
	
	
	

}
