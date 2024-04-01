package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Explicit_Wait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://letcode.in/test";
		driver.get(URL);
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("Jenkins@h.vom");
		driver.findElement(By.xpath("(//input[@placeholder='Enter password'])[1]")).sendKeys("--httpPort=9090");
		driver.findElement(By.xpath("//button[normalize-space()='LOGIN']")).click();
		WebElement  banner =driver.findElement(By.xpath("//h1[normalize-space()='LetCode with Koushik']"));
//		driver.findElement(By.xpath("//h1[normalize-space()='LetCode with Koushik']"))
		driver.quit();
		

	}

}
