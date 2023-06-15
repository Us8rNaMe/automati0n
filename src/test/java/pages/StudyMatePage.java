package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudyMatePage {
    public StudyMatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//input)[1]")
    public WebElement emailField;

    @FindBy (xpath = "(//input)[2]")
    public WebElement passwordField;

    @FindBy(xpath = "(//button)[3]")
    public WebElement loginBtn;

    @FindBy(xpath = "(//li)[4]")
    public WebElement TeacherBtn;

    @FindBy(xpath = "(//button)[1]")
    public WebElement addTeacher;

    @FindBy(xpath = "(//input)[3]")
    public WebElement firstTeacherNameField;

    @FindBy(xpath = "(//input)[4]")
    public WebElement lastTeacherNameField;

    @FindBy(xpath = "(//input)[5]")
    public WebElement phoneTeacherNumberField;

    @FindBy(xpath = "(//input)[6]")
    public WebElement emailTeacherField;

    @FindBy(xpath = "(//input)[7]")
    public WebElement specializationTeacherField;

    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-14dyfzn']")
    public WebElement choseCourseForTeacher;

    @FindBy(xpath = "(//input)[9]")
    public WebElement javaCoreCheckBox;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement addBtnForTeacher;

    @FindBy(xpath = "//tbody/tr/td[.='John Smith']")
    public WebElement expectedName;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiPaginationItem-root MuiPaginationItem-sizeMedium MuiPaginationItem-text MuiPaginationItem-circular MuiPaginationItem-previousNext css-1xr9krm']")
    public WebElement nextTeacherPageBtn;
}
