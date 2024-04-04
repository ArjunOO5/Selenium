package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) {
		//Initialize driver
		ChromeDriver driver =new ChromeDriver();
		//maximize browse
		driver.manage().window().maximize();
		//Navigate URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		//switch frame
		WebElement frElement = driver.findElement(By.xpath("(//iframe[@id='iframeResult'])[1]"));
		driver.switchTo().frame(frElement);
		// Click Try button
		WebElement trybuttton= driver.findElement(By.xpath("//button[text()='Try it']"));
		trybuttton.click();
		//Switch to alert
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("liver");
		alert.accept();
		//switch to parent frame
		//driver.switchTo().parentFrame();
		String msgString = driver.findElement(By.xpath("(//p[@id='demo'])[1]")).getText();
		System.out.println(msgString);
		//quit browser
		driver.quit();
	}

}
