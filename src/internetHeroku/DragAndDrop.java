package internetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// Instantiate a ChromeDriver class. 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Open URL
		driver.get("https://the-internet.herokuapp.com/");
		//Click on Drag and Drop
		WebElement draghyperlinkElement= driver.findElement(By.xpath("(//a[normalize-space()='Drag and Drop'])[1]"));
		draghyperlinkElement.click();
		//Capturing Drag and Drop element
		WebElement dragElementA =driver.findElement(By.xpath("(//div[@id='column-a'])[1]"));
		WebElement dropElementB =driver.findElement(By.xpath("(//div[@id='column-b'])[1]"));
		// Performing Drag and Drop		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragElementA, dropElementB).build().perform();
		System.out.println("Sucess!!");
		//Exit Browser
		driver.quit();
	}

}
