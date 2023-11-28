package org.example;

public class ContaBancaria {
    private String titular;
    private double saldo;
    private boolean especial;
    private boolean saquePermitido;


    public ContaBancaria(String titular, boolean especial) {
        this.titular = titular;
        this.saldo = 0.0;
        this.especial = especial;
        this.saquePermitido = false;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setSaquePermitido(boolean saquePermitido) {
        this.saquePermitido = saquePermitido;
    }


    public void depositar(double valor) {
        saldo += valor;
    }


    public boolean sacar(double valor) {
        if (especial || (saldo - valor) >= 0 || saquePermitido) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }


    public double consultarSaldo() {
        return saldo;
    }
}
