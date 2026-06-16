import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class GoogleTest extends BaseBeforeTest {


    @Test
    void googleTitleTest(){
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assertions.assertEquals("Google", title);
    }











}
