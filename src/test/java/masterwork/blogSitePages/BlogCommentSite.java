package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BlogCommentSite {
  WebDriver driver;
  By title = By.xpath("//*[@id=\"main\"]/header/div/h2");
  By commentField = By.id("comment");
  By nameField = By.id("author");
  By emailField = By.id("email");
  By webSiteField = By.id("url");
  By submitButton = By.id("comment-submit");




  public BlogCommentSite(WebDriver driver){this.driver = driver; }

  public void fillCommentField(String input){
    driver.findElement(commentField).sendKeys(input);
  }

  public void fillTheNameField(String input){
    driver.findElement(nameField).sendKeys(input);
  }

  public void fillTheEmailField(String input){
    driver.findElement(emailField).sendKeys(input);
  }

  public void fillTheWebsiteField(String input){
    driver.findElement(webSiteField).sendKeys(input);
  }

  public void submit(){
    driver.findElement(submitButton).click();
  }

  public String url(){
    return driver.getCurrentUrl();
  }

  public String getCommentNumberFromUrl(String url){
    return url.substring(url.length() - 3);
  }

  public String getPostedComment(){
    String number = getCommentNumberFromUrl(url());
    return driver.findElement(By.xpath("//*[@id=\"comment-"+number+"\"]/article/div/div[3]/div/p")).getText();
  }




}
