package com.saha.testmaster.account;

import com.saha.testmaster.constants.DeFactoConstants;
import com.saha.testmaster.page.BasePageUtil;
import com.saha.testmaster.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageDF extends BasePageUtil implements DeFactoConstants {

    public LoginPageDF(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password, boolean rememberMe) {
        sendKey(EMAİL_TEXTBOX,email);
        sendKey(PASSWORD,password);
        if(rememberMe == true){click(REMEMBERME);}
        click(By.id("LoginBtn"));
        thread(1);
        return new HomePage(driver);
    }

}
