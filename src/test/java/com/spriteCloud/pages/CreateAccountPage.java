package com.spriteCloud.pages;

import com.spriteCloud.utilities.BrowserUtils;
import com.spriteCloud.utilities.ConfigurationReader;
import com.spriteCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    public WebElement authentication;

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    public WebElement emailBtn;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
    public WebElement accountPage;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    public WebElement invaPop;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    public WebElement firstname;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    public WebElement lastname;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    public WebElement address;

    @FindBy(xpath = "//*[@id=\"city\"]")
    public WebElement city;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    public WebElement postcode;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    public WebElement phone;

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    public WebElement state;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    public WebElement register;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    public WebElement myAccountPage;

    public void goToHomepage() {

        Driver.get().get(ConfigurationReader.get("url"));
    }




}



