package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    WebDriver driver = new ChromeDriver();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Navigate to the login page URL
        driver.get("https://www.saucedemo.com");
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        // Find the username input field and enter a valid username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        
        // Find the password input field and enter a valid password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        // Assert that the homepage is displayed after successful login
        WebElement inventoryPage = driver.findElement(By.className("inventory_list"));
        assert inventoryPage.isDisplayed();
    }

    @When("the user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
        // Enter an invalid username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("invalid_user");
        
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("invalid_password");
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        // Assert that the error message is displayed for invalid credentials
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assert errorMessage.isDisplayed();
    }

    // Close the browser after the tests
    public void close_browser() {
        driver.quit();
    }
}
