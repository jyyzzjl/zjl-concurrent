package com.zjl.capital2;

public class TaxCalculatorMain {
    public static void main(String[] args) {
        TaxCalculator taxCalculator =new TaxCalculator(1000,500);
        CalculateStrategy calculateStrategy= (salary, bouns) -> salary*0.1+bouns*0.15;
        taxCalculator.setCalculateStrategy(calculateStrategy);
        System.out.println(taxCalculator.calculate());
    }
}
