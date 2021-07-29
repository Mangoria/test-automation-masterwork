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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DataInput{


  private WebDriver driver;
  String mainSite = "http://test-automation-blog.greenfox.academy/";

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();


  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }

  @Test
  void dataInput() {
    WebDriverWait wait = new WebDriverWait(driver,10);
    String input = "Tesztszoveg2";
    driver.get(mainSite);
    driver.manage().window().maximize();
    String title = driver.getTitle();
    System.out.println(title);
    driver.findElement(By.xpath("//*[@id=\"menu-item-44\"]/a")).click();
    WebElement login = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
    login.sendKeys("Seleniumalma");
    WebElement password = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
    password.sendKeys("123456Alma");
    driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
    //driver.navigate().back();
    wait.until(ExpectedConditions.titleIs(title));
    driver.findElement(By.xpath("//*[@id=\"post-29\"]/div/header/h2/a")).click();
    WebElement comment = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
    comment.sendKeys(input);
    /*WebElement name = driver.findElement(By.xpath("//*[@id=\"author\"]"));
    name.sendKeys("Nevem");
    WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
    email.sendKeys("alma@alma.hu");*/
    driver.findElement(By.xpath("//*[@id=\"comment-submit\"]")).click();
    WebElement commentText = driver.findElement(By.xpath("//*[@id=\"comment-11\"]/article/div/div[3]/div/p"));
    assertThat(commentText.getText()).isEqualTo(input);








  }

}


