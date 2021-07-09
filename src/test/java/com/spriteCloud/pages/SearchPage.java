package com.spriteCloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
