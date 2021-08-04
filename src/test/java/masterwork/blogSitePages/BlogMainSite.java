package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogMainSite {

  WebDriver driver;
  By login = By.xpath("//*[@id=\"menu-item-44\"]/a");
  By register = By.xpath("//*[@id=\"menu-item-45\"]/a");
  By title = By.xpath("//*[@id=\"main\"]/header/div/h1");
  By comment = By.id("comment");
  By name = By.id("author");
  By email = By.id("email");
  By webSite = By.id("url");


  public BlogMainSite(WebDriver driver) {
    this.driver = driver;
  }

  public void infoCheck() {
    String title11 = driver.findElement(By.xpath("//*[@id=\"post-38\"]/div/header/h2/a")).getText();
    System.out.println(title11);
  }

  public void clickOnRegister (){
    driver.findElement(register).click();
  }

  public void clickOnLogin (){
    driver.findElement(login).click();
  }


}
