package com.admin.resource.factory;

public class CurrencyFactory {

    /**
     * Patron de diseño creacional, sirve para construir jerarquia de clases.
     * Encapsula una jerarquia de objetos y reduce el conjunto de conceptos con los que se trabaja.
     * @param country
     * @return 
     */
    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("Singapore")) {
            return new SGDDollar();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }
        throw new IllegalArgumentException("No such currency");
    }
}
