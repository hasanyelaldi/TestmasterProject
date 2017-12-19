package com.saha.testmaster.page;

import com.saha.testmaster.constants.HepsiburadaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePageUtil implements HepsiburadaConstants {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public HomePage productDetail(){
        thread(1);
        click(By.id("addToCart"));
        thread(3);
        return new HomePage(driver);
    }

    public HomePage phoneProductDetail(String xpath){
        thread(1);
        click(By.xpath(xpath));
        thread(2);
        click(By.id("addToCart"));
        thread(3);
        return new HomePage(driver);
    }

    public HomePage phoneProductDetail(String xpath,boolean fixpack){
        thread(1);
        click(By.xpath(xpath));
        thread(2);
        if (fixpack == true){click(By.xpath(FIXPACK)); thread(2);}
        click(By.id("addToCart"));
        thread(3);
        return new HomePage(driver);
    }
}
