package internetHeroku;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsOperations {

	public static void main(String[] args) {
		//instantiate chrome
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://www.saucedemo.com/");
		System.out.println(driver.getCurrentUrl()+"..."+driver.getTitle());
		//open new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://github.com/");
		System.out.println(driver.getCurrentUrl()+"..." + driver.getTitle());
		

	}

}
