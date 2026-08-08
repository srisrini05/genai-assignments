package com.salesforce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class CasePage extends ProjectSpecificMethods {


    private String newCaseButton = "//div[@title='New']";
    private String contactNameInput = "//label[text()='Contact Name']/following::input[1]";
    private String newContactButton = "//span[@title='New Contact']";
    private String salutationDropdown = "//label[text()='Salutation']/following::button[1]";
    private String salutationOption = "//span[@title='%s']";
    private String firstNameInput = "//label[text()='First Name']/following::input[1]";
    private String lastNameInput = "//label[text()='Last Name']/following::input[1]";
    private String saveContactButton = "(//button[@name='SaveEdit'])[2]";
    private String caseOriginDropdown = "//label[text()='Case Origin']/following::button[1]";
    private String caseOriginOption = "//span[@title='%s']";
    private String statusDropdown = "//label[text()='Status']/following::button[1]";
    private String statusOption = "//label[text()='Status']/following::button[1]/following::span[@title='%s']";
    private String slaViolationDropdown = "//label[text()='SLA Violation']/following::button[1]";
    private String slaViolationOption = "//label[text()='SLA Violation']/following::button[1]/following::span[text()='%s']";
    private String subjectInput = "//label[text()='Subject']/following::input[1]";
    private String descriptionInput = "//label[text()='Description']/following::textarea[1]";
    private String saveCaseButton = "(//button[@name='SaveEdit'])[1]";
    private String editCaseButton = "//button[text()='Edit']";
    private String deleteCaseButton = "//button[text()='Delete']";
    private String confirmDeleteButton = "//span[text()='Delete']";
    private String toastMessage = "//span[@class='toastMessage slds-text-heading--small forceActionsText']";



    public CasePage clickNewCase() {
        click(locateElement(Locators.XPATH, newCaseButton));
        return this;
    }

    public CasePage clickContactName() {
        click(locateElement(Locators.XPATH, contactNameInput));
        click(locateElement(Locators.XPATH, contactNameInput));
       
        return this;
    }

    public CasePage clickNewContact() {
        click(locateElement(Locators.XPATH, newContactButton));
        return this;
    }

    public CasePage selectSalutation(String salutation) {
        click(locateElement(Locators.XPATH, salutationDropdown));
        click(locateElement(Locators.XPATH, String.format(salutationOption, salutation)));
        reportStep("Selected salutation: " + salutation, "pass");
        return this;
    }

    public CasePage enterFirstName(String firstName) {
        clearAndType(locateElement(Locators.XPATH, firstNameInput), firstName);
        reportStep("Entered first name: " + firstName, "pass");
        return this;
    }

    public CasePage enterLastName(String lastName) {
        clearAndType(locateElement(Locators.XPATH, lastNameInput), lastName);
        reportStep("Entered last name: " + lastName, "pass");
        return this;
    }

    public CasePage clickSave() {
        //verifyDisplayed(locateElement(Locators.XPATH, saveContactButton));
        click(locateElement(Locators.XPATH, saveContactButton));
        return this;
    }

    public CasePage selectCaseOrigin(String origin) {
        clickUsingJs(locateElement(Locators.XPATH, caseOriginDropdown));
        WebElement originOption = locateElement(Locators.XPATH, String.format(caseOriginOption, origin));
        clickUsingJs(originOption);
        return this;
    }

    public CasePage selectStatus(String status) {
        click(locateElement(Locators.XPATH, statusDropdown));
        WebElement statusOpt = locateElement(Locators.XPATH, String.format(statusOption, status));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", statusOpt);
        js.executeScript("arguments[0].click();", statusOpt);
        return this;
    }

    public CasePage slaViolation(String value) {
        click(locateElement(Locators.XPATH, slaViolationDropdown));
        WebElement slaOption = locateElement(Locators.XPATH, String.format(slaViolationOption, value));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", slaOption);
        js.executeScript("arguments[0].click();", slaOption);
        reportStep("SLA Violation set to: " + value, "pass");
        return this;
    }

    public CasePage enterSubject(String subject) {
        clearAndType(locateElement(Locators.XPATH, subjectInput), subject);
        return this;
    }

    public CasePage enterDescription(String description) {
        clearAndType(locateElement(Locators.XPATH, descriptionInput), description);
        return this;
    }

    public CasePage clickSaveCase() {
        click(locateElement(Locators.XPATH, saveCaseButton));
        return this;
    }

    public CasePage clickEdit() {
        verifyDisplayed(locateElement(Locators.XPATH, editCaseButton));
        click(locateElement(Locators.XPATH, editCaseButton));
        return this;
    }

    public CasePage clickDelete() {
        click(locateElement(Locators.XPATH, deleteCaseButton));
        return this;
    }

    public CasePage confirmDeletion() {
        click(locateElement(Locators.XPATH, confirmDeleteButton));
        return this;
    }

    // ----------- Verifications ------------------

    public CasePage verifyCreatedCase(String text) {
        verifyPartialText(locateElement(Locators.XPATH, toastMessage), text);
        reportStep(text + " case is created", "pass");
        return this;
    }

    public CasePage verifyEditCases(String text) {
        verifyPartialText(locateElement(Locators.XPATH, toastMessage), text);
        reportStep(text + " case is edited", "pass");
        return this;
    }

    public CasePage verifyDeleteCases(String text) {
        verifyPartialText(locateElement(Locators.XPATH, toastMessage), text);
        reportStep(text + " case is deleted", "pass");
        return this;
    }

    public CasePage verifyToastMessage(String expectedText) {
        verifyPartialText(locateElement(Locators.XPATH, "//span[contains(text(),'" + expectedText + "')]"), expectedText);
        reportStep("Toast Message verified with: " + expectedText, "pass");
        return this;
    }
}
