package masterwork.tests;

import masterwork.blogSitePages.BlogAccountSite;
import masterwork.blogSitePages.BlogLogOutSite;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LogOut extends BaseTest{
  BlogMainSite objBlogMainSite;
  BlogAccountSite objBlogAccountSite;
  BlogLoginSite objBlogLoginSite;
  BlogRegistrationSite objBlogRegistrationSite;
  BlogLogOutSite objBlogLogOutSite;

  @Test
  @DisplayName("Creating an account and the logging out.")
  public void updateDetail() throws InterruptedException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogAccountSite = new BlogAccountSite(driver);
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
    objBlogLogOutSite = new BlogLogOutSite(driver);

    objBlogMainSite.clickOnRegister();

    String userName = "ToBeDeleted";
    String passWord = "123456Alma";
    String firstName = "Janos";
    String lastName = "Benedek";
    String email = "jbtest@hali.hu";

    objBlogRegistrationSite.fillTheUserName(userName);
    objBlogRegistrationSite.fillTheFirstName(firstName);
    objBlogRegistrationSite.fillTheLastName(lastName);
    objBlogRegistrationSite.fillThePassword(passWord);
    objBlogRegistrationSite.fillTheEmail(email);
    objBlogRegistrationSite.clickOnPrivacyButton();
    objBlogRegistrationSite.clickOnRegister();

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnAccount();
    Thread.sleep(400);
    assertThat(objBlogAccountSite.getFirstName()).isEqualTo(firstName);

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnLogOut();
    objBlogLogOutSite.clickOnConfirm();

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnAccount();

    assertThat(driver.getCurrentUrl().contains("login")).isTrue();

    objBlogMainSite.clickOnLogin();

    Thread.sleep(400);
    objBlogLoginSite.fillTheUserName(userName);
    objBlogLoginSite.fillThePassword(passWord);
    objBlogLoginSite.clickOnLogin();

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnAccount();
    Thread.sleep(400);
    assertThat(objBlogAccountSite.getFirstName()).isEqualTo(firstName);
    objBlogAccountSite.startDelete();
    objBlogAccountSite.fillThePassWord(passWord);
    objBlogAccountSite.finalDelete();

  }
}
