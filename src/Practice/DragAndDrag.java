package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrag {

	public static void main(String[] args) {
		//Initiate chrome browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://jqueryui.com/");
		//Click droppable option
		driver.findElement(By.xpath("(//a[normalize-space()='Droppable'])[1]")).click();
		// switch to frame
		WebElement frameElement= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameElement);
		// collect drag and drop elements
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement =driver.findElement(By.id("droppable"));
		// Drag and Drop
		Actions dragAndDropActions = new Actions(driver);
		dragAndDropActions.dragAndDrop(dragElement, dropElement).perform();
		driver.quit();


	}

}
