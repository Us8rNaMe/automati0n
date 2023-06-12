package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class OrangeLoginTest {

    private OrangeLoginPage orangeLoginPage = new OrangeLoginPage();
    @Before
    public void before(){
        Driver.getDriver();
        System.out.println("Browser is opened!");
    }

    @Test
    public void happyLoginMyWay(){
        Driver.getDriver().get(Config.getValue("boringUrl"));
        Driver.getDriver().findElement(By.xpath("(//input)[2]")).sendKeys(Config.getValue("username"));
        Driver.getDriver().findElement(By.xpath("(//input)[3]")).sendKeys(Config.getValue("userPassword")+ Keys.ENTER);
        ApplicationFlow.pause(500);
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void happyLogin(){
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        WebElement usernameInput = orangeLoginPage.usernameField;
        usernameInput.sendKeys(Config.getValue("username"));
        WebElement passwordInput = orangeLoginPage.passwordField;
        passwordInput.sendKeys(Config.getValue("userPassword"));
        orangeLoginPage.loginButton.click();
        ApplicationFlow.pause(500);
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void LogOut() {
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        WebElement usernameInput = orangeLoginPage.usernameField;
        usernameInput.sendKeys(Config.getValue("username"));
        WebElement passwordInput = orangeLoginPage.passwordField;
        passwordInput.sendKeys(Config.getValue("userPassword"));
        orangeLoginPage.loginButton.click();
        orangeLoginPage.dropDownUser.click();
        orangeLoginPage.logOutBtn.click();
        ApplicationFlow.pause(500);
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void noUsername() {
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        WebElement passwordInput = orangeLoginPage.passwordField;
        passwordInput.sendKeys(Config.getValue("userPassword"));
        orangeLoginPage.loginButton.click();
        ApplicationFlow.pause(500);
        Assert.assertTrue(orangeLoginPage.errorUsernameLogPage.isDisplayed());
    }

    @Test
    public void noPassword(){
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        WebElement usernameInput = orangeLoginPage.usernameField;
        usernameInput.sendKeys(Config.getValue("username"));
        orangeLoginPage.loginButton.click();
        ApplicationFlow.pause(500);
        Assert.assertTrue(orangeLoginPage.errorPasswordLogPage.isDisplayed());
    }

    @Test
    public void noPNoU(){
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        orangeLoginPage.loginButton.click();
        ApplicationFlow.pause(500);
        Assert.assertTrue(orangeLoginPage.errorPasswordLogPage.isDisplayed());
        Assert.assertTrue(orangeLoginPage.errorPasswordLogPage.isDisplayed());
    }

    @Test
    public void menuBar() {
        Driver.getDriver().get(Config.getValue("boringUrl"));
        ApplicationFlow.pause(500);
        WebElement usernameInput = orangeLoginPage.usernameField;
        usernameInput.sendKeys(Config.getValue("username"));
        WebElement passwordInput = orangeLoginPage.passwordField;
        passwordInput.sendKeys(Config.getValue("userPassword"));
        orangeLoginPage.loginButton.click();
        ApplicationFlow.pause(500);
        for (int i = 1; i <= 10; i++) {
            WebElement menuBtn = Driver.getDriver().findElement(By.xpath("//li["+i+"]"));
            menuBtn.click();
            ApplicationFlow.pause(1500);
            System.out.println("Currently Url: "+Driver.getDriver().getCurrentUrl()+"\n");
        }
        Driver.getDriver().findElement(By.xpath("(//button)[1]")).click();
        ApplicationFlow.pause(1500);
        Driver.getDriver().findElement(By.xpath("(//li)[11]")).click();
        System.out.println("Currently Url: "+Driver.getDriver().getCurrentUrl()+"\n");
        ApplicationFlow.pause(1500);
    }

    @After
    public void cleanUp(){
        Driver.quit();
    }

}