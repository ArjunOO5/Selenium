package Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class HandleFrames {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Initaite Driver
		ChromeDriver driver = new ChromeDriver();
		// Maximize Browser
		driver.manage().window().maximize();
		// Open Url
		String URL = "https://letcode.in/test";
		driver.get(URL);
		//Click on frame option
		driver.findElement(By.xpath("(//a[normalize-space()='Inner HTML'])[1]")).click();
		//Switch to frame 
		driver.switchTo().frame(0);
		driver.findElement(By.name("fname")).sendKeys("Killer");
		driver.findElement(By.xpath("(//input[@placeholder='Enter email'])[1]")).sendKeys("Milller");
		//Switch to next child frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@placeholder='Enter email'])[1]")).sendKeys("kmiller");
		// Switch Back to Parent frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("Killer2");
		WebElement  chk = driver.findElement(By.name("fname"));
		File  SS =chk.getScreenshotAs(OutputType.FILE);
		String FileName = String.valueOf(System.currentTimeMillis())+".png";
		File des = new File("./Snaps/"+FileName);
		FileHandler.copy(SS, des);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("(//a[normalize-space()='Watch tutorial'])[1]")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
