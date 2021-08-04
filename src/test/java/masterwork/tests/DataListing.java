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

public class DataListing extends BaseTest{

  BlogMainSite objBlogMainSite;

  @Test
  @DisplayName("Opening PS test")
  public void dataListing(){
    objBlogMainSite = new BlogMainSite(driver);
    objBlogMainSite.commentTitleList();
    for (int i = 0; i < objBlogMainSite.commentTitleList().size(); i++) {
      System.out.println(objBlogMainSite.commentTitle(i));
      assertThat(objBlogMainSite.commentTitleList().get(i).getText()).
          isEqualTo(objBlogMainSite.commentTitle(i));
    }
  }
}