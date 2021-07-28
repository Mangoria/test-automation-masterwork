import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFail {


  private WebDriver driver;
  String mainSite = "http://test-automation-blog.greenfox.academy/";

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();


  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }

  @Test
  void login() {
    driver.get(mainSite);
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//*[@id=\"menu-item-44\"]/a")).click();
    WebElement login = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
    login.sendKeys("Seleniumalmas");
    WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
    password.sendKeys("123456Alma");
    driver.findElement(
        By.xpath("//*[@id=\"wp-submit\"]")).click();
    String expected = "Unknown username. Check again or try your email address.";
    WebElement error = driver.findElement(By.xpath("//*[@id=\"login_error\"]"));
    String actual = error.getText();
    assertThat(expected).isEqualTo(actual);



  }

}


