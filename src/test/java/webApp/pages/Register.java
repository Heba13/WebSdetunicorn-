package webApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BasePage {

    private final By pageHeadline = By.name("password");
    private final By userNameTextBox = By.name("username");
    private final By passwordBox = By.name("username");
    private final By emailTextBox = By.name("username");
    private final By genderDropDown = By.name("username");
    private final By firstAddressTextBox = By.name("username");
    private final By secondAddressTextBox = By.name("username");
    private final By contactTextBox = By.name("username");
    private final By registerButton = By.name("username");

    public WebElement getPageHeadline() {
        return findElement(pageHeadline);
    }

    public WebElement getUserNameTextBox() {
        return findElement(userNameTextBox);
    }

    public WebElement getEmailTextBox() {
        return findElement(emailTextBox);
    }

    public WebElement getPasswordBox() {
        return findElement(passwordBox);
    }

    public WebElement getFirstAdressTextBox() {
        return findElement(firstAddressTextBox);
    }

    public WebElement getSecondAdressTextBox() {
        return findElement(secondAddressTextBox);
    }

    public WebElement getContactTextBox() {
        return  findElement(contactTextBox);
    }
    public void clickonGenderDropDown(){
        findElement(genderDropDown).click();
    }
    public Register clickonRegisterButton(){
        findElement(registerButton).click();
        return  new Register();
    }
}
