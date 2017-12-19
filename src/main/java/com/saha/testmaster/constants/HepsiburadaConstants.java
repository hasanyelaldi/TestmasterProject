package com.saha.testmaster.constants;

import org.openqa.selenium.By;

public interface HepsiburadaConstants {
    String URL = "http://www.hepsiburada.com";

    String ChromeWebDriver ="webdriver.chrome.driver";
    String ChromeWebDriverPath ="driver/chromedriver.exe";

    By EMAİL_TEXTBOX = By.id("email");
    By PASSWORD = By.id("password");

    By FIRSTNAME = By.id("firstname");
    By LASTNAME = By.id("lastname");
    By EMAİL_REGİSTER = By.id("email-register");
    By PASSWORD_REGİSTER = By.id("password-register");
    By PASSWORD_REPEAT = By.id("password-repeat");

    String FIXPACK = "//body//div[@class='product-detail-module']/section[@class='detail-main']/div[4]/div[@class='productDetailContent']/div[4]/div[1]/div[6]//div[@class='suggest-row']//input[@value='HBV0000033FIC']";

    By FIRSTNAME_ADDRESS = By.id("first-name");
    By LASTNAME_ADDRESS = By.id("last-name");
    By ADDRESS_ADDRESS = By.id("address");
    By ADDRESSNAME_ADDRESS = By.id("address-name");
    By ZIPCODE_ADDRESS = By.id("zip-code");
    By PHONE_ADDRESS = By.id("phone");

    By CARDNUMBER_PAYMENT = By.id("card-no");
    By CARDNAME_PAYMENT = By.id("holder-Name");
    By SECURITYCODE_PAYMENT = By.id("cvc");

}
