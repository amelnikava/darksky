package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.DarkSkyMainPage;
import java.util.List;
import org.testng.Assert;

public class DarkSkySD {

  private DarkSkyMainPage darkSkyMainPage = new DarkSkyMainPage();
  List<String> list1 = darkSkyMainPage.getTimeScale();
  List<String> list2 = darkSkyMainPage.createNewListFromComputerTime();

  @Given ("^I am on Darksky home page$")
  public void iAmOnDarkSkyHomePage(){

    Assert.assertTrue(darkSkyMainPage.isDarkSkyTitleDisplayed());
  }
  @And("^I verify timeline is displayed with two hours incremented$")
  public void verifyIncrementationOfHours(){

    Assert.assertTrue(darkSkyMainPage.verifyTimeIncremented(list2, list1));
    //Assert.assertEquals(list2, list1);
  }
  @Then("^I verify lowest and highest temp is displayed correctly$")
  public void isLowestAndHighestTemperatureDisplayedCorrectly() throws InterruptedException {
    Assert.assertTrue(darkSkyMainPage.isTemperaturDisplayedCorrectly());
}
}
