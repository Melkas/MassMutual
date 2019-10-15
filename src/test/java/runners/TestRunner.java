package runners;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utilities.ConfigurationReader;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"/Users/Mustafa/eclipse-workspace/MassMutualAssessment/features"}, 
                   glue = {"stepDefinitions" },
                   monochrome=true, 
                   plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty" })



public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(ConfigurationReader.getReportConfigPath()));
	}


}


