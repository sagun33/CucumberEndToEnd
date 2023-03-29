package stepdefinitions.uistepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class RoomOlusturmaStepDefinition {
    MedunnaHomePage medunnaHomePage=new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage=new MedunnaLoginPage();

    @Given("kullanici medunna sayfasina gider")
    public void kullanici_medunna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }
    @Given("kullanici signIn butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() throws InterruptedException {
        medunnaHomePage.insanSekli.click();
        medunnaHomePage.signInLink.click();
        Thread.sleep(3000);


    }
    @Given("acilan sayfada user name girer")
    public void acilan_sayfada_user_name_girer() throws InterruptedException {
        medunnaHomePage.userName.click();
        medunnaHomePage.userName.sendKeys("sagun33");
        Thread.sleep(3000);

    }
    @Given("daha sonra password girer")
    public void daha_sonra_password_girer() throws InterruptedException {
        medunnaHomePage.password.click();
        medunnaHomePage.password.sendKeys("Bismillah1982.");
        Thread.sleep(3000);

    }
    @Given("daha sonra signIn butonuna tiklar")
    public void daha_sonra_sign_in_butonuna_tiklar() {
        medunnaHomePage.signInButton.click();

    }
    @Then("kullanici sign in yaptigini kontrol eder")
    public void kullanici_sign_in_yaptigini_kontrol_eder() throws InterruptedException {
        medunnaLoginPage.wlcomeToMedunna.isDisplayed();
        Thread.sleep(3000);


    }
    @Given("kullanici itemsAndTitle tiklar")
    public void kullanici_items_and_title_tiklar() {

    }
    @Given("kullanici rooma tiklar")
    public void kullanici_rooma_tiklar() {

    }
    @Given("acilan sayfada create a room butonuna tiklar")
    public void acilan_sayfada_create_a_room_butonuna_tiklar() {

    }
    @Given("room number kutusuna room numarasi girer")
    public void room_number_kutusuna_room_numarasi_girer() {

    }
    @Given("room type kutusuna room Type girer")
    public void room_type_kutusuna_room_type_girer() {

    }
    @Given("status radio butonuna tiklar")
    public void status_radio_butonuna_tiklar() {

    }
    @Given("price kutusuna orice girer")
    public void price_kutusuna_orice_girer() {

    }
    @Given("Description kutusuna birseyler yazar")
    public void description_kutusuna_birseyler_yazar() {
        /
    }
    @Given("creates date butonuna tiklar")
    public void creates_date_butonuna_tiklar() {

    }
    @Given("save butonuna tiklar")
    public void save_butonuna_tiklar() {

    }
    @Then("girmis oldugu room numberin varligini dogrular")
    public void girmis_oldugu_room_numberin_varligini_dogrular() {

    }


}
