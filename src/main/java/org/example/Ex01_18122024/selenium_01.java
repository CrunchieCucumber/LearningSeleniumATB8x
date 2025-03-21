package org.example.Ex01_18122024;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class selenium_01 {

    @Test
    public void test_Selenium() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals( driver.getTitle(),"CURA Healthcare Service");

        assertThat(driver.getTitle()).isNotBlank().isNotEmpty().isEqualTo("CURA Healthcare Service");

        if(driver.getPageSource().contains("CURA Healthcare Service"))
            Assert.assertTrue(true);
        else
            throw new Exception("Heading not found");

        driver.quit();

    }
}
