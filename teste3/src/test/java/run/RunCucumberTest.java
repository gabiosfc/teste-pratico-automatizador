package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(glue = {"br.com.nttdata.teste3"},
        features = {"src/test/resources/features/cenarios.feature"},
        tags = "@test")
public class RunCucumberTest {

}

