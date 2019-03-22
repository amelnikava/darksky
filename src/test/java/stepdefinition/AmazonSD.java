package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AmazonHomePage;
import framework.AmazonNewCustomewPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AmazonSD {

  private AmazonHomePage amazonHomePage = new AmazonHomePage();
  private AmazonNewCustomewPage amazonNewCustomewPage = new AmazonNewCustomewPage();

  @Given("^I am on amazon create account page$")
  public void setMessengerPage() {
    amazonHomePage.hoverOver();
    amazonHomePage.clickStartHere();
    Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon Registration");
  }

  @When("^I enter (.*) into (name|email|password|checkPassword) text fields on create account screen$")
  public void enterDataIntoTextFields(String anyText, String textFields) {

    switch (textFields) {
      case "name":
        amazonNewCustomewPage.enterName(anyText);
        break;
      case "email":
        amazonNewCustomewPage.enterEmail(anyText);
        break;
      case "password":
        amazonNewCustomewPage.enterPassword(anyText);
        break;
      case "checkPassword":
        amazonNewCustomewPage.reenterPassword(anyText);
        break;
    }
  }

  @When("^I click on create button on create account screen$")
  public void clickOnCreateButton() {amazonNewCustomewPage.clickOnCreateAccountButton();
  }

  @Then("^I verify that I can't create an account$")
  public void verifyCreateAccount() {
    Assert.assertEquals(SharedSD.getDriver().getTitle(), "Amazon Registration");
  }
}








