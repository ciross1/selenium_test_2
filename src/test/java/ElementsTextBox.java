import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementsTextBox  extends  BaseBeforeTest{

    @Test
    void textBoxSubmit(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Max mendez");
        driver.findElement(By.id("userEmail")).sendKeys("oricsantamarina@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("madrid");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();



        // Jetzt prüfen wir ob das Ergebnis stimmt
        // assertTrue: prüft ob etwas wahr ist, zum Beispiel ob ein Element sichtbar ist.
        assertTrue(driver.findElement(By.id("output")).getText().contains("Max mendez"));
        assertTrue(driver.findElement(By.id("output")).getText().contains("oricsantamarina@gmail.com"));
        assertTrue(driver.findElement(By.id("output")).getText().contains("madrid"));

        // assertEquals: prüft ob zwei Werte gleich sind, zum Beispiel ob der
        // angezeigte Name der gleiche ist den du eingegeben hast.
        // assertEquals("Max mendez", driver.findElement(By.id("name")).getText());



    }
}
