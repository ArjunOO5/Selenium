package programs;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		//chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://www.demoblaze.com");
		Thread.sleep(2000);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Sony vaio i7'])[1]")));
		List<WebElement> productList = driver.findElements(By.xpath("//body//h4"));
		// Loop for getting products texts
		for (int j = 0; j < productList.size(); j++) {
			String listmobile =productList.get(j).getText();
			System.out.println(j +"." + listmobile );		
		}
		// Print products list and get desired products 
		System.out.println("Enter Product Index which you want to buy");
		Scanner number = new Scanner(System.in);		
		int i =number.nextInt();
		//click on desired product 
		productList.get(i).click();	

		driver.quit();

	}

}
