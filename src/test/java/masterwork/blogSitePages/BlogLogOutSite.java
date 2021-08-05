package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogLogOutSite {

  WebDriver driver;
  By logoutConfirm = By.xpath("//*[@id=\"error-page\"]/div/p[2]/a");


  public BlogLogOutSite(WebDriver driver) {this.driver = driver; }


  public void clickOnConfirm(){
    driver.findElement(logoutConfirm).click();
  }
}
