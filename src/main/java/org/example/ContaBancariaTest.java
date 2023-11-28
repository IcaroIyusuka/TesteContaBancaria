package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaBancariaTest {

    private ContaBancaria contaComum;
    private ContaBancaria contaEspecial;

    @Before
    public void setUp() {
        contaComum = new ContaBancaria("Cliente Comum", false);
        contaEspecial = new ContaBancaria("Cliente Especial", true);
    }

    @Test
    public void testDepositar() {
        contaComum.depositar(1000);
        assertEquals(1000, contaComum.consultarSaldo(), 0.001);
    }

    @Test
    public void testSacarComSaldoSuficienteContaComum() {
        contaComum.depositar(1000);
        assertTrue(contaComum.sacar(500));
        assertEquals(500, contaComum.consultarSaldo(), 0.001);
    }

    @Test
    public void testSacarSemSaldoSuficienteContaComum() {
        assertFalse(contaComum.sacar(500));
        assertEquals(0, contaComum.consultarSaldo(), 0.001);
    }

    @Test
    public void testSacarComSaldoNegativoContaEspecial() {
        contaEspecial.setSaldo(-200);
        assertTrue(contaEspecial.sacar(100));
        assertEquals(-300, contaEspecial.consultarSaldo(), 0.001);
    }

    @Test
    public void testSacarSemSaldoNegativoContaEspecial() {
        assertFalse(contaEspecial.sacar(100));
        assertEquals(-200, contaEspecial.consultarSaldo(), 0.001);
    }
}
