package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StudyMateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class StudyMateTest {
    @BeforeMethod
    public void setupUrl(){
        Driver.getDriver().get(Config.getValue("URL"));
    }
    @AfterMethod
    public void cleanUp(){
        Driver.quit();
    }
    @Test
            public void checkLogic(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        ApplicationFlow.pause(2000);
        studyMateLoginPage.GroupsBtn.click();
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='css-1qf1rpk']/div"));
        System.out.println(elements.size());

    }

    @Test
    public void login(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        ApplicationFlow.pause(2000);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://codewise.studymate.us/admin/analytics","Email ERROR");
    }
    @Test
    public void groupCreation(){
        Faker faker = new Faker();
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        ApplicationFlow.pause(2000);
        studyMateLoginPage.GroupsBtn.click();
        for(int i = 0;i<=10;i++) {
            studyMateLoginPage.btnForCreatingGroup.click();
            studyMateLoginPage.groupNameField.sendKeys(faker.name().name());
            studyMateLoginPage.groupCalendaryField.click();
            studyMateLoginPage.firstDayCalendar.click();
            studyMateLoginPage.descriptionBtn.sendKeys(faker.chuckNorris().fact());
            studyMateLoginPage.creatingGroupBtnAfterDescription.click();
        }
    }
    @Test
    public void deletingGroup(){
        StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();
        studyMateLoginPage.emailField.sendKeys(Config.getValue("studyMateEmail"));
        studyMateLoginPage.passwordField.sendKeys(Config.getValue("studyMatePassword"));
        studyMateLoginPage.loginBtn.click();
        ApplicationFlow.pause(2000);
        studyMateLoginPage.GroupsBtn.click();
        String cardNum = studyMateLoginPage.numbersOfProject.getText();
        StringBuilder numericDigits = new StringBuilder();
        for (int i = 0; i < cardNum.length(); i++) {
            char ch = cardNum.charAt(i);
            if (Character.isDigit(ch)) {
                numericDigits.append(ch);
            }
        }

        String str = numericDigits.toString();
        int number = Integer.parseInt(str);

        for(int i = 1;i<=number;i++) {
            studyMateLoginPage.threeDot.click();
            studyMateLoginPage.deleteGroupBtn.click();
            studyMateLoginPage.confirmDeleteGroup.click();
            ApplicationFlow.pause(500);
        }
        //ssert.assertEquals(studyMateLoginPage.numbersOfProject.getText(),1);
    }

}
