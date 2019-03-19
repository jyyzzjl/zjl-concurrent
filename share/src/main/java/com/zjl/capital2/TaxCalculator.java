package com.zjl.capital2;

public class TaxCalculator {
    private double salary;
    private double bouns;
    private CalculateStrategy calculateStrategy;
    public TaxCalculator(double salary, double bonus){
        this.salary=salary;
        this.bouns=bonus;
    }
    private double calcTax(){
        return calculateStrategy.caculate(salary,bouns);
    }
    public double calculate(){
        return this.calcTax();
    }


    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }
}
