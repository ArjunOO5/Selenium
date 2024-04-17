package internetHeroku;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {

	public static void main(String[] args) {
		// Instantiate Chrome
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		// click on file download link
		driver.findElement(By.xpath("//a[normalize-space()='File Download']")).click();
		// collect all download file webelements
		List <WebElement> filesElement =driver.findElements(By.tagName("a"));
		//loop
		for(int i=1;i<=3;i++)
		{
			System.out.println("files to be downloaded"+ "   "+filesElement.get(i).getAttribute("innerHTML"));
			filesElement.get(i).click();
		}
		//quit
		driver.quit();
	}

}
