package com.saha.testmaster.test;

import com.saha.testmaster.base.BaseHepsiburada;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class BuyProductHepsiburada extends BaseHepsiburada{

    HomePage homePage;
    private String BUY_BUTTON = "/html//form[@id='form-item-list']/ul[@class='cart-item-list']//div[@class='product-prices-utils']/div[3]/span[@class='text']";
    private String MOUSE_ID = "BD300723";
    private String MOUSE_XPATH = "//a[@href='/logitech-m185-nano-optik-kablosuz-mouse-mavi-910-002236-p-BD300723?magaza=Elektro Sepeti&t=product&q=BD300723']//img[@alt='image of Logitech® M185 Nano Optik Kablosuz Mouse Mavi (910-002236) with sku:BD300723']";
    private String MOUSE_QUANTİTY_ID = "quantity";
    private String MOUSE_QUANTİTY = "3";

    private String PHONE_ID = "HBV000007PV9M";
    private String PHONE_XPATH = "//div[@id='ProductSearch']/form[@action='/ara']/div/div[2]//ul[@class='rfk_products']//a[@href='/apple-iphone-8-plus-64-gb-apple-turkiye-garantili-p-HBV000007PV9M?magaza=Hepsiburada&t=product&q=HBV000007PV9M']//img[@alt='image of Apple iPhone 8 Plus 64 GB (Apple Türkiye Garantili) with sku:HBV000007PV9M']";
    private String IPHONE_GOLD = "//body//div[@class='product-detail-module']/section[@class='detail-main']//div[@class='productDetailContent']//div[@class='product-variants-content variants-select-content']/div[@class='product-variants-wrapper']/div[@class='variant-container-with-prices']/div[1]/label/div[@title='Gold']/span[@class='variant-name']";
    private String IPHONE_SILVER = "//body//div[@class='product-detail-module']/section[@class='detail-main']//div[@class='productDetailContent']//div[@class='product-variants-content variants-select-content']/div[@class='product-variants-wrapper']/div[@class='variant-container-with-prices']/div[2]/label/div[@title='Silver']/span[@class='variant-name']";
    private String IPHONE_SPACEGRAY ="//body//div[@class='product-detail-module']/section[@class='detail-main']//div[@class='productDetailContent']//div[@class='product-variants-content variants-select-content']/div[@class='product-variants-wrapper']/div[@class='variant-container-with-prices']/div[3]/label/div[@title='Space Gray']/span[@class='variant-name']";
    private String FIXPACK_TEXT = "/html//form[@id='form-item-list']/ul[@class='cart-item-list']/li[2]/div[@class='item-content']/div[@class='product-detail']/h4[@class='product-name']/a[@href='http://www.hepsiburada.com/fixpack-1-yillik-4001-5000-tl-arasi-cep-telefonu-koruma-paketi-p-HBV0000033FIC?magaza=Hepsiburada']";

    private String CARDNUMBER = "4282209027132016";
    private String CARDNAME = "HASAN YELALDI";
    private String CARDMONTH = "05";
    private String CARDYEAR = "2018";
    private String SECURITYCODE = "000";


    @Before
    public void before() throws InterruptedException {
        homePage= new HomePage(driver);
        homePage.callLoginPageHb().login("hasanyelaldi@windowslive.com", "hasan123456."); //Login
        homePage.callCartPage().emptyTheBasketHb(); // Empty the basket if have a product in cart
        homePage.callHome(); // Homepage
    }

    /*---------- Chapter 3 ----------*/
    @Test
    public void successMouseSelect_fromMenu() throws InterruptedException {
        homePage.callComputerOnMenu().filterToPeripherals().addFilter().filterToMouse().goPageWithNumber(7);
        Thread.sleep(1);
        driver.findElement(By.xpath("//div[@id='productresults']/div[3]/div/div/div[@class='box-container loader']/div/ul/li[1]/div")).click();
        driver.findElement(By.id("addToCart")).click();Thread.sleep(1);
    }
    /*---------- Chapter 3 End ----------*/

    /*---------- Chapter 4 ----------*/
    @Test
    public void successMouseBuy_BD300723() throws InterruptedException {
        homePage.callProductByIdAndPath(MOUSE_ID, MOUSE_XPATH).productDetail().callCartPage().cartSummary(3);
        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();Thread.sleep(1000);
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
    }
    /*---------- Chapter 4 End ----------*/

    /*---------- Chapter 5 ----------*/
    // IPHONE GOLD
    @Test
    public void goldPhoneBuy() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_GOLD).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }

    // IPHONE GOLD Sixpack:True
    @Test
    public void goldPhoneBuyWithSixpack() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_GOLD,true).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        String fixpackText = driver.findElement(By.xpath(FIXPACK_TEXT)).getText();
        Assert.assertTrue("Fixpack koruma modülünde problem var!",fixpackText.contains("Fixpack 1 Yıllık 4001-5000 TL Arası Cep Telefonu Koruma Paketi"));
        Thread.sleep(1000);
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }

    // IPHONE SILVER
    @Test
    public void silverPhoneBuy() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_SILVER).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }

    // IPHONE SILVER Sixpack:True
    @Test
    public void silverPhoneBuyWithSixpack() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_SILVER,true).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        String fixpackText = driver.findElement(By.xpath(FIXPACK_TEXT)).getText();
        Assert.assertTrue("Fixpack koruma modülünde problem var!",fixpackText.contains("Fixpack 1 Yıllık 4001-5000 TL Arası Cep Telefonu Koruma Paketi"));
        Thread.sleep(1000);
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }

    // IPHONE SPACEGRAY
    @Test
    public void spacegrayPhoneBuy() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_SPACEGRAY).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }

    // IPHONE SPACEGRAY Sixpack:True
    @Test
    public void spacegrayPhoneBuyWithSixpack() throws InterruptedException {
        homePage.callProductByIdAndPath(PHONE_ID, PHONE_XPATH).phoneProductDetail(IPHONE_SPACEGRAY,true).callCartPage().cartSummary(1);

        String shipment = driver.findElement(By.xpath(BUY_BUTTON)).getText();
        Assert.assertTrue("Kargo bedava modülünde problem var!",shipment.contains("Kargo Bedava"));
        Thread.sleep(1000);
        String fixpackText = driver.findElement(By.xpath(FIXPACK_TEXT)).getText();
        Assert.assertTrue("Fixpack koruma modülünde problem var!",fixpackText.contains("Fixpack 1 Yıllık 4001-5000 TL Arası Cep Telefonu Koruma Paketi"));
        Thread.sleep(1000);
        //homePage.callCompleteShoppingPage().addAddress("Hasan","Yelaldi","Erdem sok 18/3","Atalar"," 34862","05533513210");
        homePage.callCompleteShoppingPage().completeShopping();
        homePage.callPaymentPage().payWithCardHb(CARDNUMBER,CARDNAME,CARDMONTH,CARDYEAR,SECURITYCODE);
        confrimOrder();
    }
    /*---------- Chapter 5 End----------*/

    /*---------- Chapter 6 ----------*/
    @Test
    public void successShoesBuy() throws InterruptedException {
        homePage.callProductByName("Ayakkabı").filterToMan().addFilter().filterToManShoes().addFilter().filterToPriceStartsWith250().addFilter()
                .filterToSellerHepsiburada().addFilter().filterToNo44().addFilter().filterToBrown();
        driver.findElement(By.xpath("//div[@id='productresults']/div[3]/div/div/div[@class='box-container loader']//ul/div[1]/li[1]/div")).click();
        driver.findElement(By.id("addToCart")).click();
    }
    /*---------- Chapter 6 End----------*/


    public double getPrice(double orgPrice,double discount){
        return orgPrice-(orgPrice*(discount/100));
    }

    public void confrimOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@id='frm-save-order']/button[@class='btn btn-primary full']")).click();
    }

}
