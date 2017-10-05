package ui.StepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 
				features = {"src/test/resources/features/"}, 
                plugin = { "pretty","json:target/cucumber.json", "html:target/site/cucumber-pretty"},
                glue = {"ui.StepDefinitions"},
                
                
                
		// dryRun= true4
		tags = { "@test1" }) // ~@test
public class RunCukesTest {
}  
//format = { "pretty","json:target/cucumber.json" },
//html:target/cucumber-html-report