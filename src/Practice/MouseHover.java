package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Actions mouseActions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Mobiles & Tablets')]"));
		element.click();
		WebElement element2 = driver.findElement(By.xpath("(//span[normalize-space()='Electronics'])[1]"));
		mouseActions.moveToElement(element2).perform();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Asus"))).click();
		//driver.findElement(By.linkText("Asus")).click();
	}

}
