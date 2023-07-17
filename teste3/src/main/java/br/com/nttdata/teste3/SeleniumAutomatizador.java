package br.com.nttdata.teste3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class SeleniumAutomatizador {

    public static Massas cenario1() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        Massas massas = productSpecification(driver);

        driver.quit();

        return massas;
    }

    public static Massas cenario2() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        selectColor(driver, "GRAY");

        addToCart(driver);

        driver.quit();

        return massas;
    }

    public static Massas cenario3() {
        WebDriver driver = getWebDriver();

        searchProduct(driver);

        selectProduct(driver);

        selectColor(driver, "BLACK");

        selectUnits(driver);

        addToCart(driver);

        goToCheckoutPage(driver);

        //validate sum VALOR,

        //update no BD para alterar a cor

        return massas;
    }

    public static Massas cenario4() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        addToCart(driver);

        clickCart(driver);

        removeProduct(driver);

        driver.quit();

        return massas;
    }

    private static Massas productSpecification(WebDriver driver) {
        fixedWait(2L, "", false);
        List<WebElement> attributeLabels = driver.findElements(By.cssSelector("div.list label.attr"));
        List<WebElement> attributeValues = driver.findElements(By.cssSelector("div.list label.value"));

        Massas massas = new Massas();

        for (int i = 0; i < attributeLabels.size(); i++) {
            WebElement attributeLabel = attributeLabels.get(i);
            WebElement attributeValue = attributeValues.get(i);

            String label = attributeLabel.getText();
            String value = attributeValue.getText();

            massas = fillMassas(label, value, massas);
        }
        return massas;
    }

    private static WebDriver getWebDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\gsilvcor\\IdeaProjects\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://advantageonlineshopping.com");
        return driver;
    }

    private static void seeOffer(WebDriver driver) {
        fixedWait(2L, "", false);
        WebElement seeOfferButton = driver.findElement(By.xpath("//button[contains(text(), 'SEE OFFER')]"));
        seeOfferButton.click();
    }

    private static void specialOffer(WebDriver driver) {
        fixedWait(5L, "", false);
        WebElement specialOfferLink = driver.findElement(By.linkText("SPECIAL OFFER"));
        specialOfferLink.click();
    }

    private static Massas fillMassas(String label, String value, Massas massas) {
        switch (label){
            case "NAME PRODUCT" :
                massas.setNAME_PRODUCT(value);
                break;
            case "CUSTOMIZATION" :
                massas.setCUSTOMIZATION(value);
                break;
            case "DISPLAY" :
                massas.setDISPLAY(value);
                break;
            case "DISPLAY RESOLUTION" :
                massas.setDISPLAY_RESOLUTION(value);
                break;
            case "DISPLAY SIZE" :
                massas.setDISPLAY_SIZE(value);
                break;
            case "MEMORY" :
                massas.setMEMORY(value);
                break;
            case "OPERATING SYSTEM" :
                massas.setOPERATING_SYSTEM(value);
                break;
            case "PROCESSOR" :
                massas.setPROCESSOR(value);
                break;
            case "TOUCHSCREEN" :
                massas.setTOUCHSCREEN(value);
                break;
            case "WEIGHT" :
                massas.setWEIGHT(value);
                break;
            case "COLOR" :
                massas.setCOLOR(value);
                break;
            default :
                break;
        }
        return massas;
    }

    static void fixedWait(long time, String descriptionToAction, Boolean getSnapshot) {
        try {
            Thread.sleep(time * 1000L);
        } catch (Exception var6) {
            throw new RuntimeException("Erro", var6);
        }
    }
}
