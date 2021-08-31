package Exam.Exam;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features="src/test/resources/TestCases.feature",
		 glue= {"Exam.Exam.StepDefinitions"},
		 tags= "@tag1 and @tag2",
		 plugin = {"pretty","html:target/HTMLReports"})
public class RunCucumberTest {

}
