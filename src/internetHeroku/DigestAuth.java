package internetHeroku;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class DigestAuth {

	public static void main(String[] args) throws InterruptedException {
		// Initiate Chrome driver 
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		((HasAuthentication)driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/digest_auth");
		
		
	}

}
