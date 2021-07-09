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

        Select priceDrop = new Select(searchPage.sortByDropdown);
        priceDrop.selectByVisibleText("Price: Lowest first");
        BrowserUtils.waitFor(5);

        List<Integer> allPrices = new ArrayList<>();
        List<WebElement> numberOfviews = searchPage.Prices;

        for (WebElement each : numberOfviews) {
            int taprice = Integer.parseInt(each.getText().replace("$", "").replace(",", "").replace(".", ""));
            allPrices.add(taprice);

        }
        System.out.println(allPrices);
        BrowserUtils.waitFor(10);
        for (int i = 0; i < allPrices.size() - 1; i++) {
            Assert.assertTrue(allPrices.get(i) < allPrices.get(i + 1));


        }
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

    //BUG 2
    @Then("Items should be sorted from most expensive to cheapest")
    public void items_should_be_sorted_from_most_expensive_to_cheapest() {
        Select priceDrop = new Select(searchPage.sortByDropdown);
        priceDrop.selectByVisibleText("Price: Highest first");
        BrowserUtils.waitFor(5);
        List<Integer> allPrices = new ArrayList<>();
        List<WebElement> numberOfviews = searchPage.Prices;

        for (WebElement each : numberOfviews) {
            int taprice = Integer.parseInt(each.getText().replace("$", "").replace(",", "").replace(".", ""));
            allPrices.add(taprice);

        }
        System.out.println(allPrices);
        BrowserUtils.waitFor(10);
        for (int i = 0; i < allPrices.size() - 1; i++) {
            Assert.assertTrue(allPrices.get(i) > allPrices.get(i + 1));


        }

    }

    @When("The user select {string} from dropdown")
    public void theUserSelectFromDropdown(String string) {
        Select select = new Select(searchPage.sortByDropdown);
        select.selectByVisibleText(string);
    }

    @Then("item should be sorted alphabetically")
    public void itemShouldBeSortedAlphabetically() {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//h5[@itemprop='name']"));
        List<String> elementsText = BrowserUtils.getElementsText(elements);


        List<String> eachText = new ArrayList<>();
        for (String each : elementsText) {
            String s = each.replaceAll(" ", "").toLowerCase();
            eachText.add(s);

        }

        System.out.println(eachText);

        for (int i = 0; i < eachText.size() - 1; i++) {
            System.out.println(eachText.get(i).compareTo(eachText.get(i + 1)));

            Assert.assertTrue(eachText.get(i).compareTo(eachText.get(i + 1)) <= 0);

        }

    }

    @When("selected {string} from dropdown")
    public void selected_from_dropdown(String string) {
        Select select = new Select(searchPage.sortByDropdown);
        select.selectByVisibleText(string);
    }

    @Then("item should be sorted Z_A")
    public void item_should_be_sorted_Z_A() {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//h5[@itemprop='name']"));
        List<String> elementsText = BrowserUtils.getElementsText(elements);


        List<String> eachText = new ArrayList<>();
        for (String each : elementsText) {
            String s = each.replaceAll(" ", "").toLowerCase();
            eachText.add(s);

        }

        System.out.println(eachText);

        for (int i = 0; i < eachText.size() - 1; i++) {
            System.out.println(eachText.get(i).compareTo(eachText.get(i + 1)));

            Assert.assertTrue(eachText.get(i).compareTo(eachText.get(i + 1)) >= 0);


        }

    }
}
