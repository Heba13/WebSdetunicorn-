package webApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Products extends BasePage {
    private final By pageHeadline = By.cssSelector("span[to='/shop-grid-standard']");
    private final By applyButton = By.cssSelector("button[type='button']");
    private final By productPrice = By.cssSelector("div[class='product-details-price'] span");
    private final By addToCartButton = By.cssSelector("div[class='pro-details-cart btn-hover'] button");
    private final By  messages = By.cssSelector("div[class='react-toast-notifications__toast__content css-1ad3zal']");
    public WebElement getPageHeadline() {
        BasePage.waitUntilElementIsVisible();
        return findElement(pageHeadline);
    }
    public WebElement getCategoryCheckList(String category) {
        return findElement(By.xpath("//button[normalize-space()='"+category+"']"));
    }
    public WebElement getProductModel(String name) {
        return findElement(By.xpath("//a[contains(text(),'" + name + "')]"));
    }
    public WebElement getProductName(String name) {
        return  findElement(By.xpath("//h2[contains(text(),'" + name + "')]"));
    }
    public WebElement getMessages() {
        return findElement(messages);
    }
    public WebElement getProductPrice() {
        return findElement(productPrice);
    }
    public WebElement getAddToCartButton() {
        return findElement(addToCartButton);
    }

    public WebElement getApplyButton() {
        scrollPageToElement(findElement(applyButton));
        return findElement(applyButton);
    }

}
