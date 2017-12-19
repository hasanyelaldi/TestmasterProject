package com.saha.testmaster.page;

import com.saha.testmaster.account.LoginPageDF;
import com.saha.testmaster.account.LoginPageHb;
import com.saha.testmaster.account.RegisterPageDF;
import com.saha.testmaster.account.RegisterPageHb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static com.saha.testmaster.constants.HepsiburadaConstants.URL;

public class HomePage extends BasePageUtil {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void callHome(){
        driver.navigate().to(URL);
    }

    public LoginPageHb callLoginPageHb() throws InterruptedException {
        closePopUp();
        WebElement getmenu= driver.findElement(By.xpath("/html//div[@id='myAccount']")); //xpath the parent
        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        thread(3);
        WebElement clickElement= driver.findElement(By.id("login"));//id the child
        act.moveToElement(clickElement).click().perform();

        return new LoginPageHb(driver);
    }

    public LoginPageDF callLoginPageDF() throws InterruptedException {
        click(By.xpath("/html/body//section[@class='nav-group']/nav[@role='navigation']//div[@role='toolbar']/div[4]/a[@href='/Login']"));
        return new LoginPageDF(driver);
    }

    public RegisterPageHb callRegisterPageHb() throws InterruptedException {
        closePopUp();
        WebElement getmenu= driver.findElement(By.xpath("/html//div[@id='myAccount']")); //xpath the parent
        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        thread(3);
        WebElement clickElement= driver.findElement(By.id("register"));//id the child
        act.moveToElement(clickElement).click().perform();

        return new RegisterPageHb(driver);
    }

    public RegisterPageDF callRegisterPageDF() throws InterruptedException {
        click(By.xpath("/html/body//section[@class='nav-group']/nav[@role='navigation']//div[@role='toolbar']//a[@href='/Login/Register']"));
        return new RegisterPageDF(driver);
    }

    public ProductListPage addFilter(){
        thread(1);
        return new ProductListPage(driver);
    }

    public void goPageWithNumber(int number){
        for(int i=1; i<=number;i++){
            click(By.className("page-"+i));
            thread(1);
        }
    }

    public ProductListPage callComputerOnMenu(){
        thread(1);
        WebElement menu= driver.findElement(By.xpath("//li[@id='elektronik']//span[.='ELEKTRONİK']"));
        Actions act = new Actions(driver);
        act.moveToElement(menu).perform();

        thread(3);
        WebElement clickElement= driver.findElement(By.linkText("Bilgisayar/Tablet"));
        act.moveToElement(clickElement).click().perform();

        return new ProductListPage(driver);
    }

    public ProductListPage callProductByName(String name){
        thread(2);
        find(By.id("productSearch")).sendKeys(name);
        thread(2);
        click(By.id("buttonProductSearch"));

        return new ProductListPage(driver);
    }

    public ProductDetailPage callProductByIdAndPath(String id, String xpath){
        thread(3);
        find(By.id("productSearch")).sendKeys(id);
        thread(3);
        click(By.xpath(xpath));

        return new ProductDetailPage(driver);
    }

    public ProductDetailPage callProductDetailByXpath(String productXpath){
        click(By.xpath(productXpath));
        return new ProductDetailPage(driver);
    }

    public CartPage callCartPage(){
        return new CartPage(driver);
    }

    public CompleteShoppingPage callCompleteShoppingPage(){
        click(By.xpath("/html//div[@id='short-summary']//button[@class='btn btn-primary full']"));
        thread(3);
        return new CompleteShoppingPage(driver);
    }

    public PaymentPage callPaymentPage(){
        return new PaymentPage(driver);
    }

    public ProductListPage callProductForMan(){
        click(By.xpath("//div[@id='navbar-collapse-grid']/ul[@class='nav navbar-nav']//span[.='ERKEK']"));
        return new ProductListPage(driver);
    }

    public CompleteShoppingPage skipPaymentDF(){
        return new CompleteShoppingPage(driver);
    }

}
