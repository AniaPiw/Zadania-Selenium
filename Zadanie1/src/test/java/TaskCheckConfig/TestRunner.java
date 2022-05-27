package TaskCheckConfig;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/fillForm.feature",
        plugin = {"pretty","html:out"})

public class TestRunner {
}
