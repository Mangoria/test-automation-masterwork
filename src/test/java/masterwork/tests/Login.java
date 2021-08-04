package masterwork.tests;


import java.util.concurrent.TimeUnit;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class Login {

  WebDriver driver;
  String mainSite = "http://test-automation-blog.greenfox.academy/";

  BlogMainSite objBlogMainSite;
  BlogLoginSite objBlogLoginSite;

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(mainSite);
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }

  @Test
  @DisplayName("Successful login test")
  public void successfulLogin(){
    objBlogMainSite = new BlogMainSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
    objBlogMainSite.clickOnLogin();
    objBlogLoginSite.fillTheUserName("TestAlma");
    objBlogLoginSite.fillThePassword("123456Alma");
    objBlogLoginSite.clickOnLogin();
    assertThat(driver.findElement(By.xpath("//*[@id=\"menu-item-72\"]/a"))).isNotNull();
  }

  @Test
  @DisplayName("Failed login test")
  public void failedLogin(){
    objBlogMainSite = new BlogMainSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
    objBlogMainSite.clickOnLogin();
    objBlogLoginSite.fillTheUserName("TestAlma");
    objBlogLoginSite.fillThePassword("123456alma");
    objBlogLoginSite.clickOnLogin();
    assertThat(driver.findElement(By.id("login_error"))).isNotNull();

  }
}

