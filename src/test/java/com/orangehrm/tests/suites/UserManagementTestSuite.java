package com.orangehrm.tests.suites;

import com.orangehrm.tests.base.TestBase;
import com.orangehrm.tests.scenarios.CreateUserTest;
import com.orangehrm.tests.scenarios.DisableUserTest;
import com.orangehrm.utils.ReportManager;
import org.testng.annotations.Test;

public class UserManagementTestSuite extends TestBase {
    
    @Test(description = "Test case to create a new user and verify login",
          priority = 1)
    public void runCreateUserTest() {
        ReportManager.createTest("Create User Test");
        ReportManager.logInfo("Starting Create User Test");
        
        CreateUserTest createUserTest = new CreateUserTest();
        try {
            createUserTest.setUp();
            createUserTest.testCreateUserAndLogin();
            ReportManager.logPass("Create User Test completed successfully");
        } catch (Exception e) {
            ReportManager.logFail("Create User Test failed: " + e.getMessage());
            throw e;
        } finally {
            createUserTest.tearDown();
        }
    }
    
    @Test(description = "Test case to disable a user and verify login is not possible", 
          priority = 2,
          dependsOnMethods = "runCreateUserTest")
    public void runDisableUserTest() {
        ReportManager.createTest("Disable User Test");
        ReportManager.logInfo("Starting Disable User Test");
        
        DisableUserTest disableUserTest = new DisableUserTest();
        try {
            disableUserTest.setUp();
            disableUserTest.testDisableUserAndVerifyLogin();
            ReportManager.logPass("Disable User Test completed successfully");
        } catch (Exception e) {
            ReportManager.logFail("Disable User Test failed: " + e.getMessage());
            throw e;
        } finally {
            disableUserTest.tearDown();
        }
    }
} 