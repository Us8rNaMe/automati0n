package cashwise;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashWiseLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class CashWiseTest {
    @BeforeMethod
    public void setupUrl(){
        Driver.getDriver().get(Config.getValue("cashWiseUrl"));
    }
    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }

    @Test
    public void contactPopUp(){
        CashWiseLoginPage cashWiseLoginPage = new CashWiseLoginPage();
        ApplicationFlow.pause(2000);
        cashWiseLoginPage.signInBtn.click();
        cashWiseLoginPage.emailSignInField.sendKeys(Config.getValue("cashWiseEmail"));
        cashWiseLoginPage.passwordSignInField.sendKeys(Config.getValue("cashWisePassword"));
        cashWiseLoginPage.loginBtnForSignIn.click();
        ApplicationFlow.pause(4000);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://cashwise.us/dashboard/infographics");
    }
}
