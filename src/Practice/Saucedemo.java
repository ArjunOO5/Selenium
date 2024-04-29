package Practice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.testng.asserts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.opentelemetry.sdk.metrics.data.Data;
import net.datafaker.Faker;
import programs.DataFaker;

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

		// Assertion
		String selectedProductName=prodElements.get(j).getText();


		//Select product and Add to cart 
		driver.findElements(By.cssSelector(".inventory_item_name ")).get(j).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='inventory_details_name large_size'])[1]")));
		String productJustfication=driver.findElement(By.xpath("(//div[@class='inventory_details_name large_size'])[1]")).getText();	
		driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])[1]")).click();
		org.testng.Assert.assertEquals(selectedProductName,driver.findElement(By.xpath("(//div[@class='inventory_details_name large_size'])[1]")).getText());

		// Click on Cart and checkout
		driver.findElement(By.className("shopping_cart_badge")).click();
		org.testng.Assert.assertEquals(productJustfication, driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText());
		driver.findElement(By.name("checkout")).click();

		// Give Checkout Information
		Faker info= new Faker();
		driver.findElement(By.id("first-name")).sendKeys(info.name().firstName());
		driver.findElement(By.name("lastName")).sendKeys(info.name().lastName());
		driver.findElement(By.name("postalCode")).sendKeys(info.number().digits(6));
		driver.findElement(By.id("continue")).click();

		// Checkout Overview
		System.out.println(driver.findElement(By.className("inventory_item_name")).getText());	
		org.testng.Assert.assertEquals(selectedProductName, driver.findElement(By.cssSelector(".inventory_item_name")).getText());
		driver.findElement(By.id("finish")).click();

		//Checkout Complete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
		driver.findElement(By.id("back-to-products")).click();

		//Homepage and logout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='app_logo'])[1]")));
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		driver.findElement(By.id("logout_sidebar_link")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='login_logo'])[1]")));
		

		//Quit Browser
		driver.quit();


	}

}
