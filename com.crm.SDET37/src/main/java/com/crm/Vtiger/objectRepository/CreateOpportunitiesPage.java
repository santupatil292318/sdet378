package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class CreateOpportunitiesPage extends WebdriverUtility {

	public CreateOpportunitiesPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	//initialization
	@FindBy(xpath = "//img[@title='Create Opportunity...']") private WebElement createOpportunity;
	@FindBy(name = "potentialname") private WebElement opportunityName;
	@FindBy(id = "related_to_type") private WebElement RelatedDropdown;
	@FindBy(xpath = "//img[contains(@onclick,'return window.open(\"index.php?module=\"')]") private WebElement creatcontactElement;
	@FindBy(id = "search_txt") private WebElement searchContact;
	@FindBy(name = "search") private WebElement searchcontactBtn;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectContact;
	@FindBy(xpath = "//img[contains(@onclick,'return window.open(\"index.php?module=C')]") private WebElement campaignplusClick;
	@FindBy(id = "search_txt") private WebElement searchcampaignContacts;
	@FindBy(name = "search") private WebElement searchcampagnBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectCampaignContacts;
	@FindBy(id = "jscal_trigger_closingdate") private WebElement clickCalender;
	@FindBy(xpath = "//div[@class='calendar']//tbody//tr[3]//td[7]") private WebElement changeThedate;
	@FindBy(name = "button") private WebElement saveBtn;
	
	
	//declaration
	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}
	public WebElement getOpportunityName() {
		return opportunityName;
	}
	
	public void opportunityName(String opportunityname)
	{
		opportunityName.sendKeys(opportunityname);
	}
	
	public WebElement getRelatedDropdown() {
		return RelatedDropdown;
	}
	
	public void Relateddropdown(String Contacts)
	{
		select(RelatedDropdown, "Contacts");
	}
	
	public WebElement getCreatcontactElement() {
		return creatcontactElement;
	}
	public WebElement getSearchContact() {
		return searchContact;
	}
	
	public void searchcontact(String element) {
		searchContact.sendKeys(element);
	}
	
	public WebElement getSearchcontactBtn() {
		return searchcontactBtn;
	}
	public WebElement getSelectContact() {
		return selectContact;
	}
	public WebElement getCampaignplusClick() {
		return campaignplusClick;
	}
	public WebElement getSearchcampaignContacts() {
		return searchcampaignContacts;
	}
	
	public void searchcampaincontact(String lastName)
	{
		searchcampaignContacts.sendKeys(lastName);
	}
	
	public WebElement getSearchcampagnBtn() {
		return searchcampagnBtn;
	}
	public WebElement getSelectCampaignContacts() {
		return selectCampaignContacts;
	}
	public WebElement getClickCalender() {
		return clickCalender;
	}
	public WebElement getChangeThedate() {
		return changeThedate;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
