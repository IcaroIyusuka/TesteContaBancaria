package org.example;

public class ContaBancaria {
    private String titular;
    private double saldo;
    private boolean especial;
    private boolean saquePermitido;

    // Construtor
    public ContaBancaria(String titular, boolean especial) {
        this.titular = titular;
        this.saldo = 0.0;
        this.especial = especial;
        this.saquePermitido = false;
    }

    // Métodos para testes do Cucumber
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setSaquePermitido(boolean saquePermitido) {
        this.saquePermitido = saquePermitido;
    }

    // Método para realizar depósito
    public void depositar(double valor) {
        saldo += valor;
    }

    // Método para realizar saque
    public boolean sacar(double valor) {
        if (especial || (saldo - valor) >= 0 || saquePermitido) {
            saldo -= valor;
            return true; // Saque bem-sucedido
        } else {
            return false; // Saldo insuficiente para realizar o saque
        }
    }

    // Método para consultar o saldo
    public double consultarSaldo() {
        return saldo;
    }
}
