package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StudyMatePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class TestCase {
    @BeforeTest
    public void driver(){
        Driver.getDriver().get(Config.getValue("URL"));
    }
    @AfterTest
    public void cleanUp(){
        ApplicationFlow.pause(15000);
        Driver.quit();
    }
    @Test
    public void createTeacher(){
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        StudyMatePage studyMatePage = new StudyMatePage();
        studyMatePage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMatePage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMatePage.loginBtn.click();
        studyMatePage.TeacherBtn.click();
        studyMatePage.addTeacher.click();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String lastAndFirstName = firstName+" "+lastName;
        studyMatePage.firstTeacherNameField.sendKeys(firstName);
        studyMatePage.lastTeacherNameField.sendKeys(lastName);
        studyMatePage.phoneTeacherNumberField.sendKeys("2301007780");
        studyMatePage.emailTeacherField.sendKeys(faker.internet().emailAddress());
        studyMatePage.specializationTeacherField.sendKeys(faker.job().position());
        ApplicationFlow.pause(500);
        studyMatePage.choseCourseForTeacher.click();
        ApplicationFlow.pause(500);
        studyMatePage.javaCoreCheckBox.click();
        ApplicationFlow.pause(500);
        actions.click().perform();
        studyMatePage.addBtnForTeacher.click();
        ApplicationFlow.pause(500);
        if(studyMatePage.expectedName.equals(lastAndFirstName)){
            Assert.assertEquals(studyMatePage.expectedName,lastAndFirstName);
        }else {
            actions.moveToElement(studyMatePage.nextTeacherPageBtn).perform();
            actions.click().perform();
        }
    }
}