package internetHeroku;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddorRemove {

	public static void main(String[] args) throws InterruptedException {
		// Initiate Chrome Driver
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//Open URL
		driver.get("https://the-internet.herokuapp.com/");
		//Click on Add/Remove Elements
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/add_remove_elements/']")).click();
		//Method to click Add element
		WebElement addElement =driver.findElement(By.xpath("(//button[normalize-space()='Add Element'])[1]"));		
		extracted(3, addElement);
		//Method to delete button
		extracted(driver);
		driver.quit();
		
	}

	public static void extracted(ChromeDriver driver) throws InterruptedException {
		List<WebElement>  deleteElement =driver.findElements(By.xpath("//button[normalize-space()='Delete']"));
		
		for(int d=0;d<deleteElement.size();d++)
		{
			
			deleteElement.get(d).click();
			System.out.println("new button deleted"+d);
			Thread.sleep(2000);
		}
	}

	public static void extracted(int clicks ,WebElement addElement) throws InterruptedException {
		for(int i=0;i<clicks;i++)
		{
			addElement.click();
			System.out.println("new button added"+i);
			Thread.sleep(2000);
		}
	}
	}

