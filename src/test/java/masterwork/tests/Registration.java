package masterwork.tests;

import java.util.Locale;
import masterwork.blogSitePages.BlogAccountSite;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Registration extends BaseTest {

  BlogMainSite objBlogMainSite;
  BlogAccountSite objBlogAccountSite;
  BlogLoginSite objBlogLoginSite;
  BlogRegistrationSite objBlogRegistrationSite;

  @Test
  @DisplayName("Successful Registration Test")
  public void registrationSuccessfully() throws InterruptedException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogAccountSite = new BlogAccountSite(driver);
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);

    String userName = "ToBeDeleted";
    String passWord = "123456Alma";
    String firstName = "Janos";
    String lastName = "Benedek";
    String email = "jbtest@hali.hu";

    objBlogMainSite.clickOnRegister();

    objBlogRegistrationSite.fillTheUserName(userName);
    objBlogRegistrationSite.fillTheFirstName(firstName);
    objBlogRegistrationSite.fillTheLastName(lastName);
    objBlogRegistrationSite.fillThePassword(passWord);
    objBlogRegistrationSite.fillTheEmail(email);
    objBlogRegistrationSite.clickOnPrivacyButton();
    objBlogRegistrationSite.clickOnRegister();
    Thread.sleep(400);
    assertThat(driver.getCurrentUrl().contains(userName.toLowerCase())).isTrue();

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnAccount();
    assertThat(objBlogAccountSite.getFirstName()).isEqualTo(firstName);
    objBlogAccountSite.startDelete();
    objBlogAccountSite.fillThePassWord(passWord);
    objBlogAccountSite.finalDelete();

  }

  @Test
  @DisplayName("Failed Registration Test")
  public void registrationToFail() {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogAccountSite = new BlogAccountSite(driver);
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);

    String userName = "ToBeDeleted";
    String passWord = "123456Alma";
    String firstName = "Janos";
    String lastName = "Benedek";
    String email = "jbtest@hali.hu";

    objBlogMainSite.clickOnRegister();
    objBlogRegistrationSite.fillTheUserName(userName);
    objBlogRegistrationSite.fillTheFirstName(firstName);
    objBlogRegistrationSite.fillTheLastName(lastName);
    objBlogRegistrationSite.fillThePassword(passWord);
    objBlogRegistrationSite.fillTheEmail(email);
    objBlogRegistrationSite.clickOnRegister();
    assertThat(objBlogRegistrationSite.missedPrivacyButton()).isEqualTo("Pivacy statement is required.");

  }

}
