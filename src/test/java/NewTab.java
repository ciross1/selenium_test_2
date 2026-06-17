import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class NewTab extends BaseBeforeTestLocal {



    @Test
    void testNewTab(){

        localDriver.get("https://demoqa.com/browser-windows");


        //Aktuales fenster merken:


        // Aktuelles Fenster merken
        String originalWindow = localDriver.getWindowHandle();


        localDriver.findElement(By.id("tabButton")).click();

        //Warten bis neuer Tab offen ist:
        WebDriverWait wait = new WebDriverWait(localDriver, Duration.ofSeconds(5));

        // warte bis 2 tabs gibt
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //zum neuen Tab wechseln:
        for(String handel : localDriver.getWindowHandles()){
            if(!handel.equals(originalWindow)){
                localDriver.switchTo().window(handel);
            }
        }

        String  text =  localDriver.findElement(By.id("sampleHeading")).getText();

        assertEquals(text, "This is a sample page");

    }


}
