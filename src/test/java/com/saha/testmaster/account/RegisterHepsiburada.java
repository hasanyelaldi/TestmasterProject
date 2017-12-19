package com.saha.testmaster.account;

import com.saha.testmaster.base.BaseHepsiburada;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class RegisterHepsiburada extends BaseHepsiburada {

    /*---------- Chapter 1 ----------*/

    @Test
    public void successRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfghjqwe@windowslive.com","Reg123.","Reg123.",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("E-posta adresiniz ya da şifreniz yanlış."));
    }

    //------------ TT(subscribeEmail:True subscribeSms:True) ----------------//

    @Test
    public void emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","","","",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void wrongFormatEmailTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg1234.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPassword_emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg1234.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    //------------ TF(subscribeEmail:True subscribeSms:False) ----------------//

    @Test
    public void emptyTFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","","","",true,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void wrongFormatEmailTFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg123.",true,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordTFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg1234.",true,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyTFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg123.",true,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPassword_emptyTFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg1234.",true,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    //------------ FT(subscribeEmail:False subscribeSms:True) ----------------//

    @Test
    public void emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","","","",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void wrongFormatEmailFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg1234.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPassword_emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg1234.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    //------------ FF(subscribeEmail:False subscribeSms:False) ----------------//

    @Test
    public void emptyFFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","","","",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
    }

    @Test
    public void wrongFormatEmailFFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg123.",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordFFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","Reg123.","Reg1234.",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyFFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg123.",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPassword_emptyFFRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageHb().register("","","qwertyasdfgh","Reg123.","Reg1234.",false,false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen aynı değeri tekrar giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Bu alanın doldurulması zorunludur."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    /*---------- Chapter 1 End----------*/
}
