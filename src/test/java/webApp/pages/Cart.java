package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Cart extends  BasePage{
    private final By subtotalPrice = By.xpath("//button[@type='submit']");
    private final By totalPrice = By.xpath("//button[@type='submit']");
    private final By productName = By.xpath("//button[@type='submit']");
    private final By cashOnDeliveryCheckBox = By.xpath("//button[@type='submit']");
    private final By confirmButton = By.xpath("//button[@type='submit']");
    private final By countryDropDown = By.xpath("//button[@type='submit']");
    private final By regionDropDown = By.xpath("//button[@type='submit']");
    private final By firstAddressTextBox = By.name("username");
    private final By phoneTextBox = By.name("username");
    private final By postalCodeTextBox = By.name("username");

    public WebElement getSubtotalPrice() {return findElement(subtotalPrice);}
    public WebElement getTotalPrice() {return findElement(totalPrice);}
    public WebElement getproductName() {return findElement(productName);}
    public WebElement getCashOnDeliveryCheckBox() {return findElement(cashOnDeliveryCheckBox);}
    public WebElement getcountryDropDown() {return findElement(countryDropDown);}
    public WebElement getregionDropDown() {return findElement(regionDropDown);}
    public WebElement getFirstAddressTextBox() {return findElement(firstAddressTextBox);}
    public WebElement getPhoneTextBox() {return findElement(phoneTextBox);}
    public WebElement getPostalCodeTextBox() {return findElement(postalCodeTextBox);}

    public Order clickonConfirmButton(){
        findElement(confirmButton).click();
        return  new Order();
    }
}
