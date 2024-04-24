package programs;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try1 {

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
		String productName ="Nokia lumia 1520";
		for (int i = 0; i < productList.size(); i++) {


			if (productList.get(i).getText().equals(productName)) 
			{
				productList.get(i).click();	
				break;
			}

		}


	}

}
