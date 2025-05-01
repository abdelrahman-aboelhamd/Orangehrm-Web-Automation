package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboardMenu;
    
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;
    
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public DashboardPage() {
        super();
    }

    public void clickAdminMenu() {
        click(adminMenu);
    }

    public void clickPimMenu() {
        click(pimMenu);
    }

    public void logout() {
        click(userDropdown);
        click(logoutButton);
    }

    public boolean isAdminMenuDisplayed() {
        return isElementDisplayed(adminMenu);
    }

    public boolean isDashboardMenuDisplayed() {
        return isElementDisplayed(dashboardMenu);
    }
} 