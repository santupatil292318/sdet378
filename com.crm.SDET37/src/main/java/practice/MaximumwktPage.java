package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaximumwktPage {

	@FindBy(xpath = "//a[@title='South Africa v India - 3rd ODI']")
	private WebElement slkpakwomen;
	@FindBy(xpath = "//a[text()='Scorecard']") private WebElement scorecardlnk;
	@FindBy(xpath = "//div[@url='/api/html/cricket-scorecard/50963']/descendant::a[contains(.,' Washington Sundar ')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::a[@class='cb-text-link']")
	private WebElement bowlersname;
	
	//initialization
	public MaximumwktPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSlkpakwomen() {
		return slkpakwomen;
	}
	
	public WebElement getscorecardlnk()
	{
		return scorecardlnk;
	}
	
	public WebElement getbowlrsname()
	{
		return bowlersname;
	}
	
}
