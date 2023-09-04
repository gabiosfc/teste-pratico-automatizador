package br.com.nttdata.teste3.pages;

import br.com.nttdata.teste3.atributes.CheckoutAtributes;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {


    private final CheckoutAtributes checkoutAtributes;
    double valorUnit;

    public CheckoutPage(WebDriver driver) {
        checkoutAtributes = new CheckoutAtributes(driver);
    }

    public void searchProduct() {
        fixedWait(5L, "", false);
        checkoutAtributes.getSearchClick().click();
        checkoutAtributes.getSearchProduct();
    }

    public void selectProduct(){
        fixedWait(5L, "", false);
        checkoutAtributes.getSelectProduct().click();
        fixedWait(5L, "", false);
        valorUnit = checkoutAtributes.getValueProduct();
    }

    public void productQuantity(int quantity){
        fixedWait(5L, "", false);
        for (int i = 1; i < quantity; i++) {
            checkoutAtributes.getProductQuantity().click();
        }
    }

    public void selectColor(String colorName) {
        fixedWait(5L, "", false);
        checkoutAtributes.getSelectColor(colorName).click();
    }

    public void goToCheckoutPage(){
        fixedWait(5L, "", false);
        checkoutAtributes.getCheckoutPage().click();
    }

    public boolean compareTotalPrice(int quantity){
        double sumOfProductPrices = valorUnit * quantity;

        fixedWait(5L, "", false);
        String totalValueText = checkoutAtributes.getTotalValue()
                .getText()
                .trim()
                .replace("$", "")
                .replace(",", "");


        double totalValue = Double.parseDouble(totalValueText);

        return sumOfProductPrices == totalValue;
    }

    private void fixedWait(long time, String descriptionToAction, Boolean getSnapshot) {
        try {
            Thread.sleep(time * 1000L);
        } catch (Exception var6) {
            throw new RuntimeException("Erro", var6);
        }
    }
}
