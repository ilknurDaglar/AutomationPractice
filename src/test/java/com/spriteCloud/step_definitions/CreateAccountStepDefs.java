package com.spriteCloud.step_definitions;

import com.spriteCloud.pages.CreateAccountPage;
import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountStepDefs {
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        createAccountPage.goToHomepage();
    }

    @When("the user click the signin button")
    public void the_user_click_the_signin_button() {
        BrowserUtils.waitFor(2);
        createAccountPage.signInBtn.click();

    }

    @Then("Authentication page should be display")
    public void authentication_page_should_be_display() {
        BrowserUtils.waitFor(2);

        String actualPage = Driver.get().findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
        Assert.assertEquals("AUTHENTICATION", actualPage);
    }

    @When("the user enters valid {string}")
    public void the_user_enters_valid(String validEmail) {
        createAccountPage.emailBtn.sendKeys(validEmail);
    }

    @When("click the Create an account button")
    public void click_the_Create_an_account_button() {
        BrowserUtils.waitFor(2);
        createAccountPage.createBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("Create an account page should be display")
    public void create_an_account_page_should_be_display() {

        Assert.assertEquals("CREATE AN ACCOUNT", createAccountPage.accountPage.getText());
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid(String invalidEmail) {

        createAccountPage.emailBtn.sendKeys(invalidEmail);
    }

    @Then("{string} pop should be display")
    public void popShouldBeDisplay(String arg0) {

        BrowserUtils.waitFor(3);
        createAccountPage.invaPop.isDisplayed();
    }

    @When("the user enters mail address")
    public void the_user_enters_mail_address() {
        createAccountPage.emailBtn.sendKeys("babciaaci.com");
    }

    @When("the user enters the valid {string},{string},\"{int},{string},{string},{string}, {string},")
    public void the_user_enters_the_valid(String firstname, String lastname, Integer password, String address, String city, String postcode, String phone) {

        createAccountPage.firstname.sendKeys(firstname);
        createAccountPage.lastname.sendKeys(lastname);
        BrowserUtils.waitFor(2);
        createAccountPage.password.sendKeys("password");
        createAccountPage.address.sendKeys(address);
        BrowserUtils.waitFor(2);
        createAccountPage.city.sendKeys(city);
        createAccountPage.postcode.sendKeys(postcode);
        BrowserUtils.waitFor(2);
        createAccountPage.phone.sendKeys(phone);
        BrowserUtils.waitFor(1);
    }

    @When("the user choose the state")
    public void the_user_choose_the_state() {
        Select select = new Select(createAccountPage.state);
        select.selectByVisibleText("Kentucky");
    }

    @When("the user click the register button")
    public void the_user_click_the_register_button() {

        createAccountPage.register.click();
        BrowserUtils.waitFor(3);
    }

    @Then("My Account page should display;")
    public void myAccountPageShouldDisplay() {
        Assert.assertEquals("MY ACCOUNT", createAccountPage.myAccountPage.getText());

    }

    @And("the user enters with new mail address")
    public void theUserEntersWithNewMailAddress() {
        createAccountPage.emailBtn.sendKeys("sananews@gmail.com");
    }

    @When("the user enters the invalid {string},{string},{string},{string},{string},{string}, {string},")
    public void the_user_enters_the_invalid(String firstname, String lastname, String password, String address, String city, String postcode, String phone) {


        createAccountPage.firstname.sendKeys(firstname);
        createAccountPage.lastname.sendKeys(lastname);
        BrowserUtils.waitFor(2);
        createAccountPage.password.sendKeys(password);
        createAccountPage.address.sendKeys(address);
        BrowserUtils.waitFor(2);
        createAccountPage.city.sendKeys(city);
        createAccountPage.postcode.sendKeys(postcode);
        BrowserUtils.waitFor(2);
        createAccountPage.phone.sendKeys(phone);
        BrowserUtils.waitFor(1);
    }


    @Then("My Account page should not display;")
    public void my_Account_page_should_not_display() {
        Assert.assertFalse(createAccountPage.myAccountPage.isDisplayed());

    }


}
