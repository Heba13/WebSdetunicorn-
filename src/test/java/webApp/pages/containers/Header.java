package webApp.pages.containers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webApp.pages.*;

public class Header extends BasePage {
    private final By profileIcon = By.cssSelector(".account-setting-active");
    private final By registerButton = By.cssSelector("a[href='/register']");
    private final By loginButton = By.cssSelector("a[href='/login']");
    private final By logoutButton =By.xpath("//div[@class='account-dropdown active']//li[contains(text(),'Logout')]");
    private final By cartIcon = By.cssSelector(".icon-cart");
    private final By cartCount = By.cssSelector("span[class='count-style']");
    private final By productTab =  By.cssSelector("a[href='/shop-grid-standard']");

    private final By orderIcon =  By.cssSelector("a[href='/order']");

    private final By viewCartButton = By.xpath("//a[@href='/cart']");

    public WebElement getProfileIcon() {
        return findElement(profileIcon);
    }

    public WebElement getCartCount() {
        return findElement(cartCount);
    }

    public WebElement getLogoutButton() {
        return findElement(logoutButton);
    }

    public WebElement getCartIcon() {
        return findElement(cartIcon);
    }

    public Register clickOnRegisterButton() {
        findElement(registerButton).click();
        return new Register();
    }
    public Products clickOnProductTab() {
        findElement(productTab).click();
        return new Products();
    }
    public Cart clickOnViewCartButton() {
        findElement(viewCartButton).click();
        return new Cart();
    }
    public Login clickOnLoginButton() {
        findElement(loginButton).click();
        return new Login();
    }

    public Order clickOnOrderIcon() {
        findElement(orderIcon).click();
        return new Order();
    }
}