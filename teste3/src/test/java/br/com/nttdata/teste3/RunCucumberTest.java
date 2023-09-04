package br.com.nttdata.teste3;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(glue = {"br.nttdata.teste3"}, features = {"src/test/resources/features/"})
public class RunCucumberTest {

}
