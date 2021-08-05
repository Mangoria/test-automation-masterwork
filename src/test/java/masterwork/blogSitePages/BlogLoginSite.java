package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogLoginSite {

  WebDriver driver;
  By userNameField = By.id("user_login");
  By passwordField = By.id("user_pass");
  By loginButton = By.id("wp-submit");


  public BlogLoginSite(WebDriver driver) {
    this.driver = driver;
  }

  public void fillTheUserName (String userName){
    driver.findElement(userNameField).sendKeys(userName);
  }

  public void fillThePassword (String password){
    driver.findElement(passwordField).sendKeys(password);
  }

  public void clickOnLogin (){
    driver.findElement(loginButton).click();
  }



}
