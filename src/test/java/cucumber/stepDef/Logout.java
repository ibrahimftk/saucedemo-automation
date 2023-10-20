/*
 * File: Logout.java
 * File Created: Friday, 20th October 2023 8:40:41 am
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

public class Logout {
    public WebDriver driver = new ChromeDriver();
    public String url = "https://saucedemo.com/"; 

    @Given("I have logged in to application")
    public void I_have_logged_in_to_application() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean cartExist = driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed();
        Assert.assertTrue(cartExist);

    }

    @When("I click side menu")
    public void I_click_side_menu(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("I click Logout from side menu")
    public void I_click_Logout_from_side_menu() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("I should be logged out from application and redirected to login page")
    public void I_should_be_logged_out_from_application_and_redirected_to_login_page() {
        boolean usernameAssert = driver.findElement(By.id("user-name")).isDisplayed();
        boolean passwordAssert = driver.findElement(By.id("password")).isDisplayed();

        Assert.assertTrue(usernameAssert);
        Assert.assertTrue(passwordAssert);
    }
}

