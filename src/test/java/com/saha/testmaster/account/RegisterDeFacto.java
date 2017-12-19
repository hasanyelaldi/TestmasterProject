package com.saha.testmaster.account;

import com.saha.testmaster.base.BaseDeFacto;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class RegisterDeFacto extends BaseDeFacto {

    /*---------- Chapter 8 ----------*/
    @Test
    public void successRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfghq@gmail.com","5533513210","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
    }

    @Test
    public void emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Kadın",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void emptyFTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Kadın",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void emptyTTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Erkek",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void wrongRepeatPassword_emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Kadın",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongRepeatPassword_emptyFTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongRepeatPassword_emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Kadın",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongRepeatPassword_emptyTTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","","","29","10","1993","Erkek",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongFormatEmail_emptyFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","asdfasdasd","","29","10","1993","Kadın",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyFTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","asdfasdasd","","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","asdfasdasd","","29","10","1993","Kadın",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void wrongFormatEmail_emptyTTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("","","asdfasdasd","","29","10","1993","Erkek",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen adınızı giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen soyadınızı girinizi."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen cep telefonunuzu giriniz."));
    }

    @Test
    public void wrongFormatEmailFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Kadın",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmailFTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmailTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","05533513210","29","10","1993","Kadın",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmailTTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Erkek",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordFTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Kadın",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordFTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Erkek",
                "hasan123.","hasan123.",false,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordTTRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Kadın",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    @Test
    public void wrongFormatEmail_wrongRepeatPasswordTTManRegister() throws InterruptedException {
        new HomePage(driver).callRegisterPageDF().register("qwertyasdfgh","qwertyasdfgh","qwertyasdfgh","5533513210","29","10","1993","Erkek",
                "hasan123.","hasan123.",true,true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Şifreler eşleşmiyor."));
    }

    /*---------- Chapter 8 End----------*/
}
