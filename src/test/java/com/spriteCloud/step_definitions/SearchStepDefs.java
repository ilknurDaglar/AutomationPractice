package com.spriteCloud.step_definitions;

import com.spriteCloud.pages.SearchPage;
import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchStepDefs {
    SearchPage searchPage = new SearchPage();
    String expectedTitle;
    String expectedOption;

    @Given("searches an item with the search box {string}")
    public void searches_an_item_with_the_search_box(String string) {
        searchPage.searchBox.sendKeys(string);
        searchPage.searchBtn.click();
        expectedTitle = string;

    }

    @Then("searched item name should be on the page")
    public void searchedItemNameShouldBeOnThePage() {
        String actualPage = Driver.get().findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        Assert.assertEquals(actualPage.equalsIgnoreCase(expectedTitle), expectedTitle.equalsIgnoreCase(actualPage));
    }

    @When("The user select {string} from sort by")
    public void theUserSelectFromSortBy(String Lowest) {
        Select priceDrop = new Select(searchPage.sortByDropdown);
        BrowserUtils.waitFor(2);

        priceDrop.selectByVisibleText(Lowest);
        expectedOption = "Price: Lowest first";

        String actualOption = priceDrop.getFirstSelectedOption().getText();
        BrowserUtils.waitFor(2);

        Assert.assertEquals(expectedOption, actualOption);

    }

    @Then("Items should be sorted from cheapest to expensive")
    public void items_should_be_sorted_from_cheapest_to_expensive() {
        searchPage.cheapestToExpensive();
    }

    @When("selected {string} from sortby")
    public void selectedFromSortby(String highest) {

        Select priceDrop = new Select(searchPage.sortByDropdown);
        BrowserUtils.waitFor(2);

        priceDrop.selectByVisibleText("Price: Highest first");
        expectedOption = "Price: Highest first";

        String actualOption = priceDrop.getFirstSelectedOption().getText();
        BrowserUtils.waitFor(9);

        Assert.assertEquals(expectedOption, actualOption);
    }


    @Then("Items should be sorted from most expensive to cheapest")
    public void items_should_be_sorted_from_most_expensive_to_cheapest() {

        searchPage.expensiveToCheapest();
    }

    @When("The user select {string} from dropdown")
    public void theUserSelectFromDropdown(String string) {
        Select select = new Select(searchPage.sortByDropdown);
        select.selectByVisibleText(string);
    }

    @Then("item should be sorted A_Z")
    public void itemShouldBeSortedA_Z() {

        searchPage.isItemsSortA_Z();
    }

    @When("selected {string} from dropdown")
    public void selected_from_dropdown(String string) {
        Select select = new Select(searchPage.sortByDropdown);
        select.selectByVisibleText(string);
    }

    @Then("item should be sorted Z_A")
    public void item_should_be_sorted_Z_A() {
        searchPage.isItemsSortZ_A();

    }


}