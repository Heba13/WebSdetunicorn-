package webApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Products extends BasePage {

    private final By pageHeadline = By.name("password");
    private final By categoryCheckList = By.name("password");
    private final By applyButton = By.xpath("//button[@type='submit']");
    private final By productName = By.name("password");
    private final By productPrice = By.name("password");
    private final By addToCartButton = By.name("password");
    private final By  messages = By.xpath("//button[@type='submit']");


    public WebElement getPageHeadline() {
        return findElement(pageHeadline);
    }
    public WebElement getCategoryCheckList() {
        return findElement(categoryCheckList);
    }
    public WebElement getProductName(String name) {
        return findElement(By.xpath(""+ name+""));
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
        return findElement(applyButton);
    }




}
