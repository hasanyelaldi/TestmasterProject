package com.saha.testmaster.account;

import com.saha.testmaster.base.BaseHepsiburada;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class LoginHepsiburada extends BaseHepsiburada {

    /*---------- Chapter 2 ----------*/
    @Test
    public void successLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("hasanyelaldi@windowslive.com", "hasan123456.");
    }

    @Test
    public void failLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("aaaaa@windowslive.com", "123456.");
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("E-posta adresiniz ya da şifreniz yanlış."));
    }

    @Test
    public void emptyLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("", "");
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void emptyUsernameLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("", "hasan123456");
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void emptyPasswordLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("hasanyelaldi@windowslive.com", "");
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void wrongFormatUsernameLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("qwertyasdfgh", "hasan123456.");
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatUsername_EmptyPasswordLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageHb().login("qwertyasdfgh", "");

        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }
    /*---------- Chapter 2 End----------*/
}