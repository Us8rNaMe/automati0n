package cashwise;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CashWiseHomePage;
import utilities.Driver;
public class CashWiseHomePageTest {

    @Test
        public void popUp(){
            CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
            Faker faker = new Faker();
            Driver.getDriver().get("http://cashwise.us/main?showReg=false");
            cashWiseHomePage.contactNameField.sendKeys(faker.name().fullName());
            cashWiseHomePage.contactNumberField.sendKeys(faker.phoneNumber().phoneNumber());
            cashWiseHomePage.contactEmailField.sendKeys(faker.internet().emailAddress());
            cashWiseHomePage.contactSendBtn.click();
            System.out.println(cashWiseHomePage.popUpMainPage.getText());
            Assert.assertTrue(cashWiseHomePage.popUpMainPage.isDisplayed(),"Something wrong with pop up");
        }

    @AfterTest
        public void cleanUp(){
            Driver.quit();
        }
    }