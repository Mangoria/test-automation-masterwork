package old;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataListing {

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
  void dataListing() {
    driver.get(mainSite);
    driver.manage().window().maximize();
    List<WebElement> elementName = driver.findElements(By.xpath("//*[contains(@rel,'bookmark')]"));
    WebElement compareValue = driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/header/h2/a"));
    for (WebElement webElement : elementName) {
      System.out.println(webElement.getText());
    }

    assertThat(elementName.get(9).getText()).isEqualTo(compareValue.getText());



  }

}
