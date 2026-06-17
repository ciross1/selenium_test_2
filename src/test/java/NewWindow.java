import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

public class NewWindow extends BaseBeforeTestLocal{


    @Test
    void newWindowTest(){

        localDriver.get("https://demoqa.com/browser-windows");

        //Aktuales fenster merken:
        String handleFenster = localDriver.getWindowHandle();
        localDriver.findElement(By.id("windowButton")).click();


        WebDriverWait wait = new WebDriverWait(localDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for(String handel : localDriver.getWindowHandles()){
            if(!handel.equals(handleFenster)){
                localDriver.switchTo().window(handel);
                break;
            }


        }
       String text =  localDriver.findElement(By.id("sampleHeading")).getText();
        assertEquals(text, "This is a sample page");


    }
}
