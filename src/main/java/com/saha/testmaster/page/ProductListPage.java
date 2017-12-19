package com.saha.testmaster.page;

import com.saha.testmaster.constants.DeFactoConstants;
import com.saha.testmaster.constants.HepsiburadaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductListPage extends BasePageUtil implements HepsiburadaConstants,DeFactoConstants {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    // Hepsiburada's filters
    public HomePage filterToMan(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[2]/div//div[@class='items-container']/ul[@class='items']/li[@alt='Erkek']/a[@href='/erkek-giyim-modelleri-c-12087177']/span[1]"));
        return new HomePage(driver);
    }

    public HomePage filterToManShoes(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[2]/div//div[@class='items-container']/ul[@class='items']/li[@alt='Erkek Ayakkabı']/a[@href='/ayakkabi-c-60000117']/span[1]"));
        return new HomePage(driver);
    }

    public HomePage filterToPriceStartsWith250(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[3]/div//ol[@class='filters-container']/li[@class='box-container fiyat']/ol/li[@alt='250 - 500 TL']/label"));
        return new HomePage(driver);
    }

    public HomePage filterToSellerHepsiburada(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[3]/div//ol[@class='filters-container']/li[@class='box-container satici']/ol/li[@alt='Hepsiburada']/label"));
        return new HomePage(driver);
    }

    public HomePage filterToNo44(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[3]/div//ol[@class='filters-container']/li[@class='box-container numara']/ol/li[@alt='44']/label"));
        return new HomePage(driver);
    }

    public HomePage filterToBrown(){
        click(By.xpath("//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[3]/div//ol[@class='filters-container']/li[@class='box-container color-palette renk']/ol/li[@alt='Kahverengi']/label"));
        return new HomePage(driver);
    }

    public HomePage filterToPeripherals(){
        click(By.xpath("/html//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[2]/div//div[@class='items-container']/ul[@class='items']/li[@alt='Çevre Birimleri']/a[@href='/cevre-birimleri-c-3013120']"));
        return new HomePage(driver);
    }

    public HomePage filterToMouse(){
        click(By.xpath("/html//div[@id='productResult']//section[@class='page-options']/div[@class='filter-box-container']/div[2]/div//div[@class='items-container']/ul[@class='items']/li[@alt='Mouse']/a[@href='/mouse-c-52']"));
        return new HomePage(driver);
    }

    // DeFacto's filters
    public HomePage filterToShirt(){
        click(By.linkText("Model"));
        thread(2);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//div[@id='facetAccordion']/div[3]/div[2]/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Gömlek']"));
        thread(1);
        je.executeScript("arguments[0].scrollIntoView();",element);
        je.executeScript("window.scrollBy(0,-100)",element);
        thread(2);
        click(By.xpath("//div[@id='facetAccordion']/div[3]/div[2]/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Gömlek']"));
        thread(1);
        return new HomePage(driver);
    }

    public HomePage filterToIndigoBlue(){
        click(By.linkText("Renk"));
        thread(2);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Çivit Mavisi']"));
        thread(1);
        je.executeScript("arguments[0].scrollIntoView();",element);
        je.executeScript("window.scrollBy(0,-100)",element);
        thread(2);
        click(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Çivit Mavisi']"));
        thread(1);
        return new HomePage(driver);
    }

    public HomePage filterToGrey(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Gri']"));
        thread(1);
        je.executeScript("arguments[0].scrollIntoView();",element);
        je.executeScript("window.scrollBy(0,-100)",element);
        thread(2);
        click(By.xpath("//div[@id='fx_c']/div/div/div/div[@class='mCSB_container']/div[@id='boutique-category']/ul[@class='navbar-default']//gt[.='Gri']"));
        thread(1);
        return new HomePage(driver);
    }

    public HomePage nextPage(){
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,250)", "");
        thread(2);
        click(By.xpath("/html//a[@title='Sonraki Sayfa']/img[@src='https://defacto.img.sociaplus.com/140/T39KT3DZPJ.png']"));
        thread(1);
        return new HomePage(driver);
    }
}
