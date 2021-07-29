import static org.assertj.core.api.Assertions.assertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Pagination {

  private WebDriver driver;
  String mainSite = "http://test-automation-blog.greenfox.academy/";

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();


  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }

  @Test
  void register() {
    driver.get(mainSite);
    driver.manage().window().maximize();
    String title = driver.getTitle();
    int number;
    if (title.contains("Page")){
      number = Integer.parseInt(title.replaceAll("\\D+",""));
    } else {
      number = 1;
    }
    System.out.println(number);
    int number2;
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/a")).click();
    title = driver.getTitle();
    if (title.contains("Page")){
      number2 = Integer.parseInt(title.replaceAll("\\D+",""));
    } else {
      number2 = 1;
    }
    System.out.println(number2);
    assertThat(number).isLessThan(number2);
  }

}
