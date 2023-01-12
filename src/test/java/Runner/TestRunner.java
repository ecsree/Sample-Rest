package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//src/test/resources/Feature/Get.feature",
		glue = {"api"},
		dryRun=false,
		monochrome=true,
		//tags = {"@smoke or @regression"},
		plugin= {"pretty",
				"html:test-output/Html/reports.html",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
				//"html:test-output", "jason:target/cucumber.jason", test output/Json/ExtentJason.json
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}			
		)
public class TestRunner {

}
