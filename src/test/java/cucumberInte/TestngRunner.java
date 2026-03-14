package cucumberInte;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\cucumberInte",glue="stepImplementation",
monochrome=true,plugin = {"html:target/cucumbertest.html"})
public class TestngRunner extends AbstractTestNGCucumberTests {


}
