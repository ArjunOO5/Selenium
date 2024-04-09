package internetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddorRemove {

	public static void main(String[] args) {
		// Initiate Chrome Driver
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//Open URL
		driver.get("https://the-internet.herokuapp.com/");
		//Click on Add/Remove Elements
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/add_remove_elements/']")).click();
		
		
		

	}

}
