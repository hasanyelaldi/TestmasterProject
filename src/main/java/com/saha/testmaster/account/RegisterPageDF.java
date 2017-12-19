package com.saha.testmaster.account;

import com.saha.testmaster.constants.DeFactoConstants;
import com.saha.testmaster.page.BasePageUtil;
import com.saha.testmaster.page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageDF extends BasePageUtil implements DeFactoConstants {

    public RegisterPageDF(WebDriver driver) {
        super(driver);
    }

    public HomePage register(String firstname, String lastname, String emailRegister, String phoneNumber, String day, String month, String year,
                             String gender,String passwordRegister,String passwordRepeat, boolean subscribe, boolean confrim) {

        sendKey(FIRSTNAME, firstname);
        sendKey(LASTNAME, lastname);
        sendKey(EMAİL_REGİSTER, emailRegister);
        sendKey(PHONE_REGİSTER, phoneNumber);

        Select dropdownDay = new Select(driver.findElement(DAY_REGISTER));
        dropdownDay.selectByVisibleText(day);
        Select dropdownMonth = new Select(driver.findElement(MONTH_REGISTER));
        dropdownMonth.selectByVisibleText(month);
        Select dropdownYear = new Select(driver.findElement(YEAR_REGISTER));
        dropdownYear.selectByVisibleText(year);

        Select dropdownGender = new Select(driver.findElement(GENDER_REGISTER));
        dropdownGender.selectByVisibleText(gender);

        sendKey(PASSWORD_REGİSTER, passwordRegister);
        sendKey(PASSWORD_REPEAT, passwordRepeat);

        if(subscribe == true){click(SUBSCRIBE_REGISTER);}
        if(confrim == true){click(CONFRIM_REGISTER);}

        click(By.id("RegisterBtn"));

        thread(3);
        return new HomePage(driver);
    }
}
