package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/AmazonReport", "json:target/AmazonJsonReport.json"},
                 features = {"src/main/java/Feature"},
                 glue = {"StepDef"},
                 tags = {"@SmokeSuite"},
                 monochrome = true
		
		)

public class runner {

}
