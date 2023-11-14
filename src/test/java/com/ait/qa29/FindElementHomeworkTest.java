package com.ait.qa29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementHomeworkTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        // driver.get(https://telranedu.web.app);//without history
        driver.navigate().to("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();;

        //wait for all element on the page to load before start test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void findElementByCssSelectorsTest(){
       driver.findElement(By.cssSelector(".master-wrapper-content"));

        driver.findElement(By.cssSelector("[class='header']"));

        driver.findElement(By.cssSelector("#bar-notification"));

         driver.findElement(By.cssSelector("head"));


         driver.findElement(By.cssSelector("[name*='scripti']"));

        driver.findElement(By.cssSelector("[name^='des']"));

        driver.findElement(By.cssSelector("[name$='cription']"));

        driver.findElement(By.cssSelector(".close"));

        driver.findElement(By.cssSelector("[class='bar-notification']"));

        driver.findElement(By.cssSelector("#dialog-notifications-success"));


    }

    @Test
    public void findElementByXpathTest(){
        driver.findElement(By.xpath("//*[@class='master-wrapper-content']"));

        driver.findElement(By.xpath("//*[@class='header']"));

        driver.findElement(By.xpath("//*[@id='bar-notification']"));

        driver.findElement(By.xpath("//head"));


        driver.findElement(By.xpath("//title[contains(.,'Demo')]"));

        driver.findElement(By.xpath("//title[contains(.,'o W')]"));

        driver.findElement(By.xpath("//title[contains(.,'Shop')]"));

        driver.findElement(By.xpath("//*[@class='close']"));

        driver.findElement(By.xpath("//*[@class='bar-notification']"));

        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));


    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();//all tabs and close browser
        driver.close();
    }
}
