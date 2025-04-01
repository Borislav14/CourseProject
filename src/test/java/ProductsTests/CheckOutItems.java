package ProductsTests;

import Base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutItems extends TestUtil {

    @Test
    public void TestCheckout() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.click();
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Borislav");
        driver.findElement(By.id("last-name")).sendKeys("Nedelchev");
        driver.findElement(By.id("postal-code")).sendKeys("1000");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }
}
