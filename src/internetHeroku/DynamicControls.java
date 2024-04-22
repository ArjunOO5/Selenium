package internetHeroku;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {

	public static void main(String[] args) throws InterruptedException {
		// initiate Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open URL
		driver.get("https://the-internet.herokuapp.com/");
		//click on dynamic controls
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]")).click();
		//click on check box
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//click on Remove
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		//wait for Add button to be visible
		int w =30;
		WebDriverWait addDriverWait = new WebDriverWait(driver,Duration.ofSeconds(w));
		addDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
		System.out.println(driver.findElement(By.id("message")).getText());
		//wait for Remove button to be visible
		driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]")).click();
		addDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//p[@id='message'])[1]")));
		System.out.println(driver.findElement(By.id("message")).getText());
		//Click enable button
		driver.findElement(By.xpath("(//button[normalize-space()='Enable'])[1]")).click();
		addDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("I did it ");
		Thread.sleep(3000);
		

		//Quit Browser
		driver.quit();
	}

}
