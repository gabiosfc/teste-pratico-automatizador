package br.com.nttdata.teste3.steps;

import br.com.nttdata.teste3.WebDriverConfig;
import br.com.nttdata.teste3.DBOperations;
import br.com.nttdata.teste3.Massas;
import br.com.nttdata.teste3.pages.ProdutoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProdutoStep extends AbstractStep {
    WebDriver driver = WebDriverConfig.driver;

    private final ProdutoPage produtoPage;

    public ProdutoStep() {
        produtoPage = new ProdutoPage(driver);
    }

    @Dado("que estou na pagina inicial do site")
    public void queEstouNaPaginaInicialDoSite() {
    }

    @Quando("eu clicar na opção Special Offer no menu")
    public void clicarEmSpecialOffer(){
        produtoPage.goToSpecialOfferPage();
    }

    @Quando("eu clicar no botão See offer")
    public void euClicarNoBotãoSeeOffer() {
        produtoPage.goToSeeOfferPage();
    }


    @Então("eu devo validar que as especificações do produto estão conforme as informações do banco de dados")
    public void euDevoValidarQueAsEspecificaçõesDoProdutoEstãoConformeAsInformaçõesDoBancoDeDados() throws SQLException {
        Massas productSpecification = produtoPage.productSpecification();
        Massas massaDB = DBOperations.getMassaDados();

        assertEquals(massaDB.getCUSTOMIZATION(), productSpecification.getCUSTOMIZATION());
        assertEquals(massaDB.getDISPLAY(), productSpecification.getDISPLAY());
        assertEquals(massaDB.getDISPLAY_RESOLUTION(), productSpecification.getDISPLAY_RESOLUTION());
        assertEquals(massaDB.getDISPLAY_SIZE(), productSpecification.getDISPLAY_SIZE());
        assertEquals(massaDB.getMEMORY(), productSpecification.getMEMORY());
        assertEquals(massaDB.getOPERATING_SYSTEM(), productSpecification.getOPERATING_SYSTEM());
        assertEquals(massaDB.getPROCESSOR(), productSpecification.getPROCESSOR());
        assertEquals(massaDB.getTOUCHSCREEN(), productSpecification.getTOUCHSCREEN());
        assertEquals(massaDB.getWEIGHT(), productSpecification.getWEIGHT());

        WebDriverConfig.driver.quit();
    }

}
