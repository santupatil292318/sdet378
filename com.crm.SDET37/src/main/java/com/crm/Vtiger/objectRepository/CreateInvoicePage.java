package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class CreateInvoicePage extends WebdriverUtility {

	public CreateInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//img[@title='Create Invoice...']") private WebElement createInvoice;
	@FindBy(name = "subject") private WebElement addSubject;
	@FindBy(xpath = "//img[contains(@onclick,'selectC')]") private WebElement selectContact;
	@FindBy(name = "search_text") private WebElement contactName;
	@FindBy(xpath = "//input[contains(@onclick,'callSearch')]") private WebElement searchContact;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectContactName;
	
	//oraganization name
	@FindBy(xpath = "//img[contains(@onclick,'return ')]") private WebElement selectOrganisation;
	@FindBy(name = "search_text") private WebElement organisationname;
	@FindBy(xpath = "//input[contains(@onclick,'callSearch')]") private WebElement searchOrganization;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectOrganization;
	@FindBy(xpath = "//input[@value='U']") private WebElement userRadio;

	//search sales
	@FindBy(xpath = "//img[contains(@onclick,'selectSalesOrder()')]") private WebElement searchSalesOrder;
	@FindBy(name = "search_field") private WebElement selesDropdownselect;
	@FindBy(name = "search_text") private WebElement InputsalesOrder;
	@FindBy(xpath = "//input[contains(@onclick,'callSearch')]") private WebElement searchOrder;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectSales;
	
	//billing address
	@FindBy(xpath = "//textarea[@name='bill_street']") private WebElement billingAddress;
	@FindBy(name = "ship_street") private WebElement shipStreet;
	@FindBy(id = "searchIcon1") private WebElement searchiconitem;
	@FindBy(id = "search_txt") private WebElement searchfieldLineItem;
	@FindBy(name = "search") private WebElement searchItem;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectLineitem;
	
	//quantity
	@FindBy(id = "qty1") private WebElement quantity;
	@FindBy(id = "listPrice1") private WebElement listPrice1;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveinvoiceBtn;
	
	
	//utilization
	
	public WebElement getCreateInvoice() {
		return createInvoice;
	}
	public WebElement getAddSubject() {
		return addSubject;
	}
	
	public void subject(String invoicesubject)
	{
		addSubject.sendKeys(invoicesubject);
	}
	
	public WebElement getSelectContact() {
		return selectContact;
	}
	public WebElement getContactName() {
		return contactName;
	}
	public WebElement getSearchContact() {
		return searchContact;
	}
	public WebElement getSelectContactName() {
		return selectContactName;
	}
	
	public void selectcontact(WebDriver driver,String url,String contactlastname)
	{
		selectContact.click();
		switchTowindow(url, driver);
		contactName.sendKeys(contactlastname);
		searchContact.click();
		selectContactName.click();
	}
	
	//select Organization
	public WebElement getSelectOrganisation() {
		return selectOrganisation;
	}
	public WebElement getOrganisationname() {
		return organisationname;
	}
	public WebElement getSearchOrganization() {
		return searchOrganization;
	}
	public WebElement getSelectOrganization() {
		return selectOrganization;
	}
	
	public void Selectoragnization(WebDriver driver,String url,String organization)
	{
		selectOrganisation.click();
		switchTowindow(url, driver);
		organisationname.sendKeys(organization);
		searchOrganization.click();
		selectOrganization.click();
	}
	
	public WebElement getUserRadio() {
		return userRadio;
	}
	
	//salesoder
	public WebElement getSearchSalesOrder() {
		return searchSalesOrder;
	}
	public WebElement getSelesDropdownselect() {
		return selesDropdownselect;
	}
	
	public void salesdropdown(String value)
	{
		select(selesDropdownselect, value);
	}
	public WebElement getInputsalesOrder() {
		return InputsalesOrder;
	}
	public void inputsalesOrder(String value)
	{
		InputsalesOrder.sendKeys(value);
	}
	
	public WebElement getSearchOrder() {
		return searchOrder;
	}
	public WebElement getSelectSales() {
		return selectSales;
	}
	public WebElement getBillingAddress() {
		return billingAddress;
	}
	
	public void BillingAddress(String value)
	{
		billingAddress.sendKeys(value);
	}
	
	public WebElement getShipStreet() {
		return shipStreet;
	}
	
	public void ShipStreet(String value)
	{
		shipStreet.sendKeys(value);
	}
	
	public WebElement getSearchiconitem() {
		return searchiconitem;
	}
	public void searchiconitem(WebDriver driver,String url)
	{
		searchiconitem.click();
		switchTowindow(url, driver);
	}
	
	public WebElement getSearchfieldLineItem() {
		return searchfieldLineItem;
	}
	public void searchfieldLineitem(String value)
	{
		searchfieldLineItem.sendKeys(value);
	}
	public WebElement getSearchItem() {
		return searchItem;
	}
	public WebElement getSelectLineitem() {
		return selectLineitem;
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public void Quantity(String value)
	{
		quantity.sendKeys(value);
	}
	
	public WebElement getListPrice1() {
		return listPrice1;
	}

	
	public WebElement getSaveinvoiceBtn() {
		return saveinvoiceBtn;
	}
	public void listPrice1(String value) {
		listPrice1.sendKeys(value);
		
	}
	
	
	
	
	
}
