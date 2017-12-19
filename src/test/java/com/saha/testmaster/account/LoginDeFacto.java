package com.saha.testmaster.account;

import com.saha.testmaster.base.BaseDeFacto;
import com.saha.testmaster.page.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginDeFacto extends BaseDeFacto{

    @Test
    public void successLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("hasanyelaldi@windowslive.com", "hasan123.",false);
    }

    @Test
    public void successLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("hasanyelaldi@windowslive.com", "hasan123.",true);
    }

    @Test
    public void failLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("aaaaa@windowslive.com", "123456.",false);
        Assert.assertTrue("Hata!!", driver.findElement(By.id("UpdateTargetLogin")).getText().contains("Lütfen kullanıcı bilgilerini kontrol edip tekrar deneyiniz."));
    }

    @Test
    public void failLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("aaaaa@windowslive.com", "123456.",true);
        Assert.assertTrue("Hata!!", driver.findElement(By.id("UpdateTargetLogin")).getText().contains("Lütfen kullanıcı bilgilerini kontrol edip tekrar deneyiniz."));
    }

    @Test
    public void emptyLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("", "",false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }

    @Test
    public void emptyLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("", "",true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }

    @Test
    public void emptyUsernameLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("", "hasan123456",false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
    }

    @Test
    public void emptyUsernameLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("", "hasan123456",true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen e-posta adresinizi giriniz."));
    }

    @Test
    public void emptyPasswordLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("hasanyelaldi@windowslive.com", "",false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }

    @Test
    public void emptyPasswordLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("hasanyelaldi@windowslive.com", "",true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }

    @Test
    public void wrongFormatUsernameLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("qwertyasdfgh", "hasan123.",false);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatUsernameLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("qwertyasdfgh", "hasan123456.",true);
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
    }

    @Test
    public void wrongFormatUsername_EmptyPasswordLogin() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("qwertyasdfgh", "",false);

        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }

    @Test
    public void wrongFormatUsername_EmptyPasswordLoginWithRemember() throws InterruptedException {
        new HomePage(driver).callLoginPageDF().login("qwertyasdfgh", "",true);

        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen geçerli bir e-posta adresi giriniz."));
        Assert.assertTrue("Hata!!", driver.getPageSource().contains("Lütfen şifrenizi giriniz."));
    }
}
