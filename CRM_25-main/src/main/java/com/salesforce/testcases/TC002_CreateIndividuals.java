package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC002_CreateIndividuals extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "TC002_CreateIndividuals";
		testDescription ="Verify that Individual records can be created successfully using provided data";
		authors="Hari";
		category ="Regression";
		excelFileName="CreateIndividuals";
		
	}
	
	@Test( dataProvider = "fetchData")
	public void runLogin(String search,String fName,String lName) {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickAppLauncher()
		.clickViewAll()
		.enterSearchField(search)
		.clickIndividualsLink()
		.clickNewButton()
		.selectSalutation()
		.enterFirstName(fName)
		.enterLastName(lName)
		.clickSaveButton()
		.verifyCreateIndividuals(lName);
	

	}

}
