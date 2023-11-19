package com.ait.qa29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    //precondition:user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector(".ico-logout")).click();
        }
    }

    @Test
    public void existeUserRegistrationPositiveTest() {


        //click on login link
        driver.findElement(By.cssSelector("[href='/register']")).click();

        //click on Male radioTypeButton (#gender-male)
        driver.findElement(By.cssSelector("#gender-male")).click();
        //enter First Name (#FirstName)
        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("Serhii");
        //enter Last Name (#LastName)
        driver.findElement(By.cssSelector("#LastName")).click();
        driver.findElement(By.cssSelector("#LastName")).clear();
        driver.findElement(By.cssSelector("#LastName")).sendKeys("Poryvaiev");

        //enter emeil (#Email)
        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("sergijko198777777@ukr.net");
        //enter password (#Password)
        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("$Sergijko323");

        //confirm password
        driver.findElement(By.cssSelector("#ConfirmPassword")).click();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("$Sergijko323");


        //click on registration button
        driver.findElement(By.cssSelector("#register-button")).click();

        //assert Sign Out button is present
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }


    }


