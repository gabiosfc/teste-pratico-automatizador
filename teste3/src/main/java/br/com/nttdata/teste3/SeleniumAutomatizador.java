package br.com.nttdata.teste3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.util.List;

public class SeleniumAutomatizador {

    Massas massasDB;

    public SeleniumAutomatizador() {
        massasDB = initialInsertDB();
    }

    public Massas getMassasDB() {
        return massasDB;
    }

    public Massas cenario1() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        Massas massas = productSpecification(driver);

        driver.quit();

        return massas;
    }

    public String cenario2() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        selectColor(driver, massasDB.getCOLOR());

        findColorSelected(driver);

        addToCart(driver);

        clickCart(driver);

        String addedColor = getProductColorAddedToCart(driver);

        driver.quit();

        return addedColor;
    }

    public boolean cenario3() {
        WebDriver driver = getWebDriver();

        double valor = searchProduct(driver, massasDB.getNAME_PRODUCT());

        selectColor(driver, "BLACK");

        clickPlusButton(driver, 2);

        addToCart(driver);

        clickCheckout(driver);

        boolean isEqual = compareTotalPrice(driver, valor);

        // mockando o save (repository.save(massasDB))
        massasDB.setCOLOR("BLACK");

        driver.quit();

        return isEqual;
    }

    public boolean cenario4() {
        WebDriver driver = getWebDriver();

        specialOffer(driver);

        seeOffer(driver);

        addToCart(driver);

        clickCart(driver);

        removeProduct(driver);

        boolean isEmptyCart = emptyCart(driver);

        driver.quit();

        return isEmptyCart;
    }


    private boolean compareTotalPrice(WebDriver driver, double valor) {
        int qty = getProductQuantity(driver);

        double sumOfProductPrices = valor * qty;
        fixedWait(4L, "", false);

        WebElement totalValueElement = driver.findElement(By.cssSelector(".totalValue"));
        String totalValueText = totalValueElement.getText().trim().replace("$", "").replace(",", "");

        double totalValue = Double.parseDouble(totalValueText);

        return sumOfProductPrices == totalValue;
    }

    private int getProductQuantity(WebDriver driver) {
        WebElement quantityElement = driver.findElement(By.cssSelector("#toolTipCart table tbody tr td:nth-child(2) label:nth-child(2)"));
        String quantityText = quantityElement.getText().trim().replace("QTY: ", "");
        return Integer.parseInt(quantityText);
    }

    private void clickPlusButton(WebDriver driver, int quantity) {
        WebElement plusButton = driver.findElement(By.cssSelector("div.e-sec-plus-minus div.plus"));
        for (int i = 0; i < quantity; i++) {
            plusButton.click();
        }
    }

    private void clickCheckout(WebDriver driver) {
        fixedWait(2L, "", false);
        WebElement checkoutButton = driver.findElement(By.id("checkOutPopUp"));
        checkoutButton.click();
    }

    private double searchProduct(WebDriver driver, String productName) {
        fixedWait(5L, "", false);
        WebElement searchIcon = driver.findElement(By.cssSelector("div#searchSection a[title='SEARCH']"));
        searchIcon.click();

        WebElement searchInput = driver.findElement(By.cssSelector("input#autoComplete"));
        searchInput.sendKeys(productName);

        fixedWait(5L, "", false);

        WebElement productLink = driver.findElement(By.xpath("//a[@class='product ng-scope' and p[text()='" + productName + "']]"));
        productLink.click();

        fixedWait(5L, "", false);

        WebElement priceElement = driver.findElement(By.cssSelector("div#Description h2"));
        String priceText = priceElement.getText().trim().replace("$", "");
        return Double.parseDouble(priceText);
    }

    private boolean emptyCart(WebDriver driver) {
        WebElement emptyCartLabel = driver.findElement(By.cssSelector("div.bigEmptyCart label"));

        return emptyCartLabel.isDisplayed();
    }

    private void removeProduct(WebDriver driver) {
        WebElement removeProduct = driver.findElement(By.linkText("REMOVE"));
        removeProduct.click();

        fixedWait(2L, "", false);
    }

    private void clickCart(WebDriver driver) {
        WebElement cartLink = driver.findElement(By.id("shoppingCartLink"));
        cartLink.click();

        fixedWait(2L, "", false);
    }

    private String getProductColorAddedToCart(WebDriver driver) {

        WebElement colorElement = driver.findElement(By.cssSelector("span.productColor"));
        String addedColor = colorElement.getAttribute("title");

        driver.navigate().back();

        return addedColor;
    }

    private void addToCart(WebDriver driver) {
        fixedWait(2L, "", false);
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[name='save_to_cart']"));
        addToCartButton.click();
        fixedWait(2L, "", false);
    }

    private void selectColor(WebDriver driver, String colorName) {
        fixedWait(2L, "", false);

        String colorClass = colorName.toUpperCase();
        WebElement colorOption = driver.findElement(By.cssSelector("span.bunny.productColor." + colorClass));
        colorOption.click();
        fixedWait(2L, "", false);
    }

    private String findColorSelected(WebDriver driver) {
        WebElement selectedColorElement = driver.findElement(By.cssSelector("span.bunny.productColor.colorSelected"));
        String colorName = selectedColorElement.getAttribute("title");
        return colorName;
    }

    private void seeOffer(WebDriver driver) {
        fixedWait(2L, "", false);
        WebElement seeOfferButton = driver.findElement(By.xpath("//button[contains(text(), 'SEE OFFER')]"));
        seeOfferButton.click();
    }

    private void specialOffer(WebDriver driver) {
        fixedWait(5L, "", false);
        WebElement specialOfferLink = driver.findElement(By.linkText("SPECIAL OFFER"));
        specialOfferLink.click();
    }

    private Massas fillMassas(String label, String value, Massas massas) {
        switch (label) {
            case "NAME PRODUCT":
                massas.setNAME_PRODUCT(value);
                break;
            case "CUSTOMIZATION":
                massas.setCUSTOMIZATION(value);
                break;
            case "DISPLAY":
                massas.setDISPLAY(value);
                break;
            case "DISPLAY RESOLUTION":
                massas.setDISPLAY_RESOLUTION(value);
                break;
            case "DISPLAY SIZE":
                massas.setDISPLAY_SIZE(value);
                break;
            case "MEMORY":
                massas.setMEMORY(value);
                break;
            case "OPERATING SYSTEM":
                massas.setOPERATING_SYSTEM(value);
                break;
            case "PROCESSOR":
                massas.setPROCESSOR(value);
                break;
            case "TOUCHSCREEN":
                massas.setTOUCHSCREEN(value);
                break;
            case "WEIGHT":
                massas.setWEIGHT(value);
                break;
            case "COLOR":
                massas.setCOLOR(value);
                break;
            default:
                break;
        }
        return massas;
    }

    private void fixedWait(long time, String descriptionToAction, Boolean getSnapshot) {
        try {
            Thread.sleep(time * 1000L);
        } catch (Exception var6) {
            throw new RuntimeException("Erro", var6);
        }
    }

    private Massas productSpecification(WebDriver driver) {
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

    private WebDriver getWebDriver() {
        ClassLoader classLoader = getClass().getClassLoader();
        File driverFile = new File(classLoader.getResource("msedgedriver.exe").getFile());
        System.setProperty("webdriver.edge.driver", driverFile.getAbsolutePath());

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://advantageonlineshopping.com");
        return driver;
    }

    //Mockando busca de massa no BD:
    //insert into massas(NAME_PRODUCT,CUSTOMIZATION,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE,MEMORY,OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT,COLOR) values("HP PAVILION 15Z TOUCH LAPTOP","Simplicity","15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen","1920x1080","15.6","16GB DDR3 - 2 DIMM","Windows 10","AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics","Yes","5.51 lb","GRAY");
    private Massas initialInsertDB() {
        Massas massa = new Massas();

        massa.setNAME_PRODUCT("HP PAVILION 15Z TOUCH LAPTOP");
        massa.setCUSTOMIZATION("Simplicity");
        massa.setDISPLAY("15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen");
        massa.setDISPLAY_RESOLUTION("1920x1080");
        massa.setDISPLAY_SIZE("15.6");
        massa.setMEMORY("16GB DDR3 - 2 DIMM");
        massa.setOPERATING_SYSTEM("Windows 10");
        massa.setPROCESSOR("AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics");
        massa.setTOUCHSCREEN("Yes");
        massa.setWEIGHT("5.51 lb");
        massa.setCOLOR("GRAY");

        return massa;
    }
}
