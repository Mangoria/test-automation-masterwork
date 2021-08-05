package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogAccountSite {
  WebDriver driver;
  By userNameField = By.id("user_login");
  By firstNameField = By.id("first_name");
  By lastNameField = By.id("last_name");
  By emailField = By.id("user_email");
  By submitButton = By.id("um_account_submit_general");

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


}
