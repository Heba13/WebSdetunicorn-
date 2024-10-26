package webApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BasePage {

    private final By pageHeadline = By.xpath("//h4[normalize-space()='Register']");
    private final By userNameTextBox = By.cssSelector("input[id='username']");
    private final By passwordBox = By.cssSelector("input[id='password']");
    private final By emailTextBox =By.cssSelector("input[id='email']");
    private final By genderDropDown = By.cssSelector("select[id='gender']");
    private final By firstAddressTextBox = By.cssSelector("input[id='address1']");
    private final By secondAddressTextBox =By.cssSelector("input[id='address2']");
    private final By contactTextBox = By.cssSelector("input[id='contact']");
    private final By registerButton =By.cssSelector("button[class='w-100 submit-btn my-3']");

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

    public WebElement getFirstAddressTextBox() {
        return findElement(firstAddressTextBox);
    }

    public WebElement getSecondAddressTextBox() {
        return findElement(secondAddressTextBox);
    }

    public WebElement getContactTextBox() {
        return  findElement(contactTextBox);
    }
    public void clickOnGenderDropDown(){
        findElement(genderDropDown).click();
    }
    public void selectGender(String gender){
        findElement(By.xpath("//*[@id='gender']/option[@value='"+gender+"']")).click();
    }

    public Products clickOnRegisterButton(){
        findElement(registerButton).click();
        return new Products();
    }
}
