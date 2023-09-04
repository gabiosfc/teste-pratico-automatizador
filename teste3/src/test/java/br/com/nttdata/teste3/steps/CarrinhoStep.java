package br.com.nttdata.teste3.steps;

import br.com.nttdata.teste3.WebDriverConfig;
import br.com.nttdata.teste3.DBOperations;
import br.com.nttdata.teste3.Massas;
import br.com.nttdata.teste3.pages.CarrinhoPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarrinhoStep{
    WebDriver driver = WebDriverConfig.driver;
    private final CarrinhoPage carrinhoPage;

    public CarrinhoStep() {
        carrinhoPage = new CarrinhoPage(driver);
    }

    //cenário 2
    @E("eu alterar a cor do produto para a cor especificada")
    public void euAlterarACorDoProdutoParaACorEspecificada() throws SQLException {
        Massas massa = DBOperations.getMassaDados();
        String colorName = massa.getCOLOR();
        carrinhoPage.selectColor(colorName);
    }

    @E("eu clicar no botão Add to cart")
    public void euClicarNoBotãoAddToCart(){
        carrinhoPage.addToCart();
    }

    @Então("eu devo validar que o produto foi adicionado ao carrinho com a cor selecionada")
    public void euDevoValidarQueOProdutoFoiAdicionadoAoCarrinhoComACorSelecionada() throws SQLException {
        carrinhoPage.clickCartButton();
        String colorSelected = carrinhoPage.productColorAddedToCart();
        Massas massa = DBOperations.getMassaDados();
        String colorDB = massa.getCOLOR();
        assertEquals(colorDB,colorSelected);
    }

    //cenário 4
    @E("eu clicar no ícone do carrinho de compras")
    public void euClicarNoÍconeDoCarrinhoDeCompras(){
        carrinhoPage.clickCartButton();
    }

    @E("eu remover o produto do carrinho de compras")
    public void euRemoverOProdutoDoCarrinhoDeCompras(){

        carrinhoPage.removeProductFromCart();
    }

    @Então("eu devo validar que o carrinho de compras está vazio")
    public void euDevoValidarQueOCarrinhoDeComprasEstáVazio() {
        assertTrue(carrinhoPage.validateEmptyCart());
    }


}
