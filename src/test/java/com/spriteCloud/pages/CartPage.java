package com.spriteCloud.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    public WebElement womenPage;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement item1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]")
    public WebElement chartPop;

    @FindBy(xpath = "//span[.='Add to cart']")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]")
    public WebElement continueOrproceedPop;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    public WebElement item2;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    public WebElement yourCartPage;

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    public List<WebElement> quantityCheck;

    @FindBy(xpath = "//div[3]/div/div[2]/table/tbody/tr[1]/td[4]/span/span")
    public WebElement priceInChart1;

    @FindBy(xpath = "//div[3]/div/div[2]/table/tbody/tr[2]/td[4]/span/span")
    public WebElement priceInChart2;

    @FindBy(xpath = "//*[@id=\"total_shipping\"]")
    public WebElement shippingPrice;

    @FindBy(xpath = "//*[@id=\"total_price\"]")
    public WebElement totalPrice;

    public void isInTheBasket() {
        List<WebElement> qCheck = quantityCheck;
        for (WebElement each : qCheck) {
            String value = each.getAttribute("value");
            int i = Integer.parseInt(value);
            Assert.assertEquals(1, i);

        }
    }
      public  void isPriceCorrect(){
            int priceatChart1 = Integer.parseInt(priceInChart1.getText().replace("$", "").replace(",", "").replace(".", ""));
            int priceatChart2 = Integer.parseInt(priceInChart2.getText().replace("$", "").replace(",", "").replace(".", ""));
            int shipping = Integer.parseInt(shippingPrice.getText().replace("$", "").replace(",", "").replace(".", ""));
            int sum = priceatChart1 + priceatChart2 + shipping;
            System.out.println(sum);
            int TotalPrice = Integer.parseInt(totalPrice.getText().replace("$", "").replace(",", "").replace(".", ""));

            Assert.assertEquals(sum, TotalPrice);


    }



}
