package Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Initiaite Driver
		ChromeDriver driver =new ChromeDriver();
		// Maximize Browser
		driver.manage().window().maximize();
		//Navigate 
		String URL = "https://letcode.in/test";
		driver.get(URL);
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("Jenkins@h.vom");
		driver.findElement(By.xpath("(//input[@placeholder='Enter password'])[1]")).sendKeys("--httpPort=9090");
		driver.findElement(By.xpath("//button[normalize-space()='LOGIN']")).click();
		//Explicit Wait
		WebElement  banner =driver.findElement(By.xpath("(//h1[normalize-space()='LetCode with Koushik'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(banner));
		//driver.findElement(By.xpath("//h1[normalize-space()='LetCode with Koushik']"))
		driver.quit();
		

	}

}
