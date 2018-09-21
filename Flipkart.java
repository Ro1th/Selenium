import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Flipkart {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFlipkart() throws Exception {
    driver.get(baseUrl + "/search?q=surface&ie=utf-8&oe=utf-8&gws_rd=cr&dcr=0&ei=xU8qWvWYBorxvgSHtISIBQ");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("surface pro");
    driver.findElement(By.id("_fZl")).click();
    driver.findElement(By.linkText("Microsoft Surface Pro 4 Core i5 6th Gen - (4 GB/128 GB SSD/Windows ...")).click();
    driver.findElement(By.xpath("//button[@type='button']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
