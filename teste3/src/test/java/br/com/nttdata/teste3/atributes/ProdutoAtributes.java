package br.com.nttdata.teste3.atributes;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import java.util.List;

public class ProdutoAtributes {

    private final WebDriver driver;

    public ProdutoAtributes(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSeeOfferButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'SEE OFFER')]"));
    }

    public WebElement getSpecialOfferLink() {
        return driver.findElement(By.linkText("SPECIAL OFFER"));
    }


    public List<WebElement> getAttributeValues() {
        List<WebElement> attributeValues = driver.findElements(By.cssSelector("div.list label.value"));
        return attributeValues;
    }

    public List<WebElement> getAttributeLabels() {
        List<WebElement> attributeLabels = driver.findElements(By.cssSelector("div.list label.attr"));
        return attributeLabels;
    }


}


