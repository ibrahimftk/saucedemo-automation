/*
 * File: checkOut.java
 * File Created: Friday, 20th October 2023 8:20:40 am
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

public class checkOut {
    public WebDriver driver = new ChromeDriver();
    public String url = "https://saucedemo.com/";

    @Given("I already add products to my shopping cart")
    public void I_already_add_products_to_my_shopping_cart() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String prodTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", prodTitle);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

    }

    @And("I am on my cart page")
    public void I_am_on_my_cart_page() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @When("I click Checkout button")
    public void I_click_Checkout_button() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Your Cart", title);
        driver.findElement(By.id("checkout")).click();
    }

    @And("Application shows Information Checkout page")
    public void Application_shows_Information_Checkout_page() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        boolean firstName = driver.findElement(By.id("first-name")).isDisplayed();
        boolean lastName = driver.findElement(By.id("last-name")).isDisplayed();
        boolean postalCode = driver.findElement(By.id("postal-code")).isDisplayed();
        Assert.assertEquals("Checkout: Your Information", title);
        Assert.assertTrue(firstName);
        Assert.assertTrue(lastName);
        Assert.assertTrue(postalCode);
    }

    @And("I input first name field")
    public void I_input_first_name_field() {
        driver.findElement(By.id("first-name")).sendKeys("Ibrahim");
    }

    @And("I input last name field")
    public void I_input_last_name_field() {
        driver.findElement(By.id("last-name")).sendKeys("Fantri");
    }

    @And("I input postal code field")
    public void I_input_postal_code_field() {
        driver.findElement(By.id("postal-code")).sendKeys("93231");
    }

    @And("I click Continue button")
    public void I_click_Continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @And("Application shows Checkout Overview page")
    public void Application_shows_Checkout_Overview_page() { 
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Checkout: Overview", title);
        
    }

    @And("I click Finish button")
    public void I_click_Finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Success message checkout was appeared")
    public void Success_message_checkout_was_appeared() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        String message = driver.findElement(By.cssSelector(".complete-text")).getText();
        boolean logo = driver.findElement(By.cssSelector("img[alt='Pony Express']")).isDisplayed();

        Assert.assertEquals("Checkout: Complete!", title);
        Assert.assertTrue(message.contains("Your order has been dispatched"));
        Assert.assertTrue(logo);
    }

    @And("I left first name last name and postal code field blank")
    public void I_left_first_name_last_name_and_postal_code_field_blank() {
        
    }

    @Then("Error message checkout was appeared")
    public void Error_message_checkout_was_appeared() {
        String message = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        boolean error = driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();

        Assert.assertTrue(message.contains("Error"));
        Assert.assertTrue(error);
    }
}

