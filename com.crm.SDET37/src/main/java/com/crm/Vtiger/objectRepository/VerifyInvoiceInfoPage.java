package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyInvoiceInfoPage {

	public VerifyInvoiceInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "dtlview_Subject") private WebElement verifyInvoice;


	public WebElement getVerifyInvoice() {
		return verifyInvoice;
	}


}
