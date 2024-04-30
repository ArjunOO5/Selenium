package Practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class Nopcommerce {

	public static void main(String[] args) {
		// Instantiate Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Open URL
		driver.get("http://demo.nopcommerce.com/");
	}

}
