package masterwork.tests;

import java.util.List;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

public class Pagination extends BaseTest{

  BlogMainSite objBlogMainSite;

  @Test
  @DisplayName("Listing more than one page of data")
  public void extraDataListing() {
    objBlogMainSite = new BlogMainSite(driver);
    String pageOneTitle = objBlogMainSite.getTitleOfCurrentSite();
    List<WebElement> baseList = objBlogMainSite.commentTitleList();
    for (WebElement webElement : baseList) {
      System.out.println(webElement.getText());
    }
    while (!objBlogMainSite.checkIfLastPage()) {
      objBlogMainSite.clickNextPage();
      baseList = objBlogMainSite.commentTitleList();
      for (WebElement webElement : baseList) {
        System.out.println(webElement.getText());
      }
      String currentPageTitle = objBlogMainSite.getTitleOfCurrentSite();
      assertThat(pageOneTitle).isNotEqualTo(currentPageTitle);
    }
  }
}
