package internetHeroku;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
public class scroll {

	public static void main(String[] args) {

		//Initiate Chrome driver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//Open Url
		driver.get("https://the-internet.herokuapp.com/");
		//Javascript scroll 
		JavascriptExecutor js= (JavascriptExecutor)driver;
		 //js.executeScript("scrollBy(0, 4500)");
		js.executeScript("scrollBy(0,300)");
		js.executeScript("scrollBy(0,700)");
		
	}
	

}
