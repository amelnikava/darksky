package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	Actions actions = new Actions(SharedSD.getDriver());

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void mouseOver (By hoverOver) {
		WebElement element = webAction(hoverOver);
		actions.moveToElement(element).build().perform();
	}
	public List<String>  getTimeScale (List<WebElement> timeList) {

		List<String> actualTimeList = new ArrayList<>();// etot list imeet tolko vremya, t.e numbers

		for (WebElement element : timeList) {
			actualTimeList.add(element.getText());
			System.out.println("LIST DATA: " + element.getText());
		}
		return actualTimeList;
	}

	///\gets the current time from my computer and creates and array that has time
	 //public void verifyTimeIncremented (){
	public List<String> createNewListFromComputerTime (){
		 Date date = null;
		 SimpleDateFormat formater = new SimpleDateFormat("ha");
		 Calendar cal =Calendar.getInstance();
		 cal.setTime(new Date());
		 List<String> expectedTimeList = new ArrayList<>();

		 for (int i = 0; i < 11; i++){
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


}



