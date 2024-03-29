package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		//Initiaite Driver
		ChromeDriver driver =new ChromeDriver();
		//Maximize Browser
		driver.manage().window().maximize();
		//Open Url
		String URL ="https://letcode.in/test";
		driver.get(URL);
		//Click on Alert option
		WebElement Alert = driver.findElement(By.xpath("(//a[normalize-space()='Dialog'])[1]"));
		Alert.click();
		

	}

}
