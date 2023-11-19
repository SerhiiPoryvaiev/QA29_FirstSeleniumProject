package com.ait.qa29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        // driver.get(https://demowebshop.tricentis.com/);//without history
        driver.navigate().to("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();;

        //wait for all element on the page to load before start test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();//all tabs and close browser
        driver.quit();
    }
}
