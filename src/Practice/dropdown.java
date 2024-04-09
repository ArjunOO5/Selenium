package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown {

	public static void main(String[] args) {
		// Instantiate a ChromeDriver class. 
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		// Launch Website 
		driver.get("https://the-internet.herokuapp.com/");
		// Click on DropDown option
		WebElement dropElement = driver.findElement(By.xpath("(//li)[11]"));
		dropElement.click();





	}

}
