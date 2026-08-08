package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage enterUsername() {
		type(locateElement(Locators.ID, "username"), username);
		reportStep(" entered successfully", "pass");
		return this;
	}

	public LoginPage enterPassword() {
		clearAndType(locateElement(Locators.ID, "password"), password);
		reportStep(" entered successfully", "pass");
		return this;
	}

	public HomePage clickLogin() {
		click(locateElement(Locators.ID, "Login"));
		reportStep("Login button clicked successfully", "pass");
		return new HomePage();
	}

}
