package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CashWiseHomePage;
import utilities.Driver;

public class CashWise {
    @Test
    public void popUp(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        Driver.getDriver().get("http://cashwise.us/main?showReg=false");
        cashWiseHomePage.contactNameField.sendKeys("Bond");
        cashWiseHomePage.contactNumberField.sendKeys("123456789");
        cashWiseHomePage.contactEmailField.sendKeys("joeBiden@gmail.com");
        cashWiseHomePage.contactSendBtn.click();
        System.out.println(cashWiseHomePage.popUpMainPage.getText());

    }
    @AfterTest
    public void cleanUp(){
        Driver.quit();
    }
}
