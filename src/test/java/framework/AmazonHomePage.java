package framework;

import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage {
  private By hoverOver = By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]");
  private By startHere = By.xpath("//a[contains(text(),'Start here.')]");

  public void hoverOver() {
    mouseOver(hoverOver);
  }

  public void clickStartHere() {
    clickOn(startHere);
  }

}
