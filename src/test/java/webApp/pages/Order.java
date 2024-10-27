package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Order extends BasePage {
    private final By orderButton= By.cssSelector("button[variant='link']");
    public WebElement getOrderButton() {
        waitUntilElementIsVisible();
        return findElement(orderButton);}
    public WebElement getFirstAddress (String address) {return findElement(By.xpath("//h4[normalize-space()='Address 1 : "+address+"']"));}
    public WebElement getTotalPrice(String total) {return findElement(By.xpath("//h4[normalize-space()='Total : $"+total+"']"));}
}
