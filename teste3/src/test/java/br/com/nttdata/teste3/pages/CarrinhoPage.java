package br.com.nttdata.teste3.pages;

import br.com.nttdata.teste3.atributes.CarrinhoAtributes;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {

    private final CarrinhoAtributes carrinhoAtributes;

    public CarrinhoPage(WebDriver driver) {
        carrinhoAtributes = new CarrinhoAtributes(driver);
    }

    public void selectColor(String colorName) {
        fixedWait(5L, "", false);
        carrinhoAtributes.getSelectColor(colorName).click();
    }

    public String productColorAddedToCart() {
        fixedWait(5L, "", false);
        return carrinhoAtributes.getProductColorAddedToCart();
    }

    public void addToCart() {
        fixedWait(5L, "", false);
        carrinhoAtributes.getAddToCartButton().click();
    }

    public void clickCartButton() {
        fixedWait(5L, "", false);
        carrinhoAtributes.getClickCartButton().click();
    }

    public void removeProductFromCart() {
        fixedWait(5L, "", false);
        carrinhoAtributes.getRemoveProductFromCart().click();
    }

    public boolean validateEmptyCart() {
        fixedWait(5L, "", false);
        return carrinhoAtributes.getValidateEmptyCart().isDisplayed();
    }


    private void fixedWait(long time, String descriptionToAction, Boolean getSnapshot) {
        try {
            Thread.sleep(time * 1000L);
        } catch (Exception var6) {
            throw new RuntimeException("Erro", var6);
        }
    }
}
