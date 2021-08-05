package masterwork.tests;

import masterwork.blogSitePages.BlogAccountSite;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import masterwork.blogSitePages.BlogRegistrationSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.*;

public class DeleteData extends BaseTest{
  BlogMainSite objBlogMainSite;
  BlogAccountSite objBlogAccountSite;
  BlogLoginSite objBlogLoginSite;
  BlogRegistrationSite objBlogRegistrationSite;

  @Test
  @DisplayName("Delete Value")
  public void updateDetail() {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogAccountSite = new BlogAccountSite(driver);
    objBlogRegistrationSite = new BlogRegistrationSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
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
    assertThat(objBlogAccountSite.getFirstName()).isEqualTo(firstName);
    objBlogAccountSite.startDelete();
    objBlogAccountSite.fillThePassWord(passWord);
    objBlogAccountSite.finalDelete();

    driver.navigate().to(mainSite);

    objBlogMainSite.clickOnLogin();

    objBlogLoginSite.fillTheUserName(userName);
    objBlogLoginSite.fillThePassword(passWord);
    objBlogLoginSite.clickOnLogin();

    assertThat(driver.findElement(By.id("login_error")).getText()).contains("Unknown username");

  }
}
