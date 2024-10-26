package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Cart extends  BasePage{
    private final By cashOnDeliveryCheckBox =By.cssSelector("input[type='checkbox']");
    private final By confirmButton =By.cssSelector("button[class='btn-hover']");
    private final By countryDropDown = By.cssSelector("select[name='rcrs-country']");
    private final By regionDropDown =By.cssSelector("select[name='rcrs-region']");
    private final By firstAddressTextBox = By.cssSelector("input[name='address1']");
    private final By phoneTextBox = By.cssSelector("input[name='contact']");
    private final By postalCodeTextBox =By.cssSelector("input[name='postalcode']");
    private final By checkOutButton = By.xpath("//a[normalize-space()='Proceed to Checkout']");
    public WebElement getSubtotalPrice(String price) {
        return findElement(By.xpath("//span[contains(text(),'$"+price+".00')]"));}
    public WebElement getTotalPrice(String total) {return findElement(By.xpath("//h4/span[contains(text(),'$"+total+".00')]"));}
    public WebElement getProductName(String name) {return findElement(By.xpath("//a[contains(text(),'"+name+"')]"));}
    public WebElement getCashOnDeliveryCheckBox() {return findElement(cashOnDeliveryCheckBox);}
    public WebElement getCountryDropDown() {return findElement(countryDropDown);}
    public WebElement getRegionDropDown() {return findElement(regionDropDown);}
    public WebElement getFirstAddressTextBox() {return findElement(firstAddressTextBox);}
    public WebElement getPhoneTextBox() {return findElement(phoneTextBox);}
    public WebElement getPostalCodeTextBox() {return findElement(postalCodeTextBox);}

    public WebElement getCheckOutButton() {
//        scrollPageToElement(findElement(checkOutButton));
        return findElement(checkOutButton);
    }


    public Order clickOnConfirmButton(){
        findElement(confirmButton).click();
        return  new Order();
    }

    public void selectCountry(String country) {
        findElement(By.xpath("//*[@name='rcrs-country']/option[@value='"+country+"']")).click();

    }

    public void selectRegion(String region) {
        findElement(By.xpath("//*[@name='rcrs-region']/option[@value='"+region+"']")).click();
    }
}
