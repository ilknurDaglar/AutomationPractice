package com.spriteCloud.step_definitions;

import com.spriteCloud.pages.CreateAccountPage;
import com.spriteCloud.pages.PaymentPage;
import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentStepDefs {
    PaymentPage paymentPage = new PaymentPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @And("the user clicks Proceed to checkout button on the payment page")
    public void theUserClicksProceedToCheckoutButtonOnThePaymentPage() {
        BrowserUtils.clickWithJS(paymentPage.proceedCheckoutBtn);
        BrowserUtils.waitFor(3);
    }


    @Then("Verify that address page should display")
    public void verify_that_address_page_should_display() {

        if (paymentPage.authentitaionPageTitle.getText().equals("AUTHENTICATION")) {
            createAccountPage.emailBtn.sendKeys("TTTiv@gmail.com");
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(createAccountPage.createBtn);
            BrowserUtils.waitFor(2);
            createAccountPage.firstname.sendKeys("Adam");
            createAccountPage.lastname.sendKeys("Sandler");
            createAccountPage.password.sendKeys("password");
            createAccountPage.address.sendKeys("263532");
            createAccountPage.city.sendKeys("213612");
            createAccountPage.postcode.sendKeys("36264");
            createAccountPage.phone.sendKeys("28838323");
            BrowserUtils.waitFor(1);
            Select select = new Select(createAccountPage.state);
            select.selectByVisibleText("Kentucky");
            createAccountPage.register.click();
            BrowserUtils.waitFor(2);

            BrowserUtils.clickWithJS(paymentPage.proceedCheckoutBtn);
        } else {
            Assert.assertEquals(paymentPage.addressPageTitle.getText(), "ADDRESSES");

        }
    }

    @Then("the user clicks proceed to checkout button")
    public void the_user_clicks_proceed_to_checkout_button() {
        BrowserUtils.waitFor(3);
        paymentPage.proceedCheckoutBtn.click();
    }

    @Then("the user clicks the I agree checkbox")
    public void the_user_clicks_the_I_agree_checkbox() {
        BrowserUtils.clickWithJS(paymentPage.shippingCheckBox);
        BrowserUtils.waitFor(2);

        BrowserUtils.clickWithJS(paymentPage.popUp);
    }

    @Then("Verify that payment page should display")
    public void verify_that_payment_page_should_display() {
        Assert.assertEquals(paymentPage.paymentPageTitle.getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");

    }


}
