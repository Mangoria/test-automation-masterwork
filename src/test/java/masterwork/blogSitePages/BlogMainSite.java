package masterwork.blogSitePages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogMainSite {

  WebDriver driver;
  By login = By.xpath("//*[@id=\"menu-item-44\"]/a");
  By register = By.xpath("//*[@id=\"menu-item-45\"]/a");
  By nextPageButton = By.className("older-posts");




  public BlogMainSite(WebDriver driver) {
    this.driver = driver;
  }

  public void clickOnRegister (){
    driver.findElement(register).click();
  }

  public void clickOnLogin (){
    driver.findElement(login).click();
  }

  public List<WebElement> commentTitleList(){
    return driver.findElements(By.xpath("//*[contains(@rel,'bookmark')]"));
  }

  public String commentTitle (Integer i){
    return commentTitleList().get(i).getText();
  }

  public boolean checkIfLastPage(){
    if(driver.findElement(By.className("older-posts")).isDisplayed()){
      System.out.println("Nem");
    return false;}
    else
    {
      System.out.println("Igen");
      return true; }
  }

  public void clickNextPage() {
    if (driver.findElement(nextPageButton).isDisplayed()) {
      System.out.println("Latom");
      driver.findElement(nextPageButton).click();
    }
  }


}
