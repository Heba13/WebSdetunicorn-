package webApp.pages.containers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webApp.pages.*;

public class Header extends BasePage {
    private final By profileIcon = By.cssSelector(".account-setting-active");
    private final By headline = By.name("");
    private final By registerButton = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    private final By logoutButton = By.xpath("//button[@type='submit']");
    private final By cartIcon = By.xpath("//button[@type='submit']");
    private final By cartCount = By.xpath("//button[@type='submit']");
    private final By productTab = By.xpath("//button[@type='submit']");
    private final By viewCartButton = By.xpath("//button[@type='submit']");



    public WebElement getProfileIcon() {
        return findElement(profileIcon);
    }

    public WebElement getHeadline() {
        return findElement(headline);
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

    public WebElement getLoginButton() {
        return findElement(loginButton);
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

}