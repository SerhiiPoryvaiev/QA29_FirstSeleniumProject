package com.ait.qa29;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTests extends TestBase {
    @BeforeMethod
    public void shoppingCartPrecondition() {
        if (!isElementPresent(By.xpath("//span[@class='cart-qty' and text()='(0)']"))) {
            driver.findElement(By.cssSelector("[name='removefromcart']")).click();
            driver.findElement(By.cssSelector("[class='button-2 update-cart-button']"));
        }
    }

    @Test
    public void addProductTest() {
        driver.findElement(By.xpath("//input[contains(@onclick, '/addproducttocart/catalog/2/1/1')]")).click();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).click();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).sendKeys("Serhii");

        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).click();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).sendKeys("sergijko198777777@ukr.net");

        driver.findElement(By.cssSelector("#giftcard_2_SenderName")).click();
        driver.findElement(By.cssSelector("#giftcard_2_SenderName")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_SenderName")).sendKeys("Serhii");

        driver.findElement(By.cssSelector("#giftcard_2_SenderEmail")).click();
        driver.findElement(By.cssSelector("#giftcard_2_SenderEmail")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_SenderEmail")).sendKeys("sergijko198777777@ukr.net");

        driver.findElement(By.cssSelector("#add-to-cart-button-2")).click();

        driver.findElement(By.cssSelector("#topcartlink")).click();


        driver.findElement(By.cssSelector("[href='/cart']")).click();

        Assert.assertTrue(isElementPresent(By.cssSelector("[value='1']")));


    }
}
