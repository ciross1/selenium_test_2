import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAuth extends BaseBeforeTestLocal{


    @Test
    void testLogin(){
        localDriver.get("https://the-internet.herokuapp.com/login");

        WebElement userElement = localDriver.findElement(By.id("username"));
        WebElement passwordElement = localDriver.findElement(By.id("password"));
        WebElement clickButton = localDriver.findElement(By.cssSelector("button[type='submit']"));

        userElement.sendKeys("tomsmith");
        passwordElement.sendKeys("SuperSecretPassword!");
        clickButton.click();

        // Sehr wichtig warte bis url kommt
        WebDriverWait wait = new WebDriverWait(localDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("secure"));

    assertTrue(localDriver.getCurrentUrl().contains("secure"));


    }
}
