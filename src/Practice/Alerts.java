package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// Initiaite Driver
		ChromeDriver driver = new ChromeDriver();
		// Maximize Browser
		driver.manage().window().maximize();
		// Open Url
		String URL = "https://letcode.in/test";
		driver.get(URL);
		// Click on Alert option
		WebElement Alert = driver.findElement(By.xpath("(//a[normalize-space()='Dialog'])[1]"));
		Alert.click();

		// Simple alert
		driver.findElement(By.xpath("//button[@class='button is-link']")).click();
		// Switch
		Alert alert = extracted(driver);
		// Accept Alert Message
		alert.accept();
		Thread.sleep(5000);

		// Confirm Alert
		driver.findElement(By.xpath("(//button[normalize-space()='Confirm Alert'])[1]")).click();
		Thread.sleep(5000);
		System.out.println(alert.getText());
		alert.dismiss();

		// Prompt Alert
		driver.findElement(By.xpath("(//button[normalize-space()='Prompt Alert'])[1]")).click();
		Thread.sleep(5000);
		alert.sendKeys("My name is killer");
		System.out.println(alert.getText());
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("/html//p[@id='myName']")).getText());

		// Sweet Alert
		driver.findElement(By.xpath("/html//button[@id='modern']")).click();
		System.out.println(driver.findElement(By.xpath("(//p[@class='title'])[1]")).getText());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		Thread.sleep(3000);
		// Quit
		driver.quit();
		
	}

	public static Alert extracted(ChromeDriver driver) {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		return alert;
	}

}
