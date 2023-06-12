package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ApplicationFlow {


    //----------------------------------------------------------------------------//
    public static void pause(int millisecond) {
        try{
            Thread.sleep(millisecond);
        }catch (InterruptedException e){
            System.out.println("Interrupted happened");
        }
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//
    public static void scroll(int y){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,y).perform();
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//
    public static void switchToSecondWindow(){
        String currentID = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for(String id: handles){
            if(!id.equals(currentID)){
                Driver.getDriver().switchTo().window(id);
                break;
            }
        }
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//
    public static void print(String str){
        System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
        System.out.println(str);
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//
    public static void navigateToURL(String url) {
        Driver.getDriver().get(url);
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//
    public static WebElement findElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }
    //----------------------------------------------------------------------------//


    //----------------------------------------------------------------------------//

    //----------------------------------------------------------------------------//
}