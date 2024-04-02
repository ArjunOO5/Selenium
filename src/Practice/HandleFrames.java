package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
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

	}

}
