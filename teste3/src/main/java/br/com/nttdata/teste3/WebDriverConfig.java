package br.com.nttdata.teste3;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverConfig {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

        driver = new EdgeDriver();

        WebDriverConfig.driver.manage().window().maximize();

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
