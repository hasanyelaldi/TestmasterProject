package com.saha.testmaster.account;

import com.saha.testmaster.constants.HepsiburadaConstants;
import com.saha.testmaster.page.BasePageUtil;
import com.saha.testmaster.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHb extends BasePageUtil implements HepsiburadaConstants {


    public LoginPageHb(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password) {
        sendKey(EMAİL_TEXTBOX,email);
        sendKey(PASSWORD,password);
        click(By.xpath("//form[@id='form-login']//button[@type='submit']"));
        thread(1);
        return new HomePage(driver);
    }


}
