package com.ait.qa29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        // driver.get(https://telranedu.web.app);//without history
        driver.navigate().to("https://telranedu.web.app/login");

        driver.manage().window().maximize();;

        //wait for all element on the page to load before start test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void findElementByTagNameTest(){
//find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find list of element by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        System.out.println("*********************************");
    }
    @Test
    public void findElementByTest(){
        //id
        WebElement element = driver.findElement(By.id("root"));
        System.out.println(element.getText());
        System.out.println("*********************************");
//className
        WebElement element1 = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(element1.getText());
        System.out.println("*********************************");
//name
        WebElement element2 = driver.findElement(By.name("email"));
        System.out.println(element2.getAttribute("name"));
        System.out.println("*********************************");
      //linkText
        driver.findElement(By.linkText("HOME"));
        //partialLinkText
        driver.findElement(By.partialLinkText("OUT"));
    }

    @Test
    public void findElementByCssSelectorTest(){
        //tagName-->tagName
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id-->#id
        //driver.findElement(By.id("root"));
        driver.findElement(By.cssSelector("#root"));

        //className--> .className
        //driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.cssSelector(".login_login__3EHKB"));

        //[attribute='value']
        driver.findElement(By.cssSelector("[name='email']"));
        driver.findElement(By.cssSelector("[placeholder='Email']"));

        //contains-->*
        driver.findElement(By.cssSelector("[placeholder*='mai']"));
        //start-->^
        driver.findElement(By.cssSelector("[placeholder^='Ema']"));
        //end on-->$
        driver.findElement(By.cssSelector("[placeholder$='ail']"));
    }
    @Test
    public void findElementByXpathTest(){
        //tagName-->//tagName
        //  driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //className--> .className
        //driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.xpath("//*[@class='login_login__3EHKB']"));

        //id-->#id
        //driver.findElement(By.id("root"));
        driver.findElement(By.xpath("//*[@id='root']"));

        //contains, end on, start -->//*[contains(.,'Text')]
        driver.findElement(By.xpath("//button[contains(.,'Registration')]"));
    }
    @Test
    public void inPutLoginTest(){
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test");
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        //driver.quit();//all tabs and close browser
        driver.close();
    }
}
