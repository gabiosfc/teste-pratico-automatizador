package br.com.nttdata.teste1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testRealizarRecarga_null_conta() {
        Telefone telefone = new Telefone("123456789", 0);
        Cliente cliente = new Cliente("Cliente", telefone, null);

        assertFalse(cliente.realizarRecarga(10));
    }

    @Test
    public void testRealizarRecarga_null_telefone() {
        Conta conta = new Conta(100);
        Cliente cliente = new Cliente("Cliente", null, conta);

        assertFalse(cliente.realizarRecarga(10));
    }

    @Test
    public void testRealizarRecarga_saldoInsuficiente() {

        Telefone telefone = new Telefone("123456789", 0);
        Conta conta = new Conta(100);
        Cliente cliente = new Cliente("Cliente", telefone, conta);

        assertFalse(cliente.realizarRecarga(200));
        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());
    }

    @Test
    public void testRealizarRecarga_valorRecargaInvalido() {

        Telefone telefone = new Telefone("123456789", 0);
        Conta conta = new Conta(100);
        Cliente cliente = new Cliente("Cliente", telefone, conta);

        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());

        assertFalse(cliente.realizarRecarga(-20));
        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());

        assertFalse(cliente.realizarRecarga(0));
        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());
    }

    @Test
    public void testRealizarRecarga_success() {

        Telefone telefone = new Telefone("123456789", 0);
        Conta conta = new Conta(100);
        Cliente cliente = new Cliente("Cliente", telefone, conta);

        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());

        assertTrue(cliente.realizarRecarga(50));
        assertEquals(50, cliente.getTelefone().getSaldo());
        assertEquals(50, cliente.getConta().getSaldo());
    }

    @Test
    public void testRealizarRecarga_multiplesScenarios() {

        Telefone telefone = new Telefone("123456789", 0);
        Conta conta = new Conta(100);
        Cliente cliente = new Cliente("Cliente", telefone, conta);

        assertEquals(0, cliente.getTelefone().getSaldo());
        assertEquals(100, cliente.getConta().getSaldo());

        assertTrue(cliente.realizarRecarga(50));
        assertEquals(50, cliente.getTelefone().getSaldo());
        assertEquals(50, cliente.getConta().getSaldo());

        assertFalse(cliente.realizarRecarga(-20));
        assertEquals(50, cliente.getTelefone().getSaldo());
        assertEquals(50, cliente.getConta().getSaldo());

        assertFalse(cliente.realizarRecarga(0));
        assertEquals(50, cliente.getTelefone().getSaldo());
        assertEquals(50, cliente.getConta().getSaldo());

        assertFalse(cliente.realizarRecarga(200));
        assertEquals(50, cliente.getTelefone().getSaldo());
        assertEquals(50, cliente.getConta().getSaldo());
    }

}
