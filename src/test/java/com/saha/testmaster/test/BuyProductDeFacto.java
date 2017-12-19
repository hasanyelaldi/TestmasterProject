package com.saha.testmaster.test;

import com.saha.testmaster.base.BaseDeFacto;
import com.saha.testmaster.constants.DeFactoConstants;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class BuyProductDeFacto extends BaseDeFacto implements DeFactoConstants {
    HomePage homePage;
    private String CARDNUMBER = "4282209027132016";
    private String CARDMONTH = "5";
    private String CARDYEAR = "2018";
    private String SECURITYCODE = "000";
    private String RESULTBUY = "Hata : İşlem başarısız. Lütfen daha sonra tekrar deneyiniz..[Declined [İşleminizi gerçekleştiremiyoruz.Tekrar deneyiniz]]";

    @Before
    public void before() throws InterruptedException {
        homePage= new HomePage(driver);
        homePage.callLoginPageDF().login("hasanyelaldi@windowslive.com", "hasan123.",false);
        homePage.callCartPage().emptyTheBasketDF();
        driver.navigate().to(URL);
    }

    /*---------- Chapter 9 ----------*/

    @Test
    public void successShirtBuy() throws InterruptedException {
        homePage.callProductForMan().filterToShirt().addFilter().filterToIndigoBlue().addFilter().filterToGrey().addFilter().nextPage();Thread.sleep(1000);

        driver.findElement(By.xpath("/html//section[@id='fixed']//div[@class='col-lg-9 col-md-9 col-sm-9 m-t-5']/div[@class='tab-content']/div[2]//div[@class='swiper-wrapper']/div[1]")).click();Thread.sleep(2000);
        driver.findElement(By.xpath("/html//section[@id='fixed']/div[5]/div/div//ul[@class='productSizes productWidthHeight top15']/li[7]/a[@href='javascript:;']/span[.='3XL']")).click();Thread.sleep(1000);
        driver.findElement(By.id("addToCart")).click();Thread.sleep(2000);
        driver.findElement(By.linkText("Sepete Git")).click();Thread.sleep(2000);
        driver.findElement(By.id("ComplateShoppingDown")).click();Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[@class='cursor-pointer']/div/div[4]/span[@class='fa-stack']/i[2]")).click();Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/section/div[3]//button[@name='ClickCollectID']")).click();

        homePage.callPaymentPage().payWithCardDF(CARDNUMBER,CARDMONTH,CARDYEAR,SECURITYCODE,true);Thread.sleep(2000);
        Assert.assertTrue("Islem tamamlanamadı!",driver.getPageSource().contains(RESULTBUY));
    }

    /*---------- Chapter 9 End----------*/

    @Test
    public void test(){
        homePage.callCartPage().emptyTheBasketDF();
    }
}
