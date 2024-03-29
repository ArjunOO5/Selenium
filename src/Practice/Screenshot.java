package Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver =new ChromeDriver();
		//Open URL
		String URL ="https://letcode.in/test";
		driver.get(URL);
		//Window maximize
		driver.manage().window().maximize();
		//Click on Button
		WebElement Button =driver.findElement(By.xpath("(//a[normalize-space()='Click'])[1]"));
		Button.click();
		//File name
		String FileName = String.valueOf(System.currentTimeMillis())+".png";
		// Take Screenshot
		Thread.sleep(300);
		WebElement SS =driver.findElement(By.xpath("(//div[@class='card-content'])[2]"));
		File img= SS.getScreenshotAs(OutputType.FILE);
		File src= new File("./Snaps/"+FileName);
		FileHandler.copy(img, src);
		Thread.sleep(200);
		//Quit
		driver.quit();
		
	}

}

