import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class RegistrationFail {
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
  @DisplayName("Registration attempt without checkbox tick")
  void register() {
    driver.get(mainSite);
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//*[@id=\"menu-item-45\"]/a")).click();
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
    //driver.findElement(By.xpath("//*[@id=\"um_field_46_privacy_statement\"]/div[2]/label/span[1]/i")).click();
    driver.findElement(By.xpath("//*[@id=\"um-submit-btn\"]")).click();
    String expected = "Pivacy statement is required.";
    WebElement error = driver.findElement(By.xpath("//*[@id=\"um_field_46_privacy_statement\"]/div[3]"));
    String actual = error.getText();
    assertThat(expected).isEqualTo(actual);


  }

}
