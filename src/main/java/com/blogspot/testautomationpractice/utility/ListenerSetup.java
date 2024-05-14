package com.blogspot.testautomationpractice.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.blogspot.testautomationpractice.TestBase.TestBase;

public class ListenerSetup extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Case execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		log.info("Test Case execution is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Case is failed");
		Long currentTimeMillis=System.currentTimeMillis();
		Date dt=new Date(currentTimeMillis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formattedDate = dateFormat.format(dt);
		Utility.getScreenShot(result.getName()+formattedDate);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		log.info("Test Case is skipped");
	}

	@Override public void onStart(ITestContext context) {
		log.info("Testing is started");

	}

	@Override public void onFinish(ITestContext context) {
		log.info("Testing is Ended");

	}




}
