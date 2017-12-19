package com.saha.testmaster.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePageUtil {
    protected WebDriver driver;

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void closePopUp(){
        click(By.xpath("/html/body/div[@class='insider-opt-in-notification']//div[.='Daha sonra']"));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void click(By by) {
        find(by).click();
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    public void sendKey(By by,String value){
        driver.findElement(by).sendKeys(value);
    }

    public WebElement findWithScroll(By by){
        WebElement x=driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", x);
        return x;
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void thread(int time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean scrollPage(WebElement element,int point){
        try
        {
            Actions dragger = new Actions(driver);
            int numberOfPixelsToDragTheScrollbarDown = 10;
            for (int i = 10; i < point; i = i + numberOfPixelsToDragTheScrollbarDown)
            {
                dragger.moveToElement(element).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(element).build().perform();
            }
            thread(1);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public double getPrice(double orgPrice,double discount){
        return orgPrice-(orgPrice*(discount/100));
    }
}
