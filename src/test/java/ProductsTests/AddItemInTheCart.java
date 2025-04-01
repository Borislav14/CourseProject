package ProductsTests;

import Base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemInTheCart extends TestUtil {
    private final static String BASE_PRODUCT_ID = "add-to-card-sauce-labs-";

    @Test(dataProvider = "shoppingItems")
    public void addProductsToCart(String item) {
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

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + item));
        itemToBeAdded.click();

        WebElement SecondItemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + item));
        SecondItemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_Badge"));

        Assert.assertEquals(shoppingCartBadge.getText(), "2");
    }

    @DataProvider(name = "shoppingItems")
    public Object[] getShoppingCartItems() {
        return new Object[]{
                "bike-light",
                "backpack",
                "fleece-jacket"
        };
    }
}