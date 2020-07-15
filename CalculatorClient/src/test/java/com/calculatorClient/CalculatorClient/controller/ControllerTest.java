package com.calculatorClient.CalculatorClient.controller;

import com.calculatorClient.CalculatorClient.service.CalculatorService;
import com.calculatorClient.CalculatorClient.service.CalculatorServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    @Test
    void CalculatorController1() throws JsonProcessingException {

        CalculatorServiceImp service = new CalculatorServiceImp();
        CalculatorController controller = new CalculatorController(service);
        String response = controller.addCalculator("2", "2", "+");
        assertEquals("redirect:/results/4.0", response);
    }

    @Test
    void CalculatorController2() throws JsonProcessingException {

        CalculatorServiceImp service = new CalculatorServiceImp();
        CalculatorController controller = new CalculatorController(service);
        String response = controller.addCalculator("15", "6", "-");
        assertEquals("redirect:/results/9.0", response);
    }

    @Test
    void CalculatorController3() throws JsonProcessingException {

        CalculatorServiceImp service = new CalculatorServiceImp();
        CalculatorController controller = new CalculatorController(service);
        String response = controller.addCalculator("6", "6", "*");
        assertEquals("redirect:/results/36.0", response);
    }

    @Test
    void CalculatorController4() throws JsonProcessingException {

        CalculatorServiceImp service = new CalculatorServiceImp();
        CalculatorController controller = new CalculatorController(service);
        String response = controller.addCalculator("15", "10", "/");
        assertEquals("redirect:/results/1.5", response);
    }

}
