package internetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		// Initiate Chrome driver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		String username= "admin";
		String password= "admin";
		String domain = "the-internet.herokuapp.com/basic_auth";
		String URL ="https://"+username+":"+password+"@"+domain;
		driver.get(URL);
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials')]")).getText());
		driver.quit();
		
	}

}
