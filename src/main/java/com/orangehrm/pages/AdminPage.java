package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {
    
    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addButton;
    
    @FindBy(xpath = "(//div[contains(@class, 'oxd-select-text-input')])[1]")
    private WebElement userRoleDropdown;
    
    @FindBy(xpath = "(//div[contains(@class, 'oxd-select-text-input')])[2]")
    private WebElement statusDropdown;
    
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameField;
    
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElement usernameField;
    
    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    private WebElement passwordField;
    
    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    private WebElement confirmPasswordField;
    
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;
    
    @FindBy(xpath = "//div[contains(@class, 'oxd-toast-container')]")
    private WebElement successMessage;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-row')]")
    private WebElement tableRow;

    public AdminPage() {
        super();
    }

    public void clickAddButton() {
        click(addButton);
    }

    public void selectUserRole(String role) {
        click(userRoleDropdown);
        WebElement roleOption = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(String.format("//div[contains(@class, 'oxd-select-option') and .//span [text()='%s']]", role))));
        click(roleOption);
    }

    public void selectStatus(String status) {
        click(statusDropdown);
        WebElement statusOption = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(String.format("//div[contains(@class, 'oxd-select-option') and .//span [text()='%s']]", status))));
        click(statusOption);
    }

    public void enterEmployeeName(String name) {
        sendKeys(employeeNameField, name);
        WebElement employeeNameSuggestion = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(String.format("//div[contains(@class, 'oxd-autocomplete-option') and contains(normalize-space(.), '%s')]", name))));
        click(employeeNameSuggestion);
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
        sendKeys(confirmPasswordField, password);
    }

    public void clickSaveButton() {
        click(saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }

    public void createUser(String role, String employeeName, String status, String username, String password) {
        clickAddButton();
        selectUserRole(role);
        enterEmployeeName(employeeName);
        selectStatus(status);
        enterUsername(username);
        enterPassword(password);
        clickSaveButton();
    }

    public void editUserStatus(String userName, String newStatus) {
        //Wait for the table to load
        isElementDisplayed(tableRow);

        // Search for the user
        enterUsername(userName);
        click(searchButton);

        //Wait for the table to load
        isElementDisplayed(tableRow);
        
        // Click the edit button for the user
        WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(String.format("(//div[normalize-space(.)='%s']/ancestor::div[contains(@class, 'oxd-table-row')]//button[.//i[contains(@class, 'oxd-icon') and contains(@class, 'bi-pencil-fill')]])[1]", userName))));
        click(editButton);
        
        // Update the status
        selectStatus(newStatus);
        clickSaveButton();
    }
} 