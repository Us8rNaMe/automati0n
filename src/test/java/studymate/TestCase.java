package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StudyMateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class TestCase {
    @BeforeTest
    public void driver(){
        Driver.getDriver().get(Config.getValue("URL"));
    }
    @Test
    public void createTeacher(){
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        studyMateLoginPage.TeacherBtn.click();
        studyMateLoginPage.addTeacher.click();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String lastAndFirstName = firstName+" "+lastName;
        studyMateLoginPage.firstTeacherNameField.sendKeys(firstName);
        studyMateLoginPage.lastTeacherNameField.sendKeys(lastName);
        studyMateLoginPage.phoneTeacherNumberField.sendKeys("2301007780");
        studyMateLoginPage.emailTeacherField.sendKeys(faker.internet().emailAddress());
        studyMateLoginPage.specializationTeacherField.sendKeys(faker.job().position());
        ApplicationFlow.pause(500);
        studyMateLoginPage.choseCourseForTeacher.click();
        ApplicationFlow.pause(500);
        studyMateLoginPage.javaCoreCheckBox.click();
        ApplicationFlow.pause(500);
        actions.click().perform();
        studyMateLoginPage.addBtnForTeacher.click();
        ApplicationFlow.pause(500);
        if(studyMateLoginPage.expectedName.equals(lastAndFirstName)){
            Assert.assertEquals(studyMateLoginPage.expectedName,lastAndFirstName);
        }else {
            actions.moveToElement(studyMateLoginPage.nextTeacherPageBtn).perform();
            actions.click().perform();
        }




    }

}
