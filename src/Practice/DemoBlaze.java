package Practice;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.datafaker.Faker;

public class DemoBlaze {

	public static void main(String[] args) throws InterruptedException {

		//Instantiate Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		//Open URL
		driver.get("https://www.demoblaze.com/index.html");

		//click sign in
		driver.findElement(By.id("signin2")).click();

		//webdriver Wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='signInModalLabel']")));

		//create username and password
		Faker faker = new Faker();
		String username =faker.name().malefirstName()+faker.name().lastName();
		String password =faker.name().fullName();

		//sign up
		driver.findElement(By.id("sign-username")).sendKeys(username);
		driver.findElement(By.id("sign-password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();

		//wait for alter pop up
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alerts = driver.switchTo().alert();
		alerts.accept();

		//collect all products
		List <WebElement> productList = driver.findElements(By.xpath("//body//h4"));
        
		for (int i = 0; i <productList.size(); i++) {
			
			//String productname = productList.get(i).getText();
			
			if (productList.get(i).getText()
			.equals("Nokia lumia 1520")) {
				
				productList.get(i).click();
			}
			
		}
		

		//quit
		driver.quit();
	}
}
