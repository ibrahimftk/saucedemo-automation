/*
 * File: Login.java
 * File Created: Thursday, 19th October 2023 2:33:03 pm
 * Author: ibrahimftkurniawan (ibrahimftk@banksultra.co.id)
 * Copyright @ 2023 Ibrahim FT Kurniawan
 */

package cucumber.stepDef;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Login {
    public WebDriver driver = new ChromeDriver();
    public String url = "https://saucedemo.com/";
    
    @Given ("I am on the login page")
    public void atLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @And("There is a username and password field")
    public void There_is_a_username_and_password_field() {
        // Write code here that turns the phrase above into concrete actions
        boolean usernameAssert = driver.findElement(By.id("user-name")).isDisplayed();
        boolean passwordAssert = driver.findElement(By.id("password")).isDisplayed();

        Assert.assertTrue(usernameAssert);
        Assert.assertTrue(passwordAssert);
    }

    @When("I fill in the username field with standard_user")
    public void I_fill_in_the_username_field_with_standard_user() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("I fill in the password field with secret_sauce")
    public void I_fill_in_the_password_field_with_secret_sauce() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    
    @And("I press the log in button")
    public void I_press_the_log_in_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should be logged into the application and show the products page")
    public void I_should_be_logged_into_the_application_and_show_the_products_page() {
        // Write code here that turns the phrase above into concrete actions
        String prodTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", prodTitle);
    }

    @And("I fill in the password field with password")
    public void I_fill_in_the_password_field_with_password() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @Then("I should see an error message indicating incorrect credentials")
    public void I_should_see_an_error_message_indicating_incorrect_credentials() {
        // Write code here that turns the phrase above into concrete actions
        boolean assertError = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
        Assert.assertTrue(assertError);
    }

    @And("I fill in the username field with locked_out_user")
    public void I_fill_in_the_username_field_with_locked_out_user() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }
    
    @Then("I should see an error message indicating locked out user")
    public void I_should_see_an_error_message_indicating_locked_out_user() {
        // Write code here that turns the phrase above into concrete actions
        String message = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(message.contains("this user has been locked out"));
    }

}

