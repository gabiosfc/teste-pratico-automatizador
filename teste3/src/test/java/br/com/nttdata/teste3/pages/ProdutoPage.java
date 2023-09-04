package br.com.nttdata.teste3.pages;

import br.com.nttdata.teste3.Massas;
import br.com.nttdata.teste3.atributes.ProdutoAtributes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProdutoPage {

    private final ProdutoAtributes produtoAtributes;

    public ProdutoPage(WebDriver driver) {
        produtoAtributes = new ProdutoAtributes(driver);
    }

    public void goToSpecialOfferPage() {
        fixedWait(5L, "", false);
        produtoAtributes.getSpecialOfferLink().click();
    }

    public void goToSeeOfferPage() {
        fixedWait(5L, "", false);
        produtoAtributes.getSeeOfferButton().click();
    }

    public Massas productSpecification() {
        fixedWait(5L, "", false);
        List<WebElement> attributeLabels = produtoAtributes.getAttributeLabels();
        List<WebElement> attributeValues = produtoAtributes.getAttributeValues();

        Massas productSpecification = new Massas();

        for (int i = 0; i < attributeLabels.size(); i++) {
            WebElement attributeLabel = attributeLabels.get(i);
            WebElement attributeValue = attributeValues.get(i);

            String label = attributeLabel.getText();
            String value = attributeValue.getText();

            productSpecification = fillProductSpecification(label, value, productSpecification);
        }
        return productSpecification;

    }

    private void fixedWait(long time, String descriptionToAction, Boolean getSnapshot) {
        try {
            Thread.sleep(time * 1000L);
        } catch (Exception var6) {
            throw new RuntimeException("Erro", var6);
        }
    }

    private Massas fillProductSpecification(String label, String value, Massas massas) {
        switch (label) {
            case "NAME PRODUCT" -> massas.setNAME_PRODUCT(value);
            case "CUSTOMIZATION" -> massas.setCUSTOMIZATION(value);
            case "DISPLAY" -> massas.setDISPLAY(value);
            case "DISPLAY RESOLUTION" -> massas.setDISPLAY_RESOLUTION(value);
            case "DISPLAY SIZE" -> massas.setDISPLAY_SIZE(value);
            case "MEMORY" -> massas.setMEMORY(value);
            case "OPERATING SYSTEM" -> massas.setOPERATING_SYSTEM(value);
            case "PROCESSOR" -> massas.setPROCESSOR(value);
            case "TOUCHSCREEN" -> massas.setTOUCHSCREEN(value);
            case "WEIGHT" -> massas.setWEIGHT(value);
            case "COLOR" -> massas.setCOLOR(value);
            default -> {
            }
        }
        return massas;
    }


}
