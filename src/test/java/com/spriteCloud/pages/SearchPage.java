package com.spriteCloud.pages;

import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"search_query_top\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    public WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]")
    public WebElement searchPage;

    @FindBy(xpath = "//*[@id=\"selectProductSort\"]")
    public WebElement sortByDropdown;

    @FindBy(xpath = "//div[@class='right-block']//span[@itemprop='price']")
    public List<WebElement> Prices;


    public void cheapestToExpensive(){
        Select priceDrop = new Select(sortByDropdown);
        priceDrop.selectByVisibleText("Price: Lowest first");
        BrowserUtils.waitFor(5);

        List<Integer> allPrices = new ArrayList<>();
        List<WebElement> numberOfviews = Prices;

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

     public void expensiveToCheapest() {
         Select priceDrop = new Select(sortByDropdown);
         priceDrop.selectByVisibleText("Price: Highest first");
         BrowserUtils.waitFor(5);
         List<Integer> allPrices = new ArrayList<>();
         List<WebElement> numberOfviews = Prices;

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


    public void isItemsSortA_Z(){
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

    public void isItemsSortZ_A(){

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
