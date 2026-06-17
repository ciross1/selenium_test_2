import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseBeforeTestLocal {

    WebDriver localDriver;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        localDriver = new ChromeDriver();
    }


    @AfterEach
    public void  tearDown(){
        localDriver.quit();
    }
}
