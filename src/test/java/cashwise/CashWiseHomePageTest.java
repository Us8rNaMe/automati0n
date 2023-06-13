package cashwise;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashWiseHomePage;
import utilities.Config;
import utilities.Driver;
public class CashWiseHomePageTest {
    @BeforeMethod
    public void setupUrl(){
    Driver.getDriver().get(Config.getValue("cashWiseUrl"));
    }
    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }

    //========================================================================//
    //========================================================================//
    //========================================================================//

    @Test
    public void contactPopUp(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        Faker faker = new Faker();
        cashWiseHomePage.contactNameField.sendKeys(faker.name().fullName());
        cashWiseHomePage.contactNumberField.sendKeys(faker.phoneNumber().phoneNumber());
        cashWiseHomePage.contactEmailField.sendKeys(faker.internet().emailAddress());
        cashWiseHomePage.contactSendBtn.click();
        System.out.println(cashWiseHomePage.popUpMainPage.getText());
        Assert.assertTrue(cashWiseHomePage.popUpMainPage.isDisplayed(),"Something wrong with pop up");
    }
    @Test
    public void russian(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        cashWiseHomePage.languageMainDrop.click();
        cashWiseHomePage.russianLanguage.click();
        Assert.assertEquals(cashWiseHomePage.mainText.getText(),"ПОМОЩЬ В УПРАВЛЕНИИ ФИНАНСАМИ ВАШЕГО БИЗНЕСА");
    }
    @Test
    public void english(){
        CashWiseHomePage cashWiseHomePage = new CashWiseHomePage();
        cashWiseHomePage.languageMainDrop.click();
        cashWiseHomePage.englishLanguage.click();
        Assert.assertEquals(cashWiseHomePage.mainText.getText(),"ASSISTANCE IN MANAGING THE FINANCES OF YOUR BUSINESS");
    }
}