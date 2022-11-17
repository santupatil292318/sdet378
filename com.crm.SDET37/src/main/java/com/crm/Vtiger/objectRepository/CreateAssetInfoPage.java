package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssetInfoPage {

	public CreateAssetInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//initialization
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement  verifyAsset;

	public WebElement getVerifyAsset() {
		return verifyAsset;
	}
	
}
