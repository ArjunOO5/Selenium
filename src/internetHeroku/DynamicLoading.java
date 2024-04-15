package internetHeroku;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading {

	public static void main(String[] args) throws InterruptedException {
		// Initiate chrome browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		//click on Disappering elements
		driver.findElement(By.linkText("Dynamic Loading")).click();
		//click on hidden element 1 and click start button
		driver.findElement(By.xpath("(//a[normalize-space()='Example 1: Element on page that is hidden'])[1]")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='Start'])[1]")).click();
		//Wait for hidden element
		WebDriverWait hiddenWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		hiddenWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4[normalize-space()='Hello World!'])[1]")));
		System.out.println(driver.findElement(By.xpath("(//h4[normalize-space()='Hello World!'])[1]")).getText());
		Thread.sleep(2000);
		// Go back
		driver.navigate().back();
		// click on hidden element 2 and click
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='Start'])[1]")).click();
		hiddenWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4[normalize-space()='Hello World!'])[1]")));
		System.out.println(driver.findElement(By.xpath("(//h4[normalize-space()='Hello World!'])[1]")).getText());
		//quit browser
		driver.quit();
		
		
		
	}

}
