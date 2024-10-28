package webApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Order extends BasePage {
    private final By orderButton= By.cssSelector("button[variant='link']");
    private final By firstOrderId= By.xpath("//h3[@class='panel-title'][1]");

    public WebElement getOrderButton() {
        waitUntilElementIsVisible();
        return findElement(orderButton);}
    public WebElement getFirstAddress (String address) {return findElement(By.xpath("//h4[normalize-space()='Address 1 : "+address+"']"));}
    public WebElement getTotalPrice(String total) {return findElement(By.xpath("//h4[normalize-space()='Total : $"+total+"']"));}

    public String getFirstOrderId() {
        return findElement(firstOrderId).getText().substring(11).toLowerCase(); }

}

