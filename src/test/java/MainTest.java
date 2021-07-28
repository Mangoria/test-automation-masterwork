import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainTest {

  private WebDriver driver;

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();
  }



  @BeforeEach
  void setup(){
    driver = new ChromeDriver();

  }

  @Test
  void openGoogle() {

  }

}
