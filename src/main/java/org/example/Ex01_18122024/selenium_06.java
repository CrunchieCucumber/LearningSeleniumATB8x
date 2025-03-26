package org.example.Ex01_18122024;

//Project for flipkart.com using SVGs

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.io.*;

public class selenium_06 {

    @Test
    public void testProject5() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://flipkart.com");

        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("eyeliner");
        List<WebElement> svgSearch = driver.findElements(By.xpath("//*[name() = 'svg']"));
        svgSearch.get(0).click();

        Thread.sleep(15000);

        WebElement message = driver.findElement(By.xpath("//span[@class=\"BUOuZu\"]"));
        Assert.assertEquals(message.getText(),"Showing 1 – 40 of 15,323 results for \"eyeliner\"");

        driver.close();
        driver.quit();
    }
}
