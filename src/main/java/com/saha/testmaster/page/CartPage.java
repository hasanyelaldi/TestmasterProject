package com.saha.testmaster.page;

import com.saha.testmaster.constants.HepsiburadaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageUtil implements HepsiburadaConstants {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Quantity : 1
    public HomePage cartSummary(){
        return new HomePage(driver);
    }

    // Quantity : Optional
    public HomePage cartSummary(int quantity){
        thread(1);
        if(quantity > 1){
            for (int i=1 ; i<quantity ; i++){
                click(By.xpath("/html//form[@id='form-item-list']/ul[@class='cart-item-list']//button[@title='Arttır']"));
                thread(2);
            }
        }
        return new HomePage(driver);
    }

    public HomePage emptyTheBasketHb(){
        thread(1);
        click(By.id("CartButton"));
        thread(2);
        while(driver.getPageSource().contains("message-box box umbrella expand")){
            click(By.className("btn-delete"));
            thread(2);
        }
        return new HomePage(driver);
    }

    public HomePage emptyTheBasketDF(){
        thread(1);
        click(By.cssSelector("#popupBasket"));
        thread(2);
        while(driver.getPageSource().contains("row popup-product-item")){
            click(By.className("fa-trash-o"));
            thread(2);
        }
        return new HomePage(driver);
    }

}
