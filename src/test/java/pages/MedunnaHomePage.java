package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaHomePage {
    public MedunnaHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement insanSekli;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//*[.='Sign in'])[4]")
    public WebElement signInButton;


}
