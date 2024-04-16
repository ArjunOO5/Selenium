package internetHeroku;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLess {

	public static void main(String[] args) {
		//Initiate Chrome Driver
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//open Url
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println(driver.getCurrentUrl());
	}

}
