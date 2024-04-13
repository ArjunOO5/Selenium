package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragOffset {

	public static void main(String[] args) {
		//initate Chromedriver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open URL
		driver.get("https://jqueryui.com/");
		//click on Draggle
		driver.findElement(By.xpath("//a[normalize-space()='Draggable']")).click();
		//switch to frame
		driver.switchTo().frame(0);
		//grab draggable element 
		WebElement dragableWebElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions dragActions = new Actions(driver);
		dragActions.dragAndDropBy(dragableWebElement, 40, 40).perform();
		
		
		
	}

}
