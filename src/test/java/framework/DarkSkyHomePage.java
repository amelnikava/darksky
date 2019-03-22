package framework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DarkSkyHomePage extends BasePage {

 //private By timeList = By.xpath(".//span[@class=\"hour\"]/descendant::*");
 private List<WebElement> timeList = (List<WebElement>) By.xpath(".//span[@class=\"hour\"]/descendant::*");
 private By tempRange = By.xpath("//a[@class='day revealed']//span[@class='tempRange']");

//  @Override
  public List<String> getTimeScale() {
    return getTimeScale(timeList);
  }

  @Override
  public List<String>  createNewListFromComputerTime() {
    return super.createNewListFromComputerTime();
   }

  public void clickOnTempRange (){
    clickOn(tempRange);
 }

}


