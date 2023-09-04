package br.com.nttdata.teste3.steps;

import br.com.nttdata.teste3.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public abstract class AbstractStep {


    public AbstractStep(){
        getWebDriver();
    }

    private WebDriver getWebDriver() {

        if(WebDriverConfig.driver == null) {

            ClassLoader classLoader = getClass().getClassLoader();
            File driverFile = new File(classLoader.getResource("msedgedriver.exe").getFile());
            System.setProperty("webdriver.edge.driver", driverFile.getAbsolutePath());

            WebDriverConfig.driver = new EdgeDriver();

            WebDriverConfig.driver.manage().window().maximize();

            WebDriverConfig.driver.get("https://advantageonlineshopping.com/#/");
        }
        return WebDriverConfig.driver;
    }
}
