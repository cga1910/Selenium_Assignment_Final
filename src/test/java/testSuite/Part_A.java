package testSuite;

import base.*;
import org.testng.annotations.Test;

public class Part_A extends Base {

  String url = prop.getProperty("url");
  String browser = prop.getProperty("browser");

  @Test
  public void test1_extractLinks() {
    openBrowser(browser);
    navigate(url);
    // TODO: Extract the text of all the links in the main-menu bar
  }

  @Test
  public void test2_captureTitles() {
    // TODO: Click each link in the menu bar
    // TODO: Wait for each page to load
    // TODO: Capture the page titles
  }
}
