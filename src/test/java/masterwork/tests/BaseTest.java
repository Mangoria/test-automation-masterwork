package masterwork.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


@TestInstance(Lifecycle.PER_CLASS)
  public class BaseTest {

  WebDriver driver;
  WebDriverWait wait;
  String mainSite = "http://test-automation-blog.greenfox.academy/";


  @BeforeAll
  public void setupOnce() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void setup(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver,3);
    driver.manage().window().maximize();
    driver.get(mainSite);
  }
  @AfterEach
  public void tearDown(){
    driver.quit();
  }


}

