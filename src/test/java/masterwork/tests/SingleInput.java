package masterwork.tests;


import masterwork.blogSitePages.BlogCommentSite;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SingleInput extends BaseTest{

  BlogMainSite objBlogMainSite;
  BlogCommentSite objBlogCommentSite;


  @Test
  @DisplayName("Input Single Data")
  public void Input() {
      objBlogMainSite = new BlogMainSite(driver);
      objBlogCommentSite = new BlogCommentSite(driver);
      String commentText = "TestCommentText- "+ java.time.LocalDate.now()
          + " " + java.time.LocalTime.now();
      objBlogMainSite.openBlogPost("Post 9");
      objBlogCommentSite.fillCommentField(commentText);
      objBlogCommentSite.fillTheNameField("SeleniumAlma");
      objBlogCommentSite.fillTheEmailField("test@testelek.hu");
      objBlogCommentSite.fillTheWebsiteField("testelek.hu");
      objBlogCommentSite.submit();
      String postComment = objBlogCommentSite.getPostedComment();
      assertThat(postComment).isEqualTo(commentText);
  }

}
