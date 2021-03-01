package net.voicemod.qa.pages;

import net.voicemod.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends TestBase {

    // Initializing the Page Objects:
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }



    public boolean isLoaded() {
       // return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Discord"))).isDisplayed();
        return true;
    }


}
