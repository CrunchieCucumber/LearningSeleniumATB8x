package org.example.Ex01_18122024;

//Learning xpath axes

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class selenium_05 {

    @Test
    public void testProject4(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://cdpn.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&view=fullpage");

        driver.switchTo().frame("result");

        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        //driver.findElement(By.xpath("//input[@id = 'username']"));
        //WebElement label = driver.findElement(By.xpath("//input[@id = 'username']/preceding-sibling::label"));
        //WebElement error = driver.findElement(By.xpath("//input[@id = 'username']/following-sibling::small"));

        List<WebElement> fields = driver.findElements(By.xpath("//input"));
        List<WebElement> label = driver.findElements(By.xpath("//input/preceding-sibling::label"));
        List<WebElement> error = driver.findElements(By.xpath("//input/following-sibling::small"));

        for(int i=0;i<fields.size();i++)
            System.out.println("Field " +i+ " has label " +label.get(i).getText() + " and error message as " +error.get(i).getText());

        driver.close();
        driver.quit();
    }
}
