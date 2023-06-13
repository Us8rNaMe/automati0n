package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CashWiseHomePage {

    public CashWiseHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button)[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "(//button)[2]")
    public WebElement signUpBtn;

    @FindBy(xpath = "(//button)[3]")
    public WebElement signUpDownBtn;

    @FindBy(xpath = "(//button)[4]")
    public WebElement contactSendBtn;

    @FindBy(xpath = "(//input)[1]")
    public WebElement contactNameField;

    @FindBy(xpath = "(//input)[2]")
    public WebElement contactNumberField;

    @FindBy(xpath = "(//input)[3]")
    public WebElement contactEmailField;

    @FindBy(xpath = "(//h2)[6]")
    public WebElement popUpMainPage;

}