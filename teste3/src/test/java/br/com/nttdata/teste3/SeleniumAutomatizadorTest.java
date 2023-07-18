package br.com.nttdata.teste3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumAutomatizadorTest {

    @Test
    public void teste_cenario1_success(){

        SeleniumAutomatizador seleniumAutomatizador = new SeleniumAutomatizador();

        Massas massaResult = seleniumAutomatizador.cenario1();
        Massas massaDB = seleniumAutomatizador.getMassasDB();

        assertEquals(massaDB.getCUSTOMIZATION(), massaResult.getCUSTOMIZATION());
        assertEquals(massaDB.getDISPLAY(), massaResult.getDISPLAY());
        assertEquals(massaDB.getDISPLAY_RESOLUTION(), massaResult.getDISPLAY_RESOLUTION());
        assertEquals(massaDB.getDISPLAY_SIZE(), massaResult.getDISPLAY_SIZE());
        assertEquals(massaDB.getMEMORY(), massaResult.getMEMORY());
        assertEquals(massaDB.getOPERATING_SYSTEM(), massaResult.getOPERATING_SYSTEM());
        assertEquals(massaDB.getPROCESSOR(), massaResult.getPROCESSOR());
        assertEquals(massaDB.getTOUCHSCREEN(), massaResult.getTOUCHSCREEN());
        assertEquals(massaDB.getWEIGHT(), massaResult.getWEIGHT());
    }

    @Test
    public void teste_cenario2_success() {
        SeleniumAutomatizador seleniumAutomatizador = new SeleniumAutomatizador();

        String result = seleniumAutomatizador.cenario2();
        assertEquals(seleniumAutomatizador.getMassasDB().getCOLOR(), result);
    }

    @Test
    public void teste_cenario3_success() {
        SeleniumAutomatizador seleniumAutomatizador = new SeleniumAutomatizador();

        assertEquals("GRAY", seleniumAutomatizador.getMassasDB().getCOLOR());

        boolean result = seleniumAutomatizador.cenario3();
        assertTrue(result);

        assertEquals("BLACK", seleniumAutomatizador.getMassasDB().getCOLOR());

    }

    @Test
    public void teste_cenario4_success() {
        SeleniumAutomatizador seleniumAutomatizador = new SeleniumAutomatizador();
        boolean result = seleniumAutomatizador.cenario4();
        assertTrue(result);
    }


}
