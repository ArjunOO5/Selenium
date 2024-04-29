package Practice;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.datafaker.Faker;

public class DemoBlaze {

	public static void main(String[] args) throws InterruptedException  {

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
		wait.until(ExpectedConditions.alertIsPresent()).accept();

		//collect all products
		List <WebElement> productList = driver.findElements(By.xpath("//body//h4"));

		//Iterating all products selecting required one
		String productName = "Nokia lumia 1520";
		for (int i = 0; i <productList.size(); i++) 	
		{	 
			if (productList.get(i).getText().equals(productName)) 			
			{
				productList.get(i).click();
				break;
			}
		}
		//click Add to cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

		//click on Add to cart

		driver.findElement(By.linkText("Add to cart")).click();
		//Wait for Alert
		wait.until(ExpectedConditions.alertIsPresent()).accept();

		//click on cart
		driver.findElement(By.id("cartur")).click();

		//Wait for cart and Click Place Order
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']//td//img")));
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();

		// enter details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='totalm']")));
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("country")).sendKeys(faker.country().name());
		driver.findElement(By.id("city")).sendKeys(faker.country().capital());
		driver.findElement(By.id("card")).sendKeys(faker.number().digits(16));
		int months = faker.number().numberBetween(1, 12);
		driver.findElement(By.id("month")).sendKeys(String.valueOf(months));
		int years = faker.number().numberBetween(2024, 2025);
		driver.findElement(By.id("year")).sendKeys(String.valueOf(years));
		driver.findElement(By.xpath("(//button[normalize-space()='Purchase'])[1]")).click();

		//wait for order confirmation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Thank you for your purchase!'])[1]")));
	    String orderdetail= driver.findElement(By.xpath("(//p[@class='lead text-muted '])[1]")).getText();
	    System.out.println(orderdetail);
	    Thread.sleep(2000);
		driver.findElement(By.cssSelector(".confirm.btn.btn-lg.btn-primary")).click();

		// wait for homepage to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cat']")));
		
		
		//quit
		driver.quit();

	}
}