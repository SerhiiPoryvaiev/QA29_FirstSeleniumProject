package com.ait.qa29;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            driver.findElement(By.cssSelector(".ico-logout")).click();
        }
    }
    @Test
    public void isLoginPositive(){
        driver.findElement(By.cssSelector("[href='/login']")).click();

        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("sergijko198777777@ukr.net");

        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("$Sergijko323");
        driver.findElement(By.cssSelector("[class='button-1 login-button']")).click();

        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }
}
