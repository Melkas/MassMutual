package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AssessmentPage;
import utilities.CompareValues;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ParsCurrency;
import utilities.ValidateCurrency;

public class Steps {
    
	
	WebDriver driver = Driver.getDriver();
	AssessmentPage assessmentPage = new AssessmentPage(driver);
	private Map<String, String> data;
	private Map<String, String> data2;
	
	

	@Given("^Navigate to page \"([^\"]*)\"$")
	public void navigate_to_page(String pageURL) {
		String path = System.getProperty("user.dir");
		if (ConfigurationReader.getProperty("pageURL").equals("mockUpURL")) {
			path="file://"+path+"/src/main/java/index.html";	
		
		}else {
			path=ConfigurationReader.getProperty("pageURL");
		
		}	
	
		driver.get(path);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigurationReader.getProperty("timeOut")), TimeUnit.SECONDS);
	

	}

	@Given("^right count values table as below$")
	public void right_count_values_table_as_below(Map<String, String> data) throws Throwable {
		this.data = data;

	}

	@Then("^values shouldbe same appear on the screen$")
	public void values_shouldbe_same_appear_on_the_screen() throws Throwable {
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Value 1"), assessmentPage.Value1.getAttribute("value"), " Value1 does not match"));
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Value 2"), assessmentPage.Value2.getAttribute("value"), " Value2 does not match"));
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Value 3"), assessmentPage.Value3.getAttribute("value"), " Value3 does not match"));
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Value 4"), assessmentPage.Value4.getAttribute("value"), " Value4 does not match"));
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Value 5"), assessmentPage.Value5.getAttribute("value"), " Value5 does not match"));
		sa.assertTrue(CompareValues.compareValueEquality(data.get("Total Balance"),assessmentPage.TotalBalance.getAttribute("value")," Total Balance does not match"));
		sa.assertAll();
	}

	@Then("verify the values on the screen are greater than (\\d+)$")
	public void verify_the_values_on_the_screen_are_greater_than(int arg1) throws ParseException {

		SoftAssert sa = new SoftAssert();
	    if(assessmentPage.values.size()!=0) {
		for (int i = 0; i < assessmentPage.values.size(); i++) {
            
			if (CompareValues.isGreater(assessmentPage.values.get(i).getAttribute("value").trim())) {
				continue;
			} else {
				Reporter.addStepLog(assessmentPage.valueTexts.get(i).getText() + " is not greater than 0 or not valit format");
				System.out.println(assessmentPage.valueTexts.get(i).getText() + " is not greater than 0 or not valit format");
				sa.assertTrue(false);
			}
		}
	    }else {
	    	 assertTrue(false);
	    }
		sa.assertAll();
	}

	@Then("^verify the total balance is correct based on the values listed on the screen$")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() throws Throwable {

		double totalBalance = ParsCurrency.getDouble(assessmentPage.TotalBalance.getAttribute("value").trim());
		double sumValues = ParsCurrency.getDouble(assessmentPage.Value1.getAttribute("value"))
				+ ParsCurrency.getDouble(assessmentPage.Value2.getAttribute("value").trim())
				+ ParsCurrency.getDouble(assessmentPage.Value3.getAttribute("value").trim())
				+ ParsCurrency.getDouble(assessmentPage.Value4.getAttribute("value").trim())
				+ ParsCurrency.getDouble(assessmentPage.Value5.getAttribute("value").trim());

		
		assertEquals(sumValues, totalBalance);

	}

	@When("^verify the values are formatted as currencies$")
	public void verify_the_values_are_formatted_as_currencies() {
		SoftAssert sa = new SoftAssert();
		 if(assessmentPage.values.size()!=0) {
		for (int i = 0; i < assessmentPage.values.size(); i++) {
      
			if (ValidateCurrency.valCurrency((assessmentPage.values.get(i).getAttribute("value").trim()))) {
				continue;
			} else {
				Reporter.addStepLog(assessmentPage.valueTexts.get(i).getText().trim() + " is not valid formatted as currencies");
				System.out.println(
						assessmentPage.valueTexts.get(i).getText().trim() + " is not valid formatted as currencies");
				sa.assertTrue(false);
			}
		}
		 }else {
			 assertTrue(false);
		 }
		sa.assertAll();
	}

	@Given("^values table as below$")
	public void values_table_as_below(Map<String, String> data2) throws Throwable {
		
		this.data2 = data2;

	}

	@Then("^values sum shouldbe same Total Balance that appear on the screen$")
	public void values_sum_shouldbe_same_Total_Balance_that_appear_on_the_screen() throws Throwable {
		double sum = 0;
		double totalBalance = ParsCurrency.getDouble(assessmentPage.TotalBalance.getAttribute("value").trim());
		for (String key : data2.keySet()) {
			sum += ParsCurrency.getDouble(data2.get(key));

		}
		assertEquals(sum,totalBalance);
	}

	
	
	@After
	public void afterScenario() throws InterruptedException 
	{ 
	    Thread.sleep(2000);
		Driver.closeDriver();
	}	
	
}
