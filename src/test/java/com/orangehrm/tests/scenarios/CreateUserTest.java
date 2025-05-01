package com.orangehrm.tests.scenarios;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends TestBase {
    private static final String EMPLOYEE_NAME = "Orange Test";
    private static final String USERNAME = "testuser" + System.currentTimeMillis();
    private static final String PASSWORD = "Test@123";

    @Test
    public void testCreateUserAndLogin() {
        // Login as admin
        loginPage.loginAsAdmin();
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isAdminMenuDisplayed(), "Admin menu should be displayed after login");

        // Navigate to Admin page and create user
        dashboardPage.clickAdminMenu();
        AdminPage adminPage = new AdminPage();
        adminPage.createUser("ESS", EMPLOYEE_NAME, "Enabled", USERNAME, PASSWORD);
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "User creation success message should be displayed");

        // Logout
        dashboardPage.logout();

        // Login with new user
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(dashboardPage.isDashboardMenuDisplayed(), "New user should be able to login successfully");
    }
} 