package webApp.pages;

import org.openqa.selenium.By;


public class Home extends BasePage {
    private final By shopNowButton = By.name("");
    public Products clickOnShopNowButton(){
        findElement(shopNowButton ).click();
        return new Products();
    }
}
