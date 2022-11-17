package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInfoPage {

	//initialization
	public CreateOrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath ="//span[@class='dvHeaderText']") private WebElement organisationName;

	public WebElement getOrganisationName() {
		return organisationName;
	}

	
}
