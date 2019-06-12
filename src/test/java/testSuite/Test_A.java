package testSuite;

import base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_A extends Base {

  List<WebElement> elementList;
  long startTime, finishTime;

  @Test (priority = 1)
  public void test1_loadPage() {
    openBrowser(prop.getProperty("browser"));
    navigate(prop.getProperty("home_URL"));
  }

  @Test (priority = 2)
  public void test2_getLinkTexts() {
    startTime = getTime();

    elementList = driver.findElements(By.xpath(prop.getProperty("xPath_menuBarLinks")));
    System.out.println("-- Number of stored link elements: " + elementList.size());

    for (WebElement linkElement : elementList) {
      if (linkElement.isDisplayed())
        System.out.println(linkElement.getText());
      else
        System.out.println("[ Link text is not displayed ]");
    }
  }

  @Test (priority = 3, dependsOnMethods = "test2_getLinkTexts")
  public void test3_getPageTitles() {

    ArrayList<String> pageTitleList = new ArrayList<String>();
    WebElement linkElement;

    for (int i = 0; i < elementList.size(); i++) {
      linkElement = elementList.get(i);
      if (linkElement.isDisplayed()) {
        click(linkElement);
        pageTitleList.add(driver.getTitle());
        driver.navigate().back();
        elementList = driver.findElements(By.xpath(prop.getProperty("xPath_menuBarLinks")));
      }
    }

    System.out.println('\n' + "-- Number of stored page titles: " + pageTitleList.size());

    for (String pageTitle : pageTitleList) {
      System.out.println(pageTitle);
    }

    finishTime = getTime();
    System.out.println('\n' + "Test time (ms): " + (finishTime - startTime));

    closeBrowser();
  }
}