
package com.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class WelcomeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        // Load HTML using the project resource path
        File htmlFile = new File(
            "src/test/resources/welcome.html"
        );

        System.out.println("HTML file path: " +
            htmlFile.getAbsolutePath());

        System.out.println("HTML file exists: " +
            htmlFile.exists());

        Assert.assertTrue(
            htmlFile.exists(),
            "Please check src/test/resources/welcome.html"
        );

        driver.get(htmlFile.toURI().toString());
    }

    @Test
    public void welcomeTest() {

        String message = driver.findElement(By.id("welcome"))
                .getText();

        System.out.println("Welcome Message: " + message);

        Assert.assertEquals(
            message.trim(),
            "Welcome to Selenium Automation!"
        );
    }

    @Test
    public void testCaseName() {

        String testcase = driver.findElement(By.id("testcase"))
                .getText();

        System.out.println("Test Case: " + testcase);

        Assert.assertEquals(
            testcase.trim(),
            "Test Case: TC001"
        );
    }

    @Test
    public void statusTest() {

        String status = driver.findElement(By.id("status"))
                .getText();

        System.out.println("Status: " + status);

        Assert.assertEquals(
            status.trim(),
            "Status: Passed"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
