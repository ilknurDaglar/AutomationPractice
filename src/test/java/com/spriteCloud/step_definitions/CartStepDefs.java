package com.spriteCloud.step_definitions;

import com.spriteCloud.pages.CartPage;
import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartStepDefs {
    CartPage cartPage = new CartPage();
    int price1;
    int price2;

    @When("the user navigate to Women Page")
    public void the_user_navigate_to_Women_Page() {
        cartPage.womenPage.click();
    }

    @When("The user hover over the item picture")
    public void the_user_hover_over_the_item_picture() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(cartPage.item1).perform();
    }

    @When("The user should see the {string} pop up")
    public void the_user_should_see_the_pop_up(String string) {
        boolean addPop = cartPage.chartPop.isDisplayed();
        Assert.assertTrue("visible", addPop);
    }

    @And("The user click the Add to cart button {int}")
    public void theUserClickTheAddToCartButton(int number) {

        BrowserUtils.clickWithJS(cartPage.addToCart.get(number));
    }


    @When("The user should see the {string} popup message")
    public void the_user_should_see_the_popup_message(String string) {
        cartPage.continueOrproceedPop.isDisplayed();
        BrowserUtils.waitFor(5);
    }

    @When("The user click {string} button")
    public void the_user_click_button(String string) {
        BrowserUtils.clickWithJS(cartPage.continueBtn);
        BrowserUtils.waitFor(5);

    }

    @When("The user hover over other item picture")
    public void the_user_hover_over_other_item_picture() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(cartPage.item2).perform();
        BrowserUtils.waitFor(5);
    }

    @When("The user click on the {string} button")
    public void the_user_click_on_the_button(String proCheck) {
        BrowserUtils.clickWithJS(cartPage.checkout);

    }

    @When("Verify that the page title is {string}")
    public void verify_that_the_page_title_is(String string) {
        Assert.assertEquals("Your shopping cart", cartPage.yourCartPage.getText());
    }

    @Then("Verify that two selected items is in the basket")
    public void verifyThatTwoSelectedItemsIsInTheBasket() {
        cartPage.isInTheBasket();

    }

    @When("Verify that total price is sum of two prices and plus shipping")
    public void verify_that_total_price_is_sum_of_two_prices_and_plus_shipping() {
        cartPage.isPriceCorrect();

    }
}
