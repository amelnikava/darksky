package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.MessengerLoginPage;
import framework.MessengerPage;
import org.testng.Assert;

public class MessengerSD {

  private HomePage homePage = new HomePage();
  private MessengerPage messengerPage = new MessengerPage();
  private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

  @Given("^I am on messenger page$")

  public void setMessengerPage(){
  homePage.clickOnMessengerLink();
    Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),"https://www.messenger.com/");

  }
  @When("^I enter (.+) into (username|password) field on messenger page$")
  public void enterDataIntoTextFields(String anyText, String textFields) {


    switch (textFields) {
      case "username":
        messengerPage.enterEmail(anyText);
        break;
      case "password":
        messengerPage.enterPassword(anyText);
        break;
    }
  }

  @When("^I click on signup button on messenger page$")
  public void clickOnSignUpButton() {
    messengerPage.clickOnSignUpButton();
  }

  @Then("^I verify invalid login verify message on signup page$")
  public void verifySignUpErrorMessage() {

    Assert.assertEquals(messengerLoginPage.getErrorMessage(), "Incorrect Email");
  }

}
