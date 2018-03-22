package org.mvpigs.romans.Interfaz;

public enum NumerosRomanos {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int valorDecimal;

    private NumerosRomanos(int valorDecimal){
        this.valorDecimal = valorDecimal;
    }

    public int getValorDecimal() {
        return this.valorDecimal;
    }
}