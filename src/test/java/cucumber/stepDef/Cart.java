/*
 * File: addCart.java
 * File Created: Friday, 20th October 2023 8:18:09 am
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

public class Cart {
    public WebDriver driver = new ChromeDriver();
    public String url = "https://saucedemo.com/"; 

    @Given("I have logged in to application and i am on products page")
    public void I_have_logged_in_to_application_and_i_am_on_products_page() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String prodTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", prodTitle);
    }

    @When("I click Add to cart button")
    public void I_click_Add_to_cart_button() { 
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("The product should be added to the shopping cart")
    public void The_product_should_be_added_to_the_shopping_cart() {
        int productCount = Integer.parseInt(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText());
        Assert.assertNotEquals(0, productCount);;
    }

    @And("There is a product already added to my shopping cart")
    public void There_is_a_product_already_added_to_my_shopping_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        int productCount = Integer.parseInt(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText());
        Assert.assertNotEquals(0, productCount);;
    }

    @When("I click remove button for that product")
    public void I_click_remove_button_for_that_product() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("That product should be removed from the shopping cart")
    public void That_product_should_be_removed_from_the_shopping_cart() {
        int productCount = driver.findElements(By.cssSelector(".shopping_cart_badge")).size();
        Assert.assertEquals(0, productCount);
    }

}

