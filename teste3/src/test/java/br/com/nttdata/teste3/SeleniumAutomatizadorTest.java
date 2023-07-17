package br.com.nttdata.teste3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumAutomatizadorTest {

    @Test
    public void teste_success(){
        Massas massas = SeleniumAutomatizador.cenario1();
        Massas massaDB = getMassasFromDB();
        assertEquals(massaDB.getCUSTOMIZATION(), massas.getCUSTOMIZATION());
        assertEquals(massaDB.getDISPLAY(), massas.getDISPLAY());
        assertEquals(massaDB.getDISPLAY_RESOLUTION(), massas.getDISPLAY_RESOLUTION());
        assertEquals(massaDB.getDISPLAY_SIZE(), massas.getDISPLAY_SIZE());
        assertEquals(massaDB.getMEMORY(), massas.getMEMORY());
        assertEquals(massaDB.getOPERATING_SYSTEM(), massas.getOPERATING_SYSTEM());
        assertEquals(massaDB.getPROCESSOR(), massas.getPROCESSOR());
        assertEquals(massaDB.getTOUCHSCREEN(), massas.getTOUCHSCREEN());
        assertEquals(massaDB.getWEIGHT(), massas.getWEIGHT());

    }

    //Mockando busca de massa no BD:
    //insert into massas(NAME_PRODUCT,CUSTOMIZATION,DISPLAY,DISPLAY_RESOLUTION,DISPLAY_SIZE,MEMORY,OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT,COLOR) values("HP PAVILION 15Z TOUCH LAPTOP","Simplicity","15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen","1920x1080","15.6","16GB DDR3 - 2 DIMM","Windows 10","AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics","Yes","5.51 lb","GRAY");
    private Massas getMassasFromDB() {
        Massas massa = new Massas();

        massa.setNAME_PRODUCT("HP PAVILION 15Z TOUCH LAPTOP");
        massa.setCUSTOMIZATION("Simplicity");
        massa.setDISPLAY("15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen");
        massa.setDISPLAY_RESOLUTION("1920x1080");
        massa.setDISPLAY_SIZE("15.6");
        massa.setMEMORY("16GB DDR3 - 2 DIMM");
        massa.setOPERATING_SYSTEM("Windows 10");
        massa.setPROCESSOR("AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics");
        massa.setTOUCHSCREEN("Yes");
        massa.setWEIGHT("5.51 lb");
        massa.setCOLOR("GRAY");

        return massa;

    }
}
