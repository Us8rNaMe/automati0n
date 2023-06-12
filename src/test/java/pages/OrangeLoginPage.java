package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeLoginPage {


    public OrangeLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//input)[2]")
    public WebElement usernameField;

    @FindBy(xpath = "(//input)[3]")
    public WebElement passwordField;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(xpath = "(//span)[13]")
    public WebElement dropDownUser;

    @FindBy(xpath = "(//a)[16]")
    public WebElement logOutBtn;

    @FindBy(xpath = "//input[@name='username']/../../span")
    public WebElement errorUsernameLogPage;

    @FindBy(xpath = "//input[@name='password']/../../span")
    public WebElement errorPasswordLogPage;

}
