package com.calculatorClient.CalculatorClient.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Calculator {

    @NotBlank
    private double xValue;
    @NotBlank
    private double yValue;
    @Pattern(regexp = "^\\+|\\-|\\*|\\/$")
    private String operator;

    public Calculator() {
    }

    public Calculator(double xValue, double yValue, String operator) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.operator = operator;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "xValue=" + xValue + '\'' +
                ", yValue=" + yValue + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
