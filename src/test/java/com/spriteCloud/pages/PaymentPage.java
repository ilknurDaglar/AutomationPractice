package com.spriteCloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

  @FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
  public WebElement proceedCheckoutBtn;
  @FindBy(xpath ="//*[@id=\"center_column\"]/h1" )
  public WebElement authentitaionPageTitle;

  @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
  public WebElement addressPageTitle;

  @FindBy(xpath = "//*[@id=\"carrier_area\"]/h1")
  public WebElement shippingPageTitle;

  @FindBy(css = "#cgv")
  public WebElement shippingCheckBox;

  @FindBy(xpath = "//*[@id=\"order\"]/div[2]/div/div/a")
  public WebElement popUp;

  @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
  public WebElement paymentPageTitle;
}
