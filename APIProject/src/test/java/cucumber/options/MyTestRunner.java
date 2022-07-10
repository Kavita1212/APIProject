package cucumber.options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\SeleniumminiProject\\APIMiniProject\\APIProject\\src\\test\\java\\features\\Login_Register_Update.feature", 
glue = {"stepDefinitions" }, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/report.html" }, 
monochrome = true, 
strict = false, 
dryRun = false
//        tags= {"@Register"}
)

public class MyTestRunner {

}
