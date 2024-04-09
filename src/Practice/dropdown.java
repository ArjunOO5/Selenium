package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) {
		// Instantiate a ChromeDriver class. 
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		// Launch Website 
		driver.get("https://the-internet.herokuapp.com/");
		// Click on DropDown option
		WebElement dropElement = driver.findElement(By.xpath("(//a[normalize-space()='Dropdown'])[1]"));
		dropElement.click();
		//select dropdown
		WebElement dropdownElement = driver.findElement(By.xpath("(//select[@id='dropdown'])[1]"));
		Select dropdownSelect = new Select(dropdownElement);
		dropdownSelect.selectByIndex(1);
		System.out.println(dropdownElement.getText());
		//Quit Browser
		driver.close();
		System.out.println("worked!!");




	}

}
