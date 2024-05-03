package Practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {

	public static void main(String[] args) {
		
		ExtentSparkReporter extentSparkReporter =  new ExtentSparkReporter("./Snaps/Test.html");
		
		ExtentReports extent = new ExtentReports();
		 extent.attachReporter(extentSparkReporter);
		 
		 ExtentTest test = 		extent.createTest("TestName");
		 test.pass("Login");
		 test.fail("Killed");

		extent.flush();
		
		
		
	}

}
