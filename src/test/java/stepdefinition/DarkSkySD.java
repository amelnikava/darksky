package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.DarkSkyHomePage;
import java.util.List;
import org.testng.Assert;

public class DarkSkySD {

  private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

  List<String> list1 = darkSkyHomePage.getTimeScale();
  List<String> list2 = darkSkyHomePage.createNewListFromComputerTime();

  @Given ("^I am on Darksky home page$")
  public void setDarkSkyHomePage(){

    Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.darksky.net/");
  }
  @Then("^I verify timeline is displayed with two hours incremented$")
  public void verifyIncrementationOfHours(){

    Assert.assertTrue(darkSkyHomePage.verifyTimeIncremented(list2, list1));
    //Assert.assertEquals(list2, list1);

  }
}
