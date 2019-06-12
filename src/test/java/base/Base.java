package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

  public WebDriver driver;
  public Properties prop;

  @BeforeClass
  public void propertiesFileSetup() {
    FileReader fileReader;
    prop = new Properties();
    try {
      String path = System.getProperty("user.dir") + "\\Final_Assignment_git\\resources\\test.properties";
      fileReader = new FileReader(path);
      prop.load(fileReader);
      System.out.println(path + " was loaded as a properties file.");
    } catch (java.io.IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public void openBrowser(String browserName) {
    driver = null;
    if (browserName.equalsIgnoreCase("Firefox")) {
      System.setProperty("webdriver.firefox.bin", "c:\\Program Files\\Mozilla Firefox 58\\firefox.exe");
      String path = System.getProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY);
      System.out.println("Using binary: " + path);
      driver = new FirefoxDriver();
    } else if (browserName.equalsIgnoreCase("Chrome")) {
      driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("Edge")) {
      driver = new EdgeDriver();
    } else if (browserName.equalsIgnoreCase("IE")) {
      driver = new InternetExplorerDriver();
    } else {
      System.out.println("No valid browser driver name specified.");
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  public void navigate(String url) {
    driver.get(url);
  }

  public void click(WebElement element) {
    element.click();
  }

  public void closeBrowser() {
    driver.quit();
  }

  public static long getTime() {
    return System.currentTimeMillis();
  }

}
