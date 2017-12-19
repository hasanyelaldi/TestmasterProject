package com.saha.testmaster.page;

import com.saha.testmaster.constants.DeFactoConstants;
import com.saha.testmaster.constants.HepsiburadaConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePageUtil implements HepsiburadaConstants,DeFactoConstants {

    public PaymentPage(WebDriver driver) {
         super(driver);
    }

    public HomePage payWithCardHb(String cardNumber, String cardName, String cardMonth, String cardYear, String securityCode){
        thread(3);
        sendKey(CARDNUMBER_PAYMENT,cardNumber);
        sendKey(CARDNAME_PAYMENT,cardName);
        thread(1);
        click(By.xpath("/html//form[@id='form-credit-card']//div[@class='date-col group']/div[1]/div/button[@title='Ay']"));
        thread(1);
        click(By.linkText(cardMonth));
        thread(1);
        click(By.xpath("/html//form[@id='form-credit-card']//div[@class='date-col group']/div[2]/div/button[@title='Yıl']"));
        thread(1);
        click(By.linkText(cardYear));
        thread(1);
        sendKey(SECURITYCODE_PAYMENT,securityCode);
        thread(1);
        click(By.xpath("//div[@id='short-summary']//button[@class='btn btn-primary full']/span[@class='text']"));
        thread(1);
        return new HomePage(driver);
    }

    public HomePage payWithCardDF(String cardNumber, String cardMonth, String cardYear, String securityCode, boolean contract){
        thread(6);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE);
        click(By.className("text-grey-dark"));
        thread(2);
        sendKey(CARDNUMBER_PAYMENTDF,cardNumber);
        thread(1);

        Select month= new Select(find(CARDMONTH_PAYMENTDF));
        month.selectByVisibleText(cardMonth);
        thread(1);
        Select year= new Select(find(CARDYEAR_PAYMENTDF));
        year.selectByVisibleText(cardYear);
        thread(1);

        sendKey(SECURITYCODE_PAYMENTDF,securityCode);
        thread(1);
        if (contract == true){click(CONTRACT_PAYMENTDF);}
        thread(1);
        click(By.id("CreditCardBtn"));
        thread(1);
        return new HomePage(driver);
    }
}
