package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOpportunityInfoPage {

	public VerifyOpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Opportunity Name") private WebElement name;

	public WebElement getName() {
		return name;
	}
	
}
