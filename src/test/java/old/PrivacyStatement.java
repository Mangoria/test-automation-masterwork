package old;

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


public class PrivacyStatement {

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

    driver.findElement(By.xpath("//*[@id=\"menu-item-45\"]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/article/div/div/div/form/div[1]/div/div[8]/a")).click();
    driver.navigate().back();
    WebElement login = driver.findElement(By.xpath("//*[@id=\"user_login-46\"]"));
    login.sendKeys("Seleniumalma");
    WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name-46\"]"));
    firstName.sendKeys("Selenium");
    WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name-46\"]"));
    lastName.sendKeys("Alma");
    WebElement email = driver.findElement(By.xpath("//*[@id=\"user_email-46\"]"));
    email.sendKeys("mangoria+alma@gmail.com");
    WebElement password1 = driver.findElement(By.xpath("//*[@id=\"user_password-46\"]"));
    password1.sendKeys("123456Alma");
    WebElement password2 = driver.findElement(By.xpath("//*[@id=\"confirm_user_password-46\"]"));
    password2.sendKeys("123456Alma");
    driver.findElement(
        By.xpath("//*[@id=\"um_field_46_privacy_statement\"]/div[2]/label/span[1]/i")).click();
    driver.findElement(By.xpath("//*[@id=\"um-submit-btn\"]")).click();


  }

}
