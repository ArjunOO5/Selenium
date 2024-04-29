package Practice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Saucedemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// Instantiate Chrome Driver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();

		// Webdriver Wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//open URL
		driver.get("https://www.saucedemo.com/");

		// User userName ans PWD
		String userName ="standard_user";
		String pwd="secret_sauce";

		//Login 
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='app_logo'])[1]")));

		//collect all products
		List<WebElement> prodElements =driver.findElements(By.cssSelector(".inventory_item_name "));

		//Print all products in console 	

		int i=1;
		for (WebElement Product : prodElements) {

			System.out.println(i+" " + Product.getText());
			i++;
		}
  
		//Select which Product need to be added to cart 
		System.out.println("Enter Serial number of desired Product");
		Scanner productnum= new Scanner(System.in);
		int j= productnum.nextInt();
		
		//Select product and Add to cart 
		






		//Quit Browser
		driver.quit();


	}

}
