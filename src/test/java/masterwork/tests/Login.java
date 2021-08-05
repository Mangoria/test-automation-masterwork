package masterwork.tests;

import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.*;

public class Login extends BaseTest {

  BlogMainSite objBlogMainSite;
  BlogLoginSite objBlogLoginSite;

  @Test
  @DisplayName("Successful login test")
  public void successfulLogin() throws InterruptedException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
    objBlogMainSite.clickOnLogin();
    Thread.sleep(200);
    objBlogLoginSite.fillTheUserName("TestAlma");
    Thread.sleep(200);
    objBlogLoginSite.fillThePassword("123456Alma");
    objBlogLoginSite.clickOnLogin();
    assertThat(driver.findElement(By.xpath("//*[@id=\"menu-item-72\"]/a")).isDisplayed()).isTrue();
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
    assertThat(driver.findElement(By.id("login_error")).getText()).contains("Error");

  }
}

