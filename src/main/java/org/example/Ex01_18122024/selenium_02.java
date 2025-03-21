package org.example.Ex01_18122024;

// Login to vwo.com and give invalid userid  or password to validate the error message

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class selenium_02 {

    @Test
    public void testProject1() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.id("login-username")).sendKeys("Admin");
        driver.findElement(By.id("login-password")).sendKeys("admin123");
        driver.findElement(By.id("js-login-btn")).click();

        WebElement errmsg = driver.findElement(By.className("notification-box-description"));

        Thread.sleep(3000);

        Assert.assertEquals(errmsg.getText(),"Your email, password, IP address or location did not match");

        Thread.sleep(3000);

        //assertThat(errmsg.getText()).isEqualTo("Your email, password, IP address or location did not match");

        driver.quit();
    }
}
