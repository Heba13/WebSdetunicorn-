import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import webApp.WebApp;
import webApp.tests.BaseTest;
import java.io.IOException;

public class ShopStepDef extends BaseTest {
    public WebApp webApp = new WebApp();
    public ShopStepDef() throws IOException {
    }

    @When("click on profile icon in header")
    public void clickOnProfileIconInHeader() {
     webApp.header.getProfileIcon().click();
    }

    @When("click on register button in header")
    public void clickOnRegisterButtonInHeader() {
        webApp.header.clickOnRegisterButton();
    }

    @When("enter username {string} in register page")
    public void enterUsernameInRegisterPage(String userName) {
        webApp.register.getUserNameTextBox().sendKeys(userName);
    }

    @When("enter password for new user {string} in register page")
    public void enterPasswordForNewUserInRegisterPage(String password) {
        webApp.register.getPasswordBox().sendKeys(password);
    }

    @When("enter email {string} for new user in register page")
    public void enterEmailForNewUserInRegisterPage(String email) {
        webApp.register.getEmailTextBox().sendKeys(email);
    }

    @When("select gender for new user {string} in register page")
    public void selectGenderForNewUserInRegisterPage(String gender) {
        webApp.register.clickonGenderDropDown();
    }

    @When("enter first address {string} for new user in register page")
    public void enterFirstAddressForNewUserInRegisterPage(String address) {
        webApp.register.getFirstAdressTextBox().sendKeys(address);
    }

    @When("enter second address {string} for new user in register page")
    public void enterSecondAddressForNewUserInRegisterPage(String address) {
        webApp.register.getSecondAdressTextBox().sendKeys(address);
    }

    @When("enter contact {string} for new user in register page")
    public void enterContactForNewUserInRegisterPage(String contact) {
        webApp.register.getContactTextBox().sendKeys(contact);
    }

    @When("click on register button in register page")
    public void clickOnRegisterButtonInRegisterPage() {
       webApp.products= webApp.register.clickonRegisterButton();
    }

    @Then("user should be redirected to products page with title {string}")
    public void userShouldBeRedirectedToProductsPageWithTitle(String title) {
      Assert.assertEquals(webApp.products.getPageHeadline().getText(),title);
    }

    @When("click on logout button icon in header")
    public void clickOnLogoutButtonIconInHeader() {
        webApp.header.getLogoutButton().click();
    }

    @When("click on login button in header")
    public void clickOnLoginButtonInHeader() {
       webApp.login = webApp.header.clickOnLoginButton();
    }

    @When("enter email {string} in login page")
    public void enterEmailInLoginPage(String email) {
        webApp.login.getEmailTextBox().sendKeys(email);
    }

    @When("enter password for new user {string} in login page")
    public void enterPasswordForNewUserInLoginPage(String password) {
        webApp.login.getPasswordTextBox().sendKeys(password);
    }

    @When("click on login button in login page")
    public void clickOnLoginButtonInLoginPage() {
        webApp.products = webApp.login.clickOnLoginButton();
    }

    @Then("logout button should be displayed in header")
    public void logoutButtonShouldBeDisplayedInHeader() {
        Assert.assertTrue(webApp.header.getLogoutButton().isDisplayed());
    }

    @When("click on products tab in header")
    public void clickOnProductsTabInHeader() {
        webApp.products=webApp.header.clickOnProductTab();
    }

    @Then("user should be redirected to {string} page")
    public void userShouldBeRedirectedToPage(String title) {
        Assert.assertEquals(webApp.header.getHeadline().getText(),title);
    }

    @When("click on product type {string} on check list in products page")
    public void clickOnProductTypeOnCheckListInProductsPage(String product) {
        webApp.products.getProductName(product).click();
    }

    @When("click on apply button in products page")
    public void clickOnApplyButtonInProductsPage() {
        webApp.products.getApplyButton().click();
    }

    @Then("{string} product should be displayed in products page")
    public void productShouldBeDisplayedInProductsPage(String name) {
        Assert.assertTrue(webApp.products.getProductName(name).isDisplayed());
    }

    @Then("laptop product should be disappeared from products page")
    public void laptopProductShouldBeDisappearedFromProductsPage() {
        Assert.assertFalse(webApp.products.getProductName("laptop").isDisplayed());
    }

    @When("click on product {string} in products page")
    public void clickOnProductInProductsPage(String name) {
        webApp.products.getProductName(name).click();
    }

    @Then("product name {string} and price {string} should be displayed in products page")
    public void productNameAndPriceShouldBeDisplayedInProductsPage(String name, String price) {
    }

    @Then("cart count should be zero in header")
    public void cartCountShouldBeZeroInHeader() {
       Assert.assertEquals (webApp.header.getCartCount().getText(),0);
    }

    @Then("cart count should be one in header")
    public void cartCountShouldBeOneInHeader() {
       Assert.assertEquals (webApp.header.getCartCount().getText(),1);
    }

    @Then("message should be displayed {string} in products page")
    public void messageShouldBeDisplayedInProductsPage(String message) {
        Assert.assertEquals(webApp.products.getMessages().getText(),message);
    }

    @When("click on add to cart in products page")
    public void clickOnAddToCartInProductsPage() {
        webApp.products.getAddToCartButton().click();
    }

    @Then("cart count should be two in header")
    public void cartCountShouldBeTwoInHeader() {
      Assert.assertEquals(webApp.header.getCartCount().getText(),2);
    }

    @When("click on cart button in header")
    public void clickOnCartButtonInHeader() {
        webApp.header.getCartIcon().click();
    }

    @When("click on view button in header")
    public void clickOnViewButtonInHeader() {
       webApp.cart= webApp.header.clickOnViewCartButton();
    }

    @Then("product name {string} and price {string} should be displayed in cart page")
    public void productNameAndPriceShouldBeDisplayedInCartPage(String name, String price) {
         Assert.assertTrue(webApp.cart.getProductName().getText().equals(name) && (webApp.cart.getSubtotalPrice().getText().equals(price)));
    }

    @Then("total price should be displayed in cart page")
    public void totalPriceShouldBeDisplayedInCartPage() {
        Assert.assertTrue(webApp.cart.getTotalPrice().getText().equals(5));
    }

    @When("click on checkout button in cart page")
    public void clickOnCheckoutButtonInCartPage() {
        webApp.cart.getCheckOutButton().click();
    }

    @When("enter the shipping address {string} in cart page")
    public void enterTheShippingAddressInCartPage(String address) {
        webApp.cart.getFirstAddressTextBox().sendKeys(address);
    }

    @When("select country {string} in cart page")
    public void selectCountryInCartPage(String country) {
        webApp.cart.getCountryDropDown().click();
    }

    @When("select region {string} in cart page")
    public void selectRegionInCartPage(String region) {
        webApp.cart.getRegionDropDown().click();
    }

    @When("enter phone number {string} and postal code {string} in cart page")
    public void enterPhoneNumberAndPostalCodeInCartPage(String phoneNumber, String code) {
        webApp.cart.getPhoneTextBox().sendKeys(phoneNumber);
        webApp.cart.getPostalCodeTextBox().sendKeys(code);
    }

    @When("click on cash on delivery check box in cart page")
    public void clickOnCashOnDeliveryCheckBoxInCartPage() {
        webApp.cart.getCashOnDeliveryCheckBox().click();
    }

    @When("click on confirm button in cart page")
    public void clickOnConfirmButtonInCartPage() {
        webApp.order= webApp.cart.clickOnConfirmButton();
    }

    @When("click on order in order page")
    public void clickOnOrderInOrderPage() {
        webApp.order.getOrderButton().click();
    }

    @Then("shipping address {string} and total price should be displayed correctly in order page")
    public void shippingAddressAndTotalPriceShouldBeDisplayedCorrectlyInOrderPage(String address) {
        webApp.order.getFirstAddress().getText().equals(address);
        webApp.order.getTotalPrice().equals(5);
    }
}
