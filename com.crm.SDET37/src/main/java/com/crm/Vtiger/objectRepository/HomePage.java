package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class HomePage extends WebdriverUtility {

	//initiliazation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//a[.='Organizations']") private WebElement OrganizationsLink;
	@FindBy(xpath = "//a[text()='Contacts']") private WebElement contactsLink;
	@FindBy(linkText = "Opportunities") private WebElement OpportunitiesLink;
	@FindBy(linkText = "Products") private WebElement ProductsLink;
	@FindBy(linkText = "Documents") private WebElement DocumentsLink;
	@FindBy(linkText = "Email") private WebElement EmailLink;
	@FindBy(linkText = "More") private WebElement MoreLink;
	@FindBy(linkText ="Assets") private WebElement assets;
	@FindBy(name = "Invoice") private WebElement invoice;
	@FindBy(name = "Sales Order") private WebElement salesOrder;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']") private WebElement administartionLink;
	@FindBy(xpath ="//a[.='Sign Out']") private WebElement signOutBtn;
	
	

	


	

	//Utilization
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	
	
	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	public void getContacts()
	{
		contactsLink.click();
	}
	
	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	
	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}
	
	public WebElement getEmailLink() {
		return EmailLink;
	}
	
	public WebElement getMoreLink() {
		return MoreLink;
	}
	
	
	
	public WebElement getAssets() {
		return assets;
	}

	public void Assets(WebDriver driver)
	{
	
		assets.click();
	}

	public WebElement getAdministartionLink() {
		return administartionLink;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	public WebElement getInvoice() {
		return invoice;
	}
	
	public WebElement getSalesOrder() {
		return salesOrder;
	}

	
	public void Logout(WebDriver driver)
	{
		mousehoverOnelement(driver, administartionLink);
		getSignOutBtn().click();
	}
	
	public void More(WebDriver driver)
	{
		mousehoverOnelement(driver, DocumentsLink);
		MoreLink.click();
	}
}
