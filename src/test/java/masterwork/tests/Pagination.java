package masterwork.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class Pagination extends BaseTest{

  BlogMainSite objBlogMainSite;

  @Test
  @DisplayName("Listing more than one page of data")
  public void extraDataListing(){
    objBlogMainSite = new BlogMainSite(driver);
    List<WebElement> baseList = objBlogMainSite.commentTitleList();
    while (!objBlogMainSite.checkIfLastPage()) {
      objBlogMainSite.clickNextPage();
      System.out.println("Clicked");
      for (int i = 0; i < baseList.size(); i++) {
        System.out.println(baseList.get(i).getText());
      }
      baseList = Stream.concat(baseList.stream(),
          objBlogMainSite.commentTitleList().stream()).collect(Collectors.toList());
    }
    System.out.println("Kiugrottam");
    for (int i = 1; i < baseList.size(); i++) {
      System.out.println(baseList.get(i).getText());
    }

  }

}
