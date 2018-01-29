package pl.edu.pjatk.tau.lab5.java;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "src/test/java/pl/edu/pjatk/tau/lab5/features/registerStory.feature"
)
public class cucumberTest {
}
