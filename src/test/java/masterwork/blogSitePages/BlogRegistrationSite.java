package masterwork.blogSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogRegistrationSite {

  WebDriver driver;
  By userNameField = By.id("user_login-46");
  By firstNameField = By.id("first_name-46");
  By lastNameField = By.id("last_name-46");
  By emailField = By.id("user_email-46");
  By passwordField = By.id("user_password-46");
  By confirmPasswordField = By.id("confirm_user_password-46");
  By privacyButton = By.xpath("//*[@id=\"um_field_46_privacy_statement\"]/div[2]/label/span[1]/i");
  By privacyStatementLink = By.xpath("//*[@id=\"content\"]/article/div/div/div/form/div[1]/div/div[8]/a");
  By registerButton = By.xpath("//*[@id=\"um-submit-btn\"]");
  By errorPrivacyButton = By.xpath("//*[@id=\"um_field_46_privacy_statement\"]/div[3]");



  public BlogRegistrationSite(WebDriver driver) {
    this.driver = driver;
  }

  public void infoCheck() {
    String title11 = driver.findElement(By.xpath("//*[@id=\"post-38\"]/div/header/h2/a")).getText();
    System.out.println(title11);
  }

  public void fillTheUserName(String userName){
    driver.findElement(userNameField).sendKeys(userName);
  }

  public void fillTheFirstName (String firstName){
    driver.findElement(firstNameField).sendKeys(firstName);
  }

  public void fillTheLastName (String lastName){
    driver.findElement(lastNameField).sendKeys(lastName);
  }

  public void fillTheEmail (String email){
    driver.findElement(emailField).sendKeys(email);
  }

  public void fillThePassword (String password){
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(confirmPasswordField).sendKeys(password);
  }

  public void clickOnPrivacyButton (){
    driver.findElement(privacyButton).click();
  }

  public void checkPrivacyStatement(){
    driver.findElement(privacyStatementLink).click();
  }

  public void clickOnRegister (){
    driver.findElement(registerButton).click();
  }

  public String missedPrivacyButton (){
    return driver.findElement(errorPrivacyButton).getText();
  }




}
