package framework;

import static stepdefinition.SharedSD.getDriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DarkSkyMainPage extends BasePage{

  private List<WebElement> timeList = getDriver().findElements(By.xpath(".//span[@class=\"hour\"]/descendant::*"));
  private By tempRange = By.xpath("//body[@class='forecast']/div[@class='center']/a[1]/span[2]");
  private By expandDayTimeline = By.xpath("//a[1]//span[3]//span[1]");
  private By minTempDisplayed = By.xpath("//alass='day revealed']//span[@class='tempRange']//span[@class='minTemp'][@c");
  private By minTempExpanded = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='highTemp swip']//span[@class='temp']");
  private By maxTempDisplayed = By.xpath("//a[@class='day revealed']//span[@class='tempRange']//span[@class='maxTemp']");
  private By maxTempExpanded = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='lowTemp swap']//span[@class='temp']");


  public boolean isDarkSkyTitleDisplayed() {
    return getDriver().getTitle().contains("Dark Sky");
  }

  public List<String> getTimeScale () {

    List<String> actualTimeList = new ArrayList<>();// take numbers
    for (WebElement element : timeList) {
      actualTimeList.add(element.getText());
      System.out.println("LIST DATA: " + element.getText());
    }
    return actualTimeList;
  }

  public List<String> createNewListFromComputerTime () {
    Date date = null;
    SimpleDateFormat formater = new SimpleDateFormat("ha");
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    List<String> expectedTimeList = new ArrayList<>();

    for (int i = 0; i < 11; i++) {
      cal.add(Calendar.HOUR_OF_DAY, 2);
      date = cal.getTime();
      expectedTimeList.add(formater.format(date).toLowerCase());

    }
    return expectedTimeList;


  }
    public boolean verifyTimeIncremented (List<String> computerTimeList, List<String> websiteTimeList){
    //compare two lists
      return websiteTimeList.equals(computerTimeList);
}

   public boolean isTemperaturDisplayedCorrectly () throws InterruptedException {
     JavascriptExecutor jse = (JavascriptExecutor) getDriver();
     jse.executeScript("window.scrollBy(0,650", "");
     Thread.sleep(1000);
     clickOn(tempRange);
     Thread.sleep(2000);

     return getTextFromElement(minTempDisplayed).equals(getTextFromElement(minTempExpanded)) &&
         getTextFromElement(maxTempDisplayed).equals(getTextFromElement(maxTempExpanded));
   }

}

