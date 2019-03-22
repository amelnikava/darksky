package framework;

import org.openqa.selenium.By;

public class AmazonNewCustomewPage extends BasePage {

  private By nameField = By.id("ap_customer_name");
  private By emailField = By.id("ap_email");
  private By passwordField = By.id("ap_password");
  private By reenterPasswordField = By.id("ap_password_check");
  private By createAccountButton = By.xpath("//input[@type='submit']");

  public void enterName (String name){
    setValue(nameField, name);
  }

  public void enterEmail (String email){
    setValue(emailField, email);
  }
  public void enterPassword(String password){
    setValue(passwordField,password);
  }
  public void reenterPassword (String password){
    setValue(reenterPasswordField, password);
  }
  public void clickOnCreateAccountButton(){
    clickOn(createAccountButton);
  }
}
