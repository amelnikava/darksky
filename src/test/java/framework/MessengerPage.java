package framework;

import org.openqa.selenium.By;

public class MessengerPage extends BasePage {

  private By emailField = By.linkText("email");
  private By passwordField = By.linkText("pass");
  private By signUpButton = By.linkText("loginbutton");

  public void enterEmail (String email){
    setValue(emailField, email);
  }
 public void enterPassword(String password){
    setValue(passwordField,password);
 }

 public void clickOnSignUpButton(){
    clickOn(signUpButton);
 }
}
