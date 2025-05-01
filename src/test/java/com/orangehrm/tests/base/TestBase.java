package com.orangehrm.tests.base;

import com.orangehrm.drivers.WebDriverFactory;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected LoginPage loginPage;

    @BeforeSuite
    public void initReport() {
        ReportManager.initReports();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.getDriver();
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        ReportManager.flushReports();
    }
} 