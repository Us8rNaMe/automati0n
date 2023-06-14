package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudyMateLoginPage {
    public StudyMateLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "(//input)[1]")
    public WebElement emailField;

    @FindBy (xpath = "(//input)[2]")
    public WebElement passwordField;

    @FindBy(xpath = "(//button)[3]")
    public WebElement loginBtn;

    @FindBy(xpath = "(//li)[2]")
    public WebElement GroupsBtn;

    @FindBy(xpath = "(//button)[1]")
    public WebElement btnForCreatingGroup;

    @FindBy(xpath = "(//input)[4]")
    public WebElement groupNameField;

    @FindBy(xpath = "//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1nvf7g0']/button")
    public WebElement groupCalendaryField;

    @FindBy(xpath = "//div[@class='MuiDayCalendar-weekContainer css-mvmu1r']/button")
    public WebElement firstDayCalendar;

    @FindBy(xpath = "(//*[@name='description'])[2]")
    public WebElement descriptionBtn;

    @FindBy(xpath = "//div[@class='sc-gKPRtg gmDlqC actions']/button[2]")
    public WebElement creatingGroupBtnAfterDescription;

    @FindBy(xpath = "(//button)[2]")
    public WebElement threeDot;

    @FindBy(xpath = "//li[.='Delete group']")
    public WebElement deleteGroupBtn;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement confirmDeleteGroup;

    @FindBy(xpath = "(//*[@class='css-7zvtr8'])[3]")
    public WebElement numbersOfProject;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']")
    public WebElement GroupPage;

}
