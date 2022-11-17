package com.crm.Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsTestcasePage {

	public DocumentsTestcasePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Document...']") private WebElement createdocument;
	@FindBy(name = "notes_title") private WebElement titleName;
	@FindBy(xpath = "//body[@class=\"cke_show_borders\"]") private WebElement contactName;
	@FindBy(name = "filename") private WebElement fileName;
	@FindBy(name = "button") private WebElement documentBtn;
	
	//utilization
	public WebElement getCreatedocument() {
		return createdocument;
	}
	public WebElement getTitleName() {
		return titleName;
	}
	
	public void titleName(String document)
	{
		titleName.sendKeys(document);
	}
	
	public WebElement getContactName() {
		return contactName;
	}
	
	public void contactName(String contact)
	{
		contactName.sendKeys(contact);
	}
	
	public WebElement getFileName() {
		return fileName;
	}
	
	public void fileName(String file)
	{
		fileName.sendKeys(file);
	}
	
	public WebElement getDocumentBtn() {
		return documentBtn;
	}
	
	
	
}
