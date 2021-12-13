package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AppTest
{
    static WebDriver webDriver;

    @BeforeAll
    static void getWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://diary.ru"), "Страница недоступна");
    }

    @Test
    void test1() {
        WebElement webElement = webDriver.findElement(By.linkText("Регистрация"));
        webElement.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement).build().perform();
    }

    @Test
    void test2() {
        WebElement webElement1 = webDriver.findElement(By.id("signupform-username"));
        webElement1.click();
        webElement1.sendKeys("Applanatest1");

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement1).sendKeys(webElement1).build().perform();
    }

    @Test
    void test3() {
        WebElement webElement2 = webDriver.findElement(By.id("signupform-password"));
        webElement2.click();
        webElement2.clear();
        webElement2.sendKeys("Student2020!");

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement2).sendKeys(Keys.BACK_SPACE).sendKeys(webElement2).build().perform();
    }

    @Test
    void test4() {
        WebElement webElement3 = webDriver.findElement(By.id("signupform-email"));
        webElement3.click();
        webElement3.sendKeys("vs346751@gmail.com");

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement3).sendKeys(webElement3).build().perform();
    }

    @Test
    void test5() {
        WebElement webElement4 = webDriver.findElement(By.id("chk_box_user_confirm"));
        webElement4.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement4).build().perform();
    }

    @Test
    void test6() {
        WebElement webElement5 = webDriver.findElement(By.id("signup_btn"));
        webElement5.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement5).build().perform();
    }

    @Test
    void test7() {
        WebElement webElement6 = webDriver.findElement(By.xpath("//li[2]/a/span"));
        webElement6.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement6).build().perform();
    }

    @Test
    void test8() {
        WebElement webElement7 = webDriver.findElement(By.id("newblogform-title"));
        webElement7.click();
        webElement7.sendKeys("453353453");

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement7).sendKeys(webElement7).build().perform();
    }

    @Test
    void test9() {
        WebElement webElement8 = webDriver.findElement(By.xpath("//div[4]/label/input"));
        webElement8.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement8).build().perform();
    }

    @Test
    void test10() {
        WebElement webElement9 = webDriver.findElement(By.name("new-blogs-button"));
        webElement9.click();

        Actions actions = new Actions(webDriver);
        actions.contextClick(webElement9).build().perform();
    }

    @AfterEach
    void exit() {
        webDriver.quit();
    }
}
