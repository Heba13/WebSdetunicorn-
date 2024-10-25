package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Cart extends  BasePage{
    private final By totalPrice = By.xpath("//button[@type='submit']");
    private final By productName = By.xpath("//button[@type='submit']");
    private final By cashOnDeliveryCheckBox = By.xpath("//button[@type='submit']");
    private final By confirmButton = By.xpath("//button[@type='submit']");
    private final By countryDropDown = By.xpath("//button[@type='submit']");
    private final By regionDropDown = By.xpath("//button[@type='submit']");
    private final By firstAddressTextBox = By.name("username");
    private final By phoneTextBox = By.name("username");
    private final By postalCodeTextBox = By.name("username");
    private final By checkOutButton = By.name("username");

    public WebElement getSubtotalPrice() {
        return findElement(By.xpath("//button[@type='submit']"));}
    public WebElement getTotalPrice() {return findElement(totalPrice);}
    public WebElement getProductName() {return findElement(productName);}
    public WebElement getCashOnDeliveryCheckBox() {return findElement(cashOnDeliveryCheckBox);}
    public WebElement getCountryDropDown() {return findElement(countryDropDown);}
    public WebElement getRegionDropDown() {return findElement(regionDropDown);}
    public WebElement getFirstAddressTextBox() {return findElement(firstAddressTextBox);}
    public WebElement getPhoneTextBox() {return findElement(phoneTextBox);}
    public WebElement getPostalCodeTextBox() {return findElement(postalCodeTextBox);}

    public WebElement getCheckOutButton() {
        return findElement(checkOutButton);
    }

    public Order clickOnConfirmButton(){
        findElement(confirmButton).click();
        return  new Order();
    }
}
