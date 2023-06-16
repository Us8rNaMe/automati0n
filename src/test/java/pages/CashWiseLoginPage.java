package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CashWiseLoginPage {

   public CashWiseLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button)[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "(//input)[4]")
    public WebElement emailSignInField;

    @FindBy(xpath = "(//input)[5]")
    public WebElement passwordSignInField;

    @FindBy(xpath = "(//button[.='Sign in'])[2]")
    public WebElement loginBtnForSignIn;
}
