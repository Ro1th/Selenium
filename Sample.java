import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Sample {
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
  public void testSample() throws Exception {
    driver.get(baseUrl + "/search?dcr=0&ei=op8FWqrBEomKvQSkr7ToBw&q=amazon&oq=amazon&gs_l=psy-ab.3..0i67k1l2j0i131k1j0i67k1l6j0.1499.2735.0.2932.6.6.0.0.0.0.258.698.2-3.3.0....0...1.1.64.psy-ab..3.3.695....0.AWb-8hhUMMU");
    driver.findElement(By.linkText("Amazon India")).click();
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
    driver.findElement(By.cssSelector("input.nav-input")).click();
    driver.findElement(By.xpath("//li[@id='result_0']/div/div[3]/div/a/h2")).click();
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
  }