package com.spriteCloud.pages;

import com.spriteCloud.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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


  public void  isAddressDisplay(){

      CreateAccountPage createAccountPage=new CreateAccountPage();

    if (authentitaionPageTitle.getText().equals("AUTHENTICATION")) {
      createAccountPage.emailBtn.sendKeys("urannatum@gmail.com");
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

      BrowserUtils.clickWithJS(proceedCheckoutBtn);
    } else {
      Assert.assertEquals(addressPageTitle.getText(), "ADDRESSES");

    }




  }
}
