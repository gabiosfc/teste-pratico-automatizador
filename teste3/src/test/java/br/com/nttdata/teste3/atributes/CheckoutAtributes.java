package br.com.nttdata.teste3.atributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutAtributes {
    private final WebDriver driver;

    public CheckoutAtributes(WebDriver driver) {
        this.driver = driver;
    }

    String productName = "HP PAVILION 15Z TOUCH LAPTOP"; //*******BUSCAR DO BANCO********


    public WebElement getSearchClick(){
        return driver.findElement(By.cssSelector("div#searchSection a[title='SEARCH']"));
    }


    public WebElement getSearchProduct() {
        WebElement searchInput = driver.findElement(By.cssSelector("input#autoComplete"));
        searchInput.sendKeys(productName);
        return searchInput;
    }

    public WebElement getSelectProduct() {
        return driver.findElement(By.xpath("//a[@class='product ng-scope' and p[text()='" + productName + "']]"));
    }

    public WebElement getProductQuantity() {
       return driver.findElement(By.cssSelector("div.e-sec-plus-minus div.plus"));
    }

    public WebElement getSelectColor(String colorName) {
        String colorClass = colorName.toUpperCase();
        return driver.findElement(By.cssSelector("span.bunny.productColor." + colorClass));
    }

    public WebElement getCheckoutPage() {
        return driver.findElement(By.id("checkOutPopUp"));
    }

    public WebElement getTotalValue(){
        return driver.findElement(By.cssSelector(".totalValue"));
    }

    public double getValueProduct() {
        WebElement priceElement = driver.findElement(By.cssSelector("div#Description h2"));
        String priceText = priceElement.getText().trim().replace("$", "");
        return Double.parseDouble(priceText);
    }
}
