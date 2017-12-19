package com.saha.testmaster.page;

import com.saha.testmaster.constants.HepsiburadaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteShoppingPage extends BasePageUtil implements HepsiburadaConstants {

    public CompleteShoppingPage(WebDriver driver) {
        super(driver);
    }

    public HomePage addAddress(String firstName, String lastName, String address,String addressName, String zipCode, String phone){

        thread(1);
        sendKey(FIRSTNAME_ADDRESS,firstName);
        sendKey(LASTNAME_ADDRESS,lastName);
        Select dropdownCountry = new Select(driver.findElement(By.id("country")));
        dropdownCountry.selectByVisibleText("Türkiye");

        Select dropdownCity = new Select(driver.findElement(By.id("city")));
        dropdownCity.selectByVisibleText("İstanbul");
        thread(2);
        driver.findElement(By.id("town")).findElements(By.tagName("option")).get(0).click();
        thread(2);

        Select dropdownDistrict = new Select(driver.findElement(By.id("district")));
        dropdownDistrict.selectByValue("1322");

        sendKey(ADDRESS_ADDRESS,address);
        sendKey(ADDRESSNAME_ADDRESS,addressName);
        sendKey(ZIPCODE_ADDRESS ,zipCode);
        sendKey(PHONE_ADDRESS ,phone);


        return new HomePage(driver);
    }

    public HomePage completeShopping(){
        thread(2);
        click(By.xpath("/html//div[@id='short-summary']//button[@class='btn btn-primary full']"));
        return new HomePage(driver);
    }

    public HomePage completeShoppingDF(){
        thread(2);
        driver.findElement(By.xpath("/html//section[@id='fixed']/div[5]/div/div//ul[@class='productSizes productWidthHeight top15']/li[7]/a[@href='javascript:;']/span[.='3XL']")).click();
        thread(2);
        driver.findElement(By.id("addToCart")).click();
        thread(2);
        driver.findElement(By.linkText("Sepete Git")).click();
        thread(2);
        driver.findElement(By.id("ComplateShoppingDown")).click();
        return new HomePage(driver);
    }
}
