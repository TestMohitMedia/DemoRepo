package Runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\workspace\\FreeCRMCucumberFramework\\src\\main\\java\\Features\\login.feature"
		,glue={"stepDefinations"},
		format={"pretty","html:test-output"}
		)

public class MyRunner {

	
}
