package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlazeDemo {

	public static void main(String[] args) {
		// Instantiate Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open Url
		driver.get("http://blazedemo.com");

		//Choose your departure city 	
		Select departure = new Select(driver.findElement(By.xpath("(//select[@name='fromPort'])[1]")));
		departure.selectByVisibleText("Paris");

		// Choose your destination city
		Select destination = new Select(driver.findElement(By.xpath("(//select[@name='toPort'])[1]")));
		destination.selectByVisibleText("Cairo");

		//Click Find Flights
		driver.findElement(By.xpath("(//input[@value='Find Flights'])[1]")).click();

		// collect table
		WebElement table =driver.findElement(By.xpath("//table//tbody"));

		//collect rows from table
		List<WebElement> listofRows = table.findElements(By.tagName("tr"));

		//Iterating column Values for clicking Choose this flight
		for (int i = 0; i < listofRows.size(); i++) {

			//collect column values from rows
			List<WebElement> columnslist =listofRows.get(i).findElements(By.tagName("td"));
			//collect specfic column Values 
			WebElement columnname = columnslist.get(2);
			if (columnname.getText().equals("Lufthansa")) {
				columnslist.get(0).findElement(By.tagName("input")).click();
				break;

			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Your flight from TLV to SFO has been reserved.']")));


		//entering Details 	
		driver.findElement(By.id("inputName")).sendKeys("John Gramer");
		driver.findElement(By.id("address")).sendKeys("Paramount Hollywood");
		driver.findElement(By.id("city")).sendKeys("San Fransico");
		driver.findElement(By.id("state")).sendKeys("US");
		driver.findElement(By.id("zipCode")).sendKeys("200090");
		// selecting card type dropdown
		Select cardType = new Select(driver.findElement(By.id("cardType")));
		cardType.selectByVisibleText("Visa");

		driver.findElement(By.id("creditCardNumber")).sendKeys("89893443566589829");
		driver.findElement(By.id("creditCardMonth")).sendKeys("12");
		driver.findElement(By.id("creditCardYear")).sendKeys("2024");
		driver.findElement(By.id("nameOnCard")).sendKeys("John Gramer");
		// click on rememember me and Purchase flight
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("(//input[@value='Purchase Flight'])[1]")).click();
		// verification of purchase
		Boolean resultBoolean= driver.findElement(By.tagName("h1")).isDisplayed();

		if (resultBoolean.equals(true)) {
			System.out.println("Tickets are Booked Successfully");
		} else {
			System.err.println("Ticket booking is failed");
		}

		driver.quit();
	}

}
