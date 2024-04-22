package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo {

	public static void main(String[] args) {
		// Instantiate Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open Url
		driver.get("http://blazedemo.com");
		//Choose your departure city 	
		Select departure = new Select(driver.findElement(By.xpath("(//select[@name='fromPort'])[1]")));
		departure.selectByIndex(2);
		// Choose your destination city
		Select destination = new Select(driver.findElement(By.xpath("(//select[@name='toPort'])[1]")));
		destination.selectByIndex(3);
		//Click Find Flights
		driver.findElement(By.xpath("(//input[@value='Find Flights'])[1]")).click();
		
		// collect fligth names
		List <WebElement> list =driver.findElements(By.tagName("tr"));
		
		System.out.println(driver.findElement(By.cssSelector("th:nth-child(3)")).getText());
		
		System.out.println(list.size());
		
		for(WebElement litsElement : list)
		{
			int i=0;
			litsElement.click();
			System.out.println(list.get(i).getText());
		}

		

		//driver.findElement(By.className("btn-small")).click();
		
		//driver.quit();

	}

}
