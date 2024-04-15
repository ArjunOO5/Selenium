package internetHeroku;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebCalls {

	public static void main(String[] args) {
		urlCallherokuapp();

	}

	public static void urlCallherokuapp() {
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}

}
