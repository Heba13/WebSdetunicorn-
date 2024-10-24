package webApp.pages;

import org.openqa.selenium.By;

public class Home extends BasePage {

    private final By PasswordTextBox = By.name("password");
    private final By UserNameTextBox = By.name("username");
    private final By LoginButton = By.xpath("//button[@type='submit']");
}
