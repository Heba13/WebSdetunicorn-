package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Order extends BasePage {
    private final By pageHeadline = By.name("password");
    private final By orderButton= By.name("username");
    private final By firstAddress = By.name("username");
    private final By totalPrice = By.name("username");

    public WebElement getPageHeadline() {return findElement(pageHeadline);}
    public WebElement getOrderButton() {return findElement(orderButton);}
    public WebElement getFirstAddress () {return findElement(firstAddress);}
    public WebElement getTotalPrice() {return findElement(totalPrice);}
}
