package webApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {
    private final By PasswordTextBox =  By.cssSelector("input[id='password']");
    private final By emailTextBox = By.cssSelector("input[name='email']");
    private final By LoginButton = By.cssSelector("button[class='w-100 my-3 submit-btn']");

    public WebElement getEmailTextBox() {
        return findElement(emailTextBox);
    }

    public WebElement getPasswordTextBox() {
        return findElement(PasswordTextBox);
    }

    public Products clickOnLoginButton(){
        findElement(LoginButton).click();
        return new Products();
    }
}
