package internetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		// Instantiate Chrome
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		//click on file upload link
		driver.findElement(By.linkText("File Upload")).click();
		//click on choose file icon and send file
		WebElement uploadElement =driver.findElement(By.xpath("//input[@id='file-upload']"));
		uploadElement.sendKeys("C:\\Users\\2091793\\Downloads\\Screenshot 2023-12-27 133459.png");
		//click upload icon
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		// Assertion
		Boolean disBoolean=	driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).isDisplayed();
		System.out.println(disBoolean);
		// Quit
		driver.quit();		
		
		

	}

}
