package internetHeroku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

	public static void main(String[] args) {
		// Initiate Chrome driver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		//click on context menu
		driver.findElement(By.xpath("(//a[normalize-space()='Context Menu'])[1]")).click();
		//right click on block
		Actions clickActions = new Actions(driver);
		WebElement blockElement = driver.findElement(By.xpath("(//div[@id='hot-spot'])[1]"));
		clickActions.contextClick(blockElement).build().perform();
		//switch to frame
		Alert popAlert =driver.switchTo().alert();
		System.out.println(popAlert.getText());
		popAlert.accept();
		driver.quit();


	}

}
