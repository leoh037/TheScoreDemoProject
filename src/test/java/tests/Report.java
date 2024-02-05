package tests;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {

	public static String reportFileName, testName, testDescription;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void reportSetup() {
		Date dateTimeStamp = new Date();
		reportFileName = "theScore_Execution_Report_" + dateTimeStamp.toString().replaceAll(":", "_").replaceAll(" ", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/" + reportFileName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public void reportTeardown() {
		extent.flush();
	}
	
	public static void logStep(ExtentTest test, String testStatus, String description) {
		try {
			switch (testStatus.toUpperCase()) {
			case "PASS":
				test.log(Status.PASS, description);
				break;
			case "FAIL":
				test.log(Status.FAIL, description);
				// throw new RuntimeException("FAILED");
				break;
			case "INFO":
				test.log(Status.INFO, description);
				break;
			case "WARNING":
				test.log(Status.WARNING, description);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
