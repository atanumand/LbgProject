package runnerPack;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue="stepDefinations",monochrome=true,plugin= {"html:target/report_UK.html"})
public class RunnerTest {
	

}
