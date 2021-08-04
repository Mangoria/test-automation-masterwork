package masterwork.tests;


import java.util.concurrent.TimeUnit;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
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

public class Login extends BaseTest {

  BlogMainSite objBlogMainSite;
  BlogLoginSite objBlogLoginSite;

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

