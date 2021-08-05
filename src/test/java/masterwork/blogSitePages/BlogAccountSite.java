package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogAccountSite {
  WebDriver driver;
  By firstNameField = By.id("first_name");
  By submitButton = By.id("um_account_submit_general");
  By deleteButton = By.xpath("//*[@id=\"content\"]/article/div/div/div/form/div[2]/ul/li[4]/a/span[3]");
  By passWordField = By.id("single_user_password");
  By finalDeleteButton = By.id("um_account_submit_delete");

  public BlogAccountSite(WebDriver driver){this.driver = driver; }

  public void submit(){
    driver.findElement(submitButton).click();
  }

  public void updateFirstName (String newUserName) {
    driver.findElement(firstNameField).clear();
    driver.findElement(firstNameField).sendKeys(newUserName);
  }

  public String getFirstName(){
    return driver.findElement(firstNameField).getAttribute("value");
  }

  public void startDelete(){
    driver.findElement(deleteButton).click();
  }

  public void fillThePassWord (String input){
    driver.findElement(passWordField).sendKeys(input);
  }

  public void finalDelete(){
    driver.findElement(finalDeleteButton).click();
  }


}
