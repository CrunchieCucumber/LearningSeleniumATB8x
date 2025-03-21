package org.example.Ex01_18122024;

// href="https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class selenium_03 {

    @Test
    public void testProject2() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.linkText("Start a free trial")).click();

        Thread.sleep(3000);

        driver.findElement(By.id("page-v1-step1-email")).sendKeys("a@gmail.com");
        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        List<WebElement> submitbutton =  driver.findElements(By.tagName("button"));
        submitbutton.get(0).click();

        Assert.assertEquals(driver.findElement(By.className("C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason")).getText(),"The email address you entered is incorrect.");


        driver.quit();
    }
}
