package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;				
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class CreateAssetsPage extends WebdriverUtility {

	public CreateAssetsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Asset...']") private WebElement createasset;
	@FindBy(id = "asset_no") private WebElement assetNumber;
	@FindBy(name = "serialnumber") private WebElement serialNumber;
	@FindBy(id = "jscal_trigger_datesold") private WebElement dateSold;
	@FindBy(xpath = "//td[text()='18']") private WebElement datetext;
	@FindBy(name = "assetstatus") private WebElement statusdropDown;
	@FindBy(xpath ="//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.a')]")
	private WebElement customerlookUp;
	@FindBy(name ="search_text") private WebElement customername;
	@FindBy(xpath ="//input[contains(@onclick,'callSearch')]") private WebElement searchCustomername;
	@FindBy(xpath ="//a[@href='javascript:window.close();']") private WebElement selectCustomername;
	
	
	//To select Invoice
	@FindBy(xpath = "//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.i')]")
	private WebElement toSelectInvoiceLink;
	@FindBy(name ="search_field") private WebElement salesoderDropDown;
	@FindBy(name ="search_text") private  WebElement invoiceSubjectEdt;
	@FindBy(xpath ="//input[contains(@onclick,'callSearch')]") private WebElement searchsalesOrder;
	@FindBy(xpath ="//a[@href='javascript:window.close();']") private WebElement selectSalesoder;
	
	//To select product
	@FindBy(xpath ="//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.p')]")
	private WebElement selectProduct;
	@FindBy(name ="search_text") private WebElement productName;
	@FindBy(xpath ="//input[contains(@onclick,'callSearch')]") private WebElement searchproductName;
	@FindBy(xpath ="//a[@href='javascript:window.close();']") private WebElement selectproductName;
	@FindBy(xpath = "//input[@value='U']") private WebElement userradioBtn;
	
	//To click date On service
	@FindBy(id = "jscal_trigger_dateinservice") private WebElement dateInService;
	@FindBy(xpath = "(//tr//td[text()='18'])[2]") private WebElement clickOndate;
	@FindBy(name = "assetname") private WebElement assetName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveAssetBtn;
	
	
	
	
	//utilization
	public WebElement getCreateasset() {
		return createasset;
	}
	public WebElement getAssetNumber() {
		return assetNumber;
	}
	
	public void assetnumber(String assetnumber)
	{
		assetNumber.sendKeys(assetnumber);
	}
	public WebElement getSerialNumber() {
		return serialNumber;
	}
	
	public void serialnumber(String serialnumber)
	{
		serialNumber.sendKeys(serialnumber);
	}
	
	public WebElement getDateSold() {
		return dateSold;
	}
	public WebElement getDatetext() {
		return datetext;
	}
	public WebElement getStatusdropDown() {
		return statusdropDown;
	}
	
	public void statusDropdown(String assetstatus)
	{
		select(statusdropDown, assetstatus);
	}
	public WebElement getcustomerlookUp() {
		return customerlookUp;
	}
	public WebElement getcustomername() {
		return customername;
	}
	
	public void customername(String customerName)
	{
		customername.sendKeys(customerName);
	}
	
	public WebElement getSearchCustomername() {
		return searchCustomername;
	}
	public WebElement getSelectCustomername() {
		return selectCustomername;
	}
	public WebElement getToSelectInvoiceLink() {
		return toSelectInvoiceLink;
	}
	
	public void selectInvoice(WebDriver driver, String invoice)
	{
		toSelectInvoiceLink.click();
		switchTowindow("Invoice&action", driver);
	}
	
	public WebElement getSalesoderDropDown() {
		return salesoderDropDown;
	}
	
	public void salesorderDropdown(String subject)
	{
		select(salesoderDropDown, subject);
	}
	
	public WebElement getInvoiceSubjectEdt() {
		return invoiceSubjectEdt;
	}
	
	public void invoiceSubjectEdt(String invoice)
	{
		invoiceSubjectEdt.sendKeys(invoice);
	}
	
	public WebElement getSearchsalesOrder() {
		return searchsalesOrder;
	}
	public WebElement getSelectSalesoder() {
		return selectSalesoder;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getProductName() {
		return productName;
	}
	
	public void productname(String customerName)
	{
		productName.sendKeys(customerName);
	}
	
	public WebElement getSearchproductName() {
		return searchproductName;
	}
	public WebElement getSelectproductName() {
		return selectproductName;
	}
	
	public WebElement getUserradioBtn() {
		return userradioBtn;
	}
	
	//To click date on service
	public WebElement getDateInService() {
		return dateInService;
	}
	public WebElement getClickOndate() {
		return clickOndate;
	}
	public WebElement getAssetName() {
		return assetName;
	}
	
	public void assetName(String assetname)
	{
		assetName.sendKeys(assetname);
	}
	
	public WebElement getSaveAssetBtn() {
		return saveAssetBtn;
	}
	
	
	
	
	
}
