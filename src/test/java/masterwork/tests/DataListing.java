package masterwork.tests;

import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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