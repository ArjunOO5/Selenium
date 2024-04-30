package Practice;

import java.time.Duration;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.datafaker.Faker;

public class Computerdatabase {

	public static void main(String[] args) {
		// Instatiate Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		
		//Launch the Url
		driver.navigate().to("https://computer-database.gatling.io/computers");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Computer database']")));
		
		//Click on "Add a computer"
		driver.findElement(By.xpath("//a[@id='add']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1[normalize-space()='Add a computer'])[1]")));
		
		
		//Enter details and Create the computer
		Faker info = new Faker();
		driver.findElement(By.id("name")).sendKeys(info.lordOfTheRings().character());
		driver.findElement(By.id("introduced")).sendKeys(info.date().birthday("yyyy-MM-dd"));
		driver.findElement(By.id("discontinued")).sendKeys(info.date().birthday("yyyy-MM-dd"));
		
		Select Dropdown = new Select(driver.findElement(By.id("company")));
		Dropdown.selectByIndex(3);
		driver.findElement(By.xpath("//input[@value='Create this computer']")).click();	
		driver.findElement(By.cssSelector(".alert-message.warning")).isDisplayed();
		
		//Search for the compute on the home page
		
		
		
		//Select the one you created

		
		
		
		//Delete the computer

		
		
		//Logout
			
	}

}
