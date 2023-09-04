package br.com.nttdata.teste3.atributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarrinhoAtributes {

    private final WebDriver driver;

    public CarrinhoAtributes(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getSelectColor(String colorName) {
        String colorClass = colorName.toUpperCase();
        return driver.findElement(By.cssSelector("span.bunny.productColor." + colorClass));
    }

    public String getProductColorAddedToCart(){
        WebElement colorElement = driver.findElement(By.cssSelector("span.productColor"));
        String addedColor = colorElement.getAttribute("title");
        driver.navigate().back();
        return addedColor;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
    }

    public WebElement getClickCartButton() {
        return driver.findElement(By.id("shoppingCartLink"));
    }

    public WebElement getRemoveProductFromCart(){
        return driver.findElement(By.linkText("REMOVE"));
    }

    public WebElement getValidateEmptyCart(){
        return driver.findElement(By.cssSelector("div.bigEmptyCart label"));
    }
}
