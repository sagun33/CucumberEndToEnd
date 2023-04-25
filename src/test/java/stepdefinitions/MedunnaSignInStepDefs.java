package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.Driver;


public class MedunnaSignInStepDefs {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();

    @When("click on user icon")
    public void click_on_user_icon() {

        medunnaHomePage.userIcon.click();
    }

    @When("click on Sign In option")
    public void click_on_sign_in_option() {

        medunnaHomePage.signInOption.click();
    }

    @When("enter {string} in Username input")
    public void enter_in_username_input(String username) {

        medunnaLoginPage.usernameInput.sendKeys(username);
    }

    @When("enter {string} in Password input")
    public void enter_in_password_input(String password) {

        medunnaLoginPage.passwordInput.sendKeys(password);
    }

    @When("click on Remember Me checkbox")
    public void click_on_remember_me_checkbox() {

        medunnaLoginPage.rememberMeCheckbox.click();
    }
    @When("click on Sign In submit button")
    public void click_on_sign_in_submit_button() {

        medunnaLoginPage.signInSubmitButton.click();
    }

    @Given("user is on {string} page")
    public void userIsOnPage(String url) {
        Driver.getDriver().get(url);
    }

    @And("close the application")
    public void closeTheApplication() {
        Driver.closeDriver();
    }
}
