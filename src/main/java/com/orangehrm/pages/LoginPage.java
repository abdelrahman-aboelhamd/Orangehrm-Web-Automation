package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.orangehrm.config.ConfigurationManager;

public class LoginPage extends BasePage {
    
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement errorMessage;

    public LoginPage() {
        super();
    }

    public void navigateToLoginPage() {
        driver.get(ConfigurationManager.getBaseUrl());
    }

    public void login(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(loginButton);
    }

    public void loginAsAdmin() {
        login(ConfigurationManager.getAdminUsername(), ConfigurationManager.getAdminPassword());
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
} 