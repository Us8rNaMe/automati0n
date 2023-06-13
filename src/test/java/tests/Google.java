package tests;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Google {
    @Test
    public void search(){
        Faker faker = new Faker();
        String testData = faker.lorem().word();
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.name("q")).sendKeys(testData+ Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(testData), "Title failed");
        Driver.quit();
    }
}