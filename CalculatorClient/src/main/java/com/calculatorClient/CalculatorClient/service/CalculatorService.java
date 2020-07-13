package com.calculatorClient.CalculatorClient.service;

import com.calculatorClient.CalculatorClient.model.Calculator;
import com.calculatorClient.CalculatorClient.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CalculatorService {

    public Result calculate(Calculator calculator) throws JsonProcessingException;
}
