package com.saha.testmaster.constants;

import org.openqa.selenium.By;

public interface DeFactoConstants {
    String URL = "http://www.defacto.com.tr";

    String ChromeWebDriver ="webdriver.chrome.driver";
    String ChromeWebDriverPath ="driver/chromedriver.exe";

    By EMAİL_TEXTBOX = By.id("LoginModel_Email");
    By PASSWORD = By.id("LoginModel_Password");
    By REMEMBERME = By.id("LoginModel_IsCreatePersistentCookie");

    By FIRSTNAME = By.id("RegisterModel_CustomerFirstName");
    By LASTNAME = By.id("RegisterModel_CustomerLastName");
    By EMAİL_REGİSTER = By.id("RegisterModel_CustomerEmail");
    By PHONE_REGİSTER = By.id("RegisterModel_CustomerMobilePhone");
    By DAY_REGISTER = By.id("RegisterModel_CustomerBirthDateDay");
    By MONTH_REGISTER = By.id("RegisterModel_CustomerBirthDateMonth");
    By YEAR_REGISTER = By.id("RegisterModel_CustomerBirthDateYear");
    By GENDER_REGISTER = By.name("RegisterModel.Gender");
    By PASSWORD_REGİSTER = By.id("RegisterModel_CustomerPassword");
    By PASSWORD_REPEAT = By.id("RegisterModel_CustomerPasswordConfirm");
    By SUBSCRIBE_REGISTER = By.id("RegisterModel_CustomerIsSmsSubscriberAndIsSubscriber");
    By CONFRIM_REGISTER = By.id("RegisterModel_CustomerIsApprovedContract");

    By CARDNUMBER_PAYMENTDF = By.id("Payment_CardNumber1");
    By CARDMONTH_PAYMENTDF = By.id("Payment_ExpireMonth");
    By CARDYEAR_PAYMENTDF = By.id("Payment_ExpireYear");
    By SECURITYCODE_PAYMENTDF = By.id("Payment_SecurityCode");
    By CONTRACT_PAYMENTDF = By.id("IsCreditCardContractEnable");
}
