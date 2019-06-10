package testSuite;

import base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Part_A extends Base {

  List<WebElement> elementList;

  @Test (priority = 1)
  public void test1_loadPage() {
    openBrowser(prop.getProperty("browser"));
    navigate(prop.getProperty("url"));
  }

  @Test (priority = 2)
  public void test2_extractLinkTexts() {
    // Extract the text of all the links in the main-menu bar
    elementList = driver.findElements(By.xpath(prop.getProperty("menuBarLinks")));
    System.out.println("Number of link elements stored: " + elementList.size());

    for (WebElement element : elementList) {
      int textLength = element.getText().length();
      if (textLength > 0)
        System.out.println(element.getText());
        // Maybe add element -> new list ?
      else
        System.out.println("[string length = " + textLength + "]");
    }
  }

  @Test (priority = 3)
  public void test3_capturePageTitles() {
    // TODO: Click each link in the menu bar
    // TODO: Wait for each page to load
    // TODO: Capture the page titles
    closeBrowser();
  }
}