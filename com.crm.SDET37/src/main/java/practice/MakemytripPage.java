package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakemytripPage {

	//declaration
	@FindBy(xpath = "//i[@class='wewidgeticon we_close']") private WebElement popupbanner;
	@FindBy(xpath = "//label[@for='fromCity']") private WebElement fromcity;
	@FindBy(xpath = "//label[@for='toCity']") private WebElement toCity;
	@FindBy(xpath = "//span[@class='lbl_input latoBold appendBottom10' and contains(.,'RETURN')]")
	private WebElement returnele;
	@FindBy(xpath = "//a[.='Search']") private WebElement searchele;
	@FindBy(xpath = "//p[.='Popular Filters']/parent::div[@class='filtersOuter']/descendant::label[@class='makeFlex spaceBetween appendBottom12 pointer ' and contains(.,'IndiGo')]/descendant::span[@class='box']")
	private WebElement popularfilter;
	@FindBy(xpath = "//button[.='Book Now']") private WebElement btnclick;
	@FindBy(xpath = "//p[text()='Flexi Plus']") private WebElement flexiplus;
	@FindBy(xpath = "//button[text()='Continue']") private WebElement continuebtn;
	//initialization
	public MakemytripPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getpopupbanner()
	{
		return popupbanner;
	}
	public WebElement getfromcity()
	{
		return fromcity;
	}
	public WebElement gettoCity()
	{
		return toCity;
	}
	public WebElement getreturnele()
	{
		return returnele;
	}
	public WebElement getsearchele()
	{
		return searchele;
	}
	public WebElement getpopularfilter()
	{
		return popularfilter;
	}
	public WebElement getbtnclick()
	{
		return btnclick;
	}
	public WebElement getflexiplus()
	{
		return flexiplus;
	}
	public WebElement getcontinuebtn()
	{
		return continuebtn;
	}
}
