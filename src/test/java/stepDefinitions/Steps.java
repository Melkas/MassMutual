package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.text.ParseException;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.AssessmentPage;
import utilities.Driver;
import utilities.ParsCurrency;
import utilities.ValidateCurrency;

public class Steps {
	
	WebDriver driver= Driver.getDriver();
	AssessmentPage assessmentPage= new AssessmentPage(driver);

	@Given("^Navigate to page \"([^\"]*)\"$")
	public void navigate_to_page(String pageURL)  {
		driver.get(pageURL);

	}

	@When("^verify value table as below$")
	public void verify_value_table_as_below(DataTable table)  {
       
		/* TextBox value attribute name had not given.
		 * I don't use  assessmentPage.Value1.getAttribute(?);  	
		*/
		
		Map<String, String> data = table.asMap(String.class, String.class);
		Assert.assertEquals(data.get("Value1"), assessmentPage.Value1.getText().trim());
		Assert.assertEquals(data.get("Value2"), assessmentPage.Value2.getText().trim());
		Assert.assertEquals(data.get("Value3"), assessmentPage.Value3.getText().trim());
		Assert.assertEquals(data.get("Value4"), assessmentPage.Value4.getText().trim());
		Assert.assertEquals(data.get("Value5"), assessmentPage.Value5.getText().trim());

	}

	@When("verify the values on the screen are greater than (\\d+)$")
	public void verify_the_values_on_the_screen_are_greater_than(int arg1)  {
		try {
			assertTrue(ParsCurrency.getDouble((assessmentPage.Value1.getText().trim())) > arg1);
			assertTrue(ParsCurrency.getDouble((assessmentPage.Value2.getText().trim())) > arg1);
			assertTrue(ParsCurrency.getDouble((assessmentPage.Value3.getText().trim())) > arg1);
			assertTrue(ParsCurrency.getDouble((assessmentPage.Value4.getText().trim())) > arg1);
			assertTrue(ParsCurrency.getDouble((assessmentPage.Value5.getText().trim())) > arg1);
			assertTrue(ParsCurrency.getDouble((assessmentPage.TotalBalance.getText().trim())) > arg1);

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Invalid value");
			assertTrue(false);
		}

	}

	@When("^verify the total balance is correct based on the values listed on the screen$")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen(DataTable table) {
		try {
			Map<String, String> data = table.asMap(String.class, String.class);
			Assert.assertEquals(data.get("TotalBalance"), assessmentPage.TotalBalance.getText());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid value");
			assertTrue(false);

		}
	}

	@When("^verify the values are formatted as currencies$")
	public void verify_the_values_are_formatted_as_currencies() {

		assertTrue(ValidateCurrency.valCurrency(assessmentPage.Value1.getText().trim()));
		assertTrue(ValidateCurrency.valCurrency(assessmentPage.Value2.getText().trim()));
		assertTrue(ValidateCurrency.valCurrency(assessmentPage.Value3.getText().trim()));
		assertTrue(ValidateCurrency.valCurrency(assessmentPage.Value4.getText().trim()));
		assertTrue(ValidateCurrency.valCurrency(assessmentPage.Value5.getText().trim()));
		assertTrue(ValidateCurrency.valCurrency(assessmentPage.TotalBalance.getText()));
	}

	@When("^verify the total balance matches the sum of the values$")
	public void verify_the_total_balance_matches_the_sum_of_the_values() {
		double sum = 0.0;

		try {
			sum = ParsCurrency.getDouble(assessmentPage.Value1.getText())
					+ ParsCurrency.getDouble(assessmentPage.Value2.getText().trim())
					+ ParsCurrency.getDouble(assessmentPage.Value3.getText().trim())
					+ ParsCurrency.getDouble(assessmentPage.Value4.getText().trim())
					+ ParsCurrency.getDouble(assessmentPage.Value5.getText().trim());

			assertEquals(sum, ParsCurrency.getDouble(assessmentPage.TotalBalance.getText().trim()));

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Invalid value");
			assertTrue(false);

		}
	}

}
