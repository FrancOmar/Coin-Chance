package com.example.root.coin_change;

public class Main {
    public static int[] calcula(double monto, int[] valor) {
        int[] moneda = new int[valor.length];
        for (int i = 0; i < valor.length; i++) {
            while (valor[i] <= monto) {
                moneda[i]++;
                monto = monto - valor[i];
            }
        }
        return moneda;
    }
}
