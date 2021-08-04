package masterwork.tests;

import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Registration extends BaseTest {

  BlogMainSite objBlogMainSite;
  BlogRegistrationSite objBlogRegistrationSite;

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
