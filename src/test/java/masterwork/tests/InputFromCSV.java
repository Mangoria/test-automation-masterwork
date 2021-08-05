package masterwork.tests;


import masterwork.blogSitePages.BlogCommentSite;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.*;

public class InputFromCSV extends BaseTest{

  BlogMainSite objBlogMainSite;
  BlogCommentSite objBlogCommentSite;


  @ParameterizedTest
  @DisplayName("Input Single Data")
  @CsvFileSource(resources = "./../../simple.csv",numLinesToSkip = 1)
  public void Input(String comment, String name, String email, String website)
      throws InterruptedException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogCommentSite = new BlogCommentSite(driver);
    String commentText =  comment + " " + java.time.LocalDate.now()
        + " " + java.time.LocalTime.now();
    objBlogMainSite.openBlogPost("Post 11");
    objBlogCommentSite.fillCommentField(commentText);
    objBlogCommentSite.fillTheNameField(name);
    objBlogCommentSite.fillTheEmailField(email);
    objBlogCommentSite.fillTheWebsiteField(website);
    objBlogCommentSite.submit();
    String postComment = objBlogCommentSite.getPostedComment();
    assertThat(postComment).isEqualTo(commentText);
    Thread.sleep(10000);
  }

}
