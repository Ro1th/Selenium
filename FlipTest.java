import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new FirefoxDriver();
driver.get("https://www.flipkart.com/search?q=Dell&otracker=start&as-show=on&as=off");
driver.findElement(By.id("fk-top-search-box")).sendKeys("Microsoft");
driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
