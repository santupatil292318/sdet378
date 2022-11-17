package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {

	public EmailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(linkText = "Compose") private WebElement compose;
	@FindBy(xpath = "//img[@title='Select']") private WebElement inputValue;
	 //contact & action
	@FindBy(name = "search_text") private WebElement searchcontactelement;
	@FindBy(name = "search") private WebElement searchBtn;
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selectContact;
	
	 //email
	@FindBy(id = "cc_name") private WebElement ccValue;
	@FindBy(name = "subject") private WebElement subject;
	@FindBy(id = "my_file_element") private WebElement selectFile;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtn;

	public WebElement getCompose() {
		return compose;
	}

	public WebElement getInputValue() {
		return inputValue;
	}

	 //contact & action
	public WebElement getSearchcontactelement() {
		return searchcontactelement;
	}

	public void searchcontact(String contactname)
	{
		searchcontactelement.sendKeys(contactname);
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectContact() {
		return selectContact;
	}
	
	//email

	public WebElement getCcValue() {
		return ccValue;
	}
	
	public void ccname(String email)
	{
		ccValue.sendKeys(email);
	}

	public WebElement getSubject() {
		return subject;
	}
	
	public void subject(String subjectName)
	{
		subject.sendKeys(subjectName);
	}

	public WebElement getSelectFile() {
		return selectFile;
	}
	
	public void file(String file)
	{
		selectFile.sendKeys(file);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
