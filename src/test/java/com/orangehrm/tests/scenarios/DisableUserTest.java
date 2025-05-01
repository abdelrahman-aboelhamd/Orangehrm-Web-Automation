package com.orangehrm.tests.scenarios;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableUserTest extends TestBase {
    private static final String EMPLOYEE_NAME = "Orange Test";
    private static final String USERNAME = "testuser" + System.currentTimeMillis();
    private static final String PASSWORD = "Test@123";

    @Test
    public void testDisableUserAndVerifyLogin() {
        // Step 1: Login with admin credentials
        loginPage.loginAsAdmin();
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isAdminMenuDisplayed(), "Admin menu should be displayed after login");

        // Step 2: Click on admin in left menu
        dashboardPage.clickAdminMenu();
        AdminPage adminPage = new AdminPage();

        // Step 3: Create a user first (since we need to edit it)
        adminPage.createUser("ESS", EMPLOYEE_NAME, "Enabled", USERNAME, PASSWORD);
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "User creation success message should be displayed");

        // Step 4: Click on edit with employee name and select Disabled
        adminPage.editUserStatus(USERNAME, "Disabled");
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "User status update success message should be displayed");

        // Step 5: Click on Admin Profile and Logout
        dashboardPage.logout();

        // Step 6: Login with employee credentials
        loginPage.login(USERNAME, PASSWORD);

        // Step 7: Validate that employee is disabled
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for disabled user");
        Assert.assertEquals(loginPage.getErrorMessage(), "Account disabled", "Error message should indicate account is disabled");
    }
} 