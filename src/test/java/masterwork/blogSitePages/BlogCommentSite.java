package masterwork.blogSitePages;

import org.openqa.selenium.By;

public class BlogCommentSite {
  By title = By.xpath("//*[@id=\"main\"]/header/div/h1");
  By comment = By.id("comment");
  By name = By.id("author");
  By email = By.id("email");
  By webSite = By.id("url");

}
