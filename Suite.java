import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Suite {
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
  public void testSuite() throws Exception {
    driver.get(baseUrl + "/search?q=apple&ie=utf-8&oe=utf-8&gws_rd=cr&dcr=0&ei=6EEqWrCwKsHYvgTcsiY");
    driver.findElement(By.linkText("Apple (India)")).click();
    driver.findElement(By.id("ac-gn-menustate")).click();
    driver.findElement(By.cssSelector("span.ac-gn-menuicon-bread.ac-gn-menuicon-bread-top")).click();
    driver.findElement(By.linkText("iPhone")).click();
    driver.findElement(By.xpath("//main[@id='main']/div[2]/section/div/div/a[2]/span")).click();
    driver.findElement(By.xpath("//a[contains(@href, 'https://www.jio.com/shop/en-in/c/smartphones?q=%3Arelevance%3Abrand%3AApple&text=#')]")).click();
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
