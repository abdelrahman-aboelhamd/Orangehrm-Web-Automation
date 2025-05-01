package com.orangehrm.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final String REPORT_PATH = "test-output/ExtentReports/";

    public static void initReports() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "OrangeHRM-Test-Report-" + timeStamp + ".html";
        
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH + reportName);
        sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
        sparkReporter.config().setReportName("User Management Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "OrangeHRM");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flushReports() {
        extent.flush();
    }
} 