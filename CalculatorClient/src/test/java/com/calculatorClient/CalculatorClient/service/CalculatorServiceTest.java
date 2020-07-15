package com.calculatorClient.CalculatorClient.service;

import com.calculatorClient.CalculatorClient.model.Calculator;
import com.calculatorClient.CalculatorClient.model.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void CalculatorService1(){

        Calculator calculator = new Calculator(2, 2, "+");
        CalculatorServiceImp serviceImp = new CalculatorServiceImp();

        Result response = serviceImp.calculate(calculator);
        assertEquals(4.0, response.getResult());

    }

    @Test
    void CalculatorService2(){

        Calculator calculator = new Calculator(8, 2, "-");
        CalculatorServiceImp serviceImp = new CalculatorServiceImp();

        Result response = serviceImp.calculate(calculator);
        assertEquals(6.0, response.getResult());

    }

    @Test
    void CalculatorService3(){

        Calculator calculator = new Calculator(2, 25, "*");
        CalculatorServiceImp serviceImp = new CalculatorServiceImp();

        Result response = serviceImp.calculate(calculator);
        assertEquals(50.0, response.getResult());

    }

    @Test
    void CalculatorService4(){

        Calculator calculator = new Calculator(100, 40, "/");
        CalculatorServiceImp serviceImp = new CalculatorServiceImp();

        Result response = serviceImp.calculate(calculator);
        assertEquals(2.5, response.getResult());

    }
}