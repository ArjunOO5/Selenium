package programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Propertiesfile  {

	public static void main(String[] args) throws IOException {
	
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		
		
		 Properties properties = new Properties();
		  FileInputStream fileInputStream = new FileInputStream("./target/Property.property");
		  properties.load(fileInputStream);
		
		 System.out.println(properties.getProperty("Username")); 
		
		driver.findElement(By.xpath("(//input[@id='txt-username'])[1]")).sendKeys(properties.getProperty("Username"));
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys(properties.getProperty("Password"));
	}

}
