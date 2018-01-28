package pl.edu.pjatk.tau.lab3.java;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "src/test/java/pl/edu/pjatk/tau/lab3/features/searchTravelStory.feature"
)
public class cucumberTest {
}
