package com.saha.testmaster.base;

import com.saha.testmaster.constants.DeFactoConstants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDeFacto implements DeFactoConstants{
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty(ChromeWebDriver,ChromeWebDriverPath);
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        driver.quit();
    }
}
