package masterwork.tests;


import java.util.concurrent.TimeUnit;
import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class Registration {
  WebDriver driver;
  String mainSite = "http://test-automation-blog.greenfox.academy/";

  BlogMainSite objBlogMainSite;
  BlogRegistrationSite objBlogRegistrationSite;

  @BeforeAll
  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(mainSite);
  }

  @AfterEach
  void tearDown() { driver.quit(); }

  @Test
  @DisplayName("Successful Registration Test")
  public void registrationSuccessfully() {
      objBlogMainSite = new BlogMainSite(driver);
      objBlogMainSite.clickOnRegister();
      objBlogRegistrationSite = new BlogRegistrationSite(driver);
      objBlogRegistrationSite.fillTheUserName("TestAlma");
      objBlogRegistrationSite.fillTheFirstName("Jakab");
      objBlogRegistrationSite.fillTheLastName("Gipsz");
      objBlogRegistrationSite.fillTheEmail("test.gipszjakab@test.com");
      objBlogRegistrationSite.fillThePassword("123456Alma");
      objBlogRegistrationSite.clickOnPrivacyButton();
      objBlogRegistrationSite.clickOnRegister();
      assertThat(driver.getTitle().toLowerCase().contains("testalma"));
  }

  @Test
  @DisplayName("Failed Registration Test")
  public void registrationToFail() {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogMainSite.clickOnRegister();
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogRegistrationSite.fillTheUserName("TestAlma");
    objBlogRegistrationSite.fillTheFirstName("Jakab");
    objBlogRegistrationSite.fillTheLastName("Gipsz");
    objBlogRegistrationSite.fillTheEmail("test.gipszjakab@test.com");
    objBlogRegistrationSite.fillThePassword("123456Alma");
    objBlogRegistrationSite.clickOnRegister();
    assertThat(objBlogRegistrationSite.missedPrivacyButton()).isEqualTo("Pivacy statement is required.");
  }

}
