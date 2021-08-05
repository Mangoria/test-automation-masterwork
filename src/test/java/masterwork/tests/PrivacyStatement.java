package masterwork.tests;

import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.*;

public class PrivacyStatement extends BaseTest {

  BlogMainSite objBlogMainSite;
  BlogRegistrationSite objBlogRegistrationSite;

  @Test
  @DisplayName("Opening PS test")
  public void checkPrivacyStatement(){
    objBlogMainSite = new BlogMainSite(driver);
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogMainSite.clickOnRegister();
    objBlogRegistrationSite.checkPrivacyStatement();
    assertThat(driver.getTitle()).isEqualTo("Google");
    driver.navigate().back();
    objBlogRegistrationSite.clickOnPrivacyButton();
    assertThat(driver.findElement(By.className("active"))).isNotNull();

  }


}