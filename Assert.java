import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Assert {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	ProfilesIni allProfiles = new ProfilesIni();
	driver = new FirefoxDriver(allProfiles.getProfile("default"));
    //driver = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAssert() throws Exception {
    driver.get(baseUrl + "/search?q=amazon&ie=utf-8&oe=utf-8&gws_rd=cr&dcr=0&ei=y6oFWtv2M5jGvwSSzIvgBw");
    assertEquals("amazon - Google Search", driver.getTitle());
    driver.findElement(By.linkText("Amazon India")).click();
    try {
      assertEquals("Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("rolex");
    driver.findElement(By.cssSelector("input.nav-input")).click();
    assertEquals("Amazon.in: rolex", driver.getTitle());
    assertEquals("Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
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
