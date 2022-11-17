package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class CreateOrganizationPage extends WebdriverUtility {

	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath ="//img[@alt='Create Organization...']") private WebElement creatOrganizationLink;
	
	@FindBy(name ="accountname") private WebElement organizationName;
	
	@FindBy(name ="website") private WebElement websitename;

	@FindBy(name ="industry") private WebElement industryDropdown;
	
	@FindBy(name ="accounttype") private WebElement typeDropDown;
	
	@FindBy(name ="button") private WebElement saveBtn;
	
	
	
	
	//utilization
	public WebElement getCreatOrganizationLink() {
		return creatOrganizationLink;
	}
	public WebElement getOrganizationName() {
		return organizationName;
	}
	
	public WebElement getWebsitename() {
		return websitename;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	public void selectTypeDropDown(String accounttype) {
		select(typeDropDown, accounttype);
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void websiteName(String website)
	{
		websitename.sendKeys(website);
	}
		
	public void industrydropdown(String industry) {
		select(industryDropdown, industry);
	}
	
	
	public void createOrganization(String name)
	{
		
		organizationName.sendKeys(name);
	}
	 
	public void industryDropDown(String industrydropdown)
	{
		select(industryDropdown, industrydropdown);
	}
	
	public void typeDropDown(String accounttype)
	{
		select(accounttype, typeDropDown);
	}
}
