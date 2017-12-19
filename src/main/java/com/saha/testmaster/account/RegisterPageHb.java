package com.saha.testmaster.account;

import com.saha.testmaster.constants.HepsiburadaConstants;
import com.saha.testmaster.page.BasePageUtil;
import com.saha.testmaster.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageHb extends BasePageUtil implements HepsiburadaConstants {

    public RegisterPageHb(WebDriver driver) {
        super(driver);
    }

    public HomePage register(String firstname, String lastname, String emailRegister, String passwordRegister,
                             String passwordRepeat, boolean subscribeEmail, boolean subscribeSms) {

        sendKey(FIRSTNAME, firstname);
        sendKey(LASTNAME, lastname);
        sendKey(EMAİL_REGİSTER, emailRegister);
        sendKey(PASSWORD_REGİSTER, passwordRegister);
        sendKey(PASSWORD_REPEAT, passwordRepeat);

        if(subscribeEmail == true){click(By.xpath("/html//form[@id='form-user']//div[@class='notification-row']/label[@class='text']"));}
        if(subscribeSms == true){click(By.xpath("//form[@id='form-user']/div[5]/label[@class='text']"));}

        click(By.xpath("//form[@id='form-user']//button[@type='submit']"));

        thread(3);
        return new HomePage(driver);
    }
}
