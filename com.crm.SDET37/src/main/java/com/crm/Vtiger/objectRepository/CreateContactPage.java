package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtilities.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility {

	//initialization
		public CreateContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		

		//declaration
		@FindBy(xpath ="//img[@alt='Create Contact...']") private WebElement creatContactLink;
		
		@FindBy(name ="salutationtype") private WebElement firstNamedropdown;
		
		@FindBy(name ="firstname") private WebElement firstnameEdt;
		
		@FindBy(name ="lastname") private WebElement lastnameEdt;

		@FindBy(xpath ="//img[contains(@onclick,'return wi')]") private WebElement createOganizationPlusLink;
		
		@FindBy(xpath ="//input[@name='search_text']") private WebElement searchOrganization;
		
		@FindBy(name ="search") private WebElement searchBtn;
		
		@FindBy(xpath ="//a[@href='javascript:window.close();']") private WebElement searchAndClickorg;
		
		@FindBy(name ="leadsource") private WebElement leadsource;
		
		@FindBy(id ="email") private WebElement emailEdt;
		
		@FindBy(name ="button") private WebElement saveBtn;
		


		//declaration
		public WebElement getFirstNamedropdown() {
			return firstNamedropdown;
		}

		public WebElement getEmailEdt() {
			return emailEdt;
		}

		public WebElement getCreatContactLink() {
			return creatContactLink;
		}

		
		public WebElement getFirstname() {
			return firstnameEdt;
		}

		public WebElement getLastname() {
			return lastnameEdt;
		}
		
		public WebElement getFirstnameEdt() {
			return firstnameEdt;
		}
		

		public WebElement getLeadsource() {
			return leadsource;
		}

		public WebElement getLastnameEdt() {
			return lastnameEdt;
		}

		public WebElement getCreateOganizationPlusLink() {
			return createOganizationPlusLink;
		}

		public WebElement getSearchOrganization() {
			return searchOrganization;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getSearchAndClickorg() {
			return searchAndClickorg;
		}
		
		public void firstName(String salutationtype)
		{
			select(salutationtype, firstNamedropdown);
		}
		
		public void createcontact(String firstName,String lastName )
		{
			firstnameEdt.sendKeys(firstName);
			lastnameEdt.sendKeys(lastName);
		}
		
		public void leadsource(String leadsourc)
		{
			select(leadsource, leadsourc);
		}
		
		public void selectOrganization(WebDriver driver,String orgname)
		{
			createOganizationPlusLink.click();
			switchTowindow("Accounts&action", driver);
			searchOrganization.sendKeys(orgname);
			searchBtn.click();
			searchAndClickorg.click();
		}
		
		public void email(String email)
		{
			emailEdt.sendKeys(email);
		}
		
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		public void saveBtn()
		{
			saveBtn.click();
		}
}
