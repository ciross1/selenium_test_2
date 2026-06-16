import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseBeforeTest {

        WebDriver driver;




        @BeforeEach
        public void setUp(){

            // lädt und konfiguriert automatisch den passenden ChromeDriver
            // für deine installierte Chrome-Version.
            WebDriverManager.chromedriver().setup();


            /*
            --headless
Chrome braucht normalerweise einen Bildschirm um zu laufen.
Auf einem Server gibt es keinen. Headless bedeutet, Chrome läuft im
 Hintergrund ohne sichtbares Fenster.

--no-sandbox
Chrome hat eine Sicherheitsschicht namens Sandbox,
die auf Linux-Servern oft Probleme verursacht weil der Prozess
keine ausreichenden Rechte hat. Diese Option deaktiviert das.

--disable-dev-shm-usage
GitHub Actions hat nur wenig gemeinsamen Arbeitsspeicher (shared memory).
Chrome nutzt diesen standardmäßig stark und kann abstürzen. Diese Option sagt Chrome,
 er soll stattdessen normalen Speicher verwenden.*/
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");  //Wichtig sonst der server kennt die Grösse des Fensters nicht
            driver = new ChromeDriver(options);
        }


        @AfterEach
        public void tearDown(){
            driver.quit();
        }

    }



    /*alles was unter
    src/test/java liegt und mit @Test annotiert ist ,wird automatisch ausgeführt.
Maven sucht bei mvn test automatisch alle Klassen in
diesem Ordner und führt jede Methodemit @Test aus.
 Du musst nichts extra konfigurieren, solange die Testklassen dort liegen.*/
