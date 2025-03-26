package org.example.Ex01_18122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class selenium_04 {

    @Test
    public void testProject3(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ebay.com");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("ipadmini");
        driver.findElement(By.xpath("//span[@class = 'gh-search-button__label']")).click();

        List<WebElement> itemName = driver.findElements(By.xpath("//span[@role = 'heading']"));
        List<WebElement> itemPrice = driver.findElements(By.xpath("//span[@class = 's-item__price']"));

        int size = Math.min(itemPrice.size(),itemName.size());
        int count=0;

        for(int i=0;i<size;i++) {
            System.out.println("Name : " + itemName.get(i).getText() + "||" + "Price : " + itemPrice.get(i).getText());
            count++;
        }
        System.out.println("Total items displayed are " +count);
        driver.close();
        driver.quit();
    }
}
