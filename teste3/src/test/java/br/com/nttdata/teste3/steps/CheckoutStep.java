package br.com.nttdata.teste3.steps;


import br.com.nttdata.teste3.WebDriverConfig;
import br.com.nttdata.teste3.DBOperations;
import br.com.nttdata.teste3.pages.CheckoutPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class CheckoutStep extends AbstractStep{
    WebDriver driver = WebDriverConfig.driver;
    private final CheckoutPage checkoutPage;
    public CheckoutStep() {
        checkoutPage = new CheckoutPage(driver);
    }

    public static final String NEW_COLOR = "PURPLE";
    int quantity = 2;

    //cenário 3
    @Quando("eu pesquisar pelo produto usando o ícone de pesquisa")
    public void euPesquisarPeloProdutoUsandoOÍconeDePesquisa(){
        checkoutPage.searchProduct();
    }

    @E("eu selecionar o produto pesquisado")
    public void euSelecionarOProdutoPesquisado(){
        checkoutPage.selectProduct();
    }

    @E("eu alterar a cor do produto para uma diferente do BD")
    public void euAlterarACorDoProdutoParaUmaDiferenteDoBD(){
        checkoutPage.selectColor(NEW_COLOR);
    }


    @E("eu alterar a quantidade desejada de produtos")
    public void euAlterarAQuantidadeDesejadaDeProdutos(){
        checkoutPage.productQuantity(quantity);
    }

    @E("eu acessar a página de checkout")
    public void euAcessarAPáginaDeCheckout(){
        checkoutPage.goToCheckoutPage();
    }

    @Então("eu devo validar que a soma dos valores corresponde ao valor total")
    public void euDevoValidarQueASomaDosValoresCOrrespondeAoValorTotal(){
        assertTrue(checkoutPage.compareTotalPrice(quantity));
        WebDriverConfig.driver.quit();
    }

    @E("eu devo alterar a cor no banco de dados conforme cor selecionada")
    public void euDevoAlterarACorNoBancoDeDadosConformeCorSelecionada() throws SQLException {
        DBOperations.alteraCor(NEW_COLOR, 2L);

    }

}
