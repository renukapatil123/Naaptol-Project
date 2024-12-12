package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.Screenshot;

public class Listener extends BaseTest implements ITestListener{
	
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+"started");
      }
    public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName());
	}
    public void onTestFailure(ITestResult result) {
    	test.log(Status.FAIL, result.getName());
    	
    	try {
    		Screenshot.clickScreenShot(driver, result.getName());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    public void onFinish(ITestResult result) {
    	reports.flush();
    	driver.close();
    }
    public void onStart(ITestResult result) {
    	 Reports.createReport();
    	
    }
}
