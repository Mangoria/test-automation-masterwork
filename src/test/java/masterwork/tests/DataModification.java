package masterwork.tests;

import masterwork.blogSitePages.BlogAccountSite;
import masterwork.blogSitePages.BlogLoginSite;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.*;

public class DataModification extends BaseTest{

  BlogMainSite objBlogMainSite;
  BlogAccountSite objBlogAccountSite;
  BlogLoginSite objBlogLoginSite;

  @Test
  @DisplayName("Changing one parameter")
  public void updateDetail() throws InterruptedException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogLoginSite = new BlogLoginSite(driver);
    objBlogAccountSite = new BlogAccountSite(driver);

    objBlogMainSite.clickOnLogin();
    String userName = "SeleniumAlma";
    objBlogLoginSite.fillTheUserName(userName);
    String passWord = "123456Alma";
    objBlogLoginSite.fillThePassword(passWord);
    objBlogLoginSite.clickOnLogin();
    Thread.sleep(500);
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"menu-item-85\"]/a"))));
    objBlogMainSite.clickOnAccount();
    String originalFirstName = objBlogAccountSite.getFirstName();
    objBlogAccountSite.updateFirstName("Selen " + java.time.LocalTime.now() );
    objBlogAccountSite.submit();
    assertThat(driver.findElement(By.xpath("//*[@id=\"content\"]/article/div/div/div/form/div[3]/p"))).isNotNull();
    assertThat(objBlogAccountSite.getFirstName()).isNotEqualTo(originalFirstName);



  }

}
