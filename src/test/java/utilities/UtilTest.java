package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.TreeMap;

public class UtilTest {
    public static void main(String[] args) throws InterruptedException {
        //Driver.getDriver().get("https://chrome.google.com/webstore/category/extensions?hl=en");
        System.out.println(Driver.getDriver().getTitle());

        ApplicationFlow.findElement(By.id("APjFqb")).sendKeys("potato"+Keys.ENTER);

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(800);

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(800);

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(800);

        ApplicationFlow.print(Driver.getDriver().getTitle());

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(-800);

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(-800);

        ApplicationFlow.pause(500);
        ApplicationFlow.scroll(-800);

        //ApplicationFlow.findElement(By.id("searchbox-input")).sendKeys("translator"+ Keys.ENTER);

        Thread.sleep(5000);
        Driver.getDriver().quit();

    }
}
