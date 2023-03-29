package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaLoginPage {
    public MedunnaLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Sign in'])[4]")
    public WebElement wlcomeToMedunna;
    @FindBy(linkText = "Items&Titles")
    public WebElement itemsAndTitles;
}
