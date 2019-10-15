package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AssessmentPage {

	WebDriver driver;
	
	public AssessmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "txt_val_1") 
	public WebElement Value1;
	
	@FindBy(how = How.ID, using = "txt_val_2")
	public WebElement Value2;

	@FindBy(how = How.ID, using = "txt_val_4") 
	public WebElement Value3;
	
	@FindBy(how = How.ID, using = "txt_val_5") 
	public WebElement Value4; 
	
	@FindBy(how = How.ID, using = "txt_val_6") 
	public WebElement Value5; 
	
	@FindBy(how = How.ID, using = "txt_ttl_val") 
	public WebElement TotalBalance;

	@FindBy(xpath="//*[contains(@id,'txt_val') or contains(@id,'txt_ttl')]")
    public List<WebElement> values;
	
	@FindBy(xpath="//*[contains(@id,'lbl_val') or contains(@id,'lbl_ttl')]")
	public List<WebElement> valueTexts;
	
	
	
}

